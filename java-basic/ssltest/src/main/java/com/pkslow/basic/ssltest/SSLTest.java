package com.pkslow.basic.ssltest;

/*
 * SSLTest.java
 *
 * Tests servers for SSL/TLS protocol and cipher support.
 *
 * Copyright (c) 2015 Christopher Schultz
 *
 * Christopher Schultz licenses this file to You under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.crypto.Cipher;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

/**
 * A driver class to test a server's SSL/TLS support.
 * <p>
 * Usage: java SSLTest [opts] host[:port]
 * <p>
 * Try "java SSLTest -h" for help.
 * <p>
 * This tester will attempts to handshake with the target host with all
 * available protocols and ciphers and report which ones were accepted and
 * which were rejected. An HTTP connection is never fully made, so these
 * connections should not flood the host's access log with entries.
 *
 * @author Christopher Schultz
 */
public class SSLTest {
    private static void usage() {
        String command;
        // Are we running from a JAR file? What's it's name?
        URL url = SSLTest.class.getClassLoader().getResource("META-INF/MANIFEST.MF");
        if (null != url && "jar".equals(url.getProtocol())) {
            // Loaded from a JAR file; probably executable
            // jar file name is between first ! and previous / or : of the URL's path
            String source = url.getPath();
            source = source.substring(0, source.indexOf('!'));
            int pos = source.lastIndexOf('/');
            if (pos < 0) {
                pos = source.lastIndexOf(":");
            }
            if (pos < -1) {
                pos = -1;
            }
            source = source.substring(pos + 1);

            command = "-jar " + source;
        } else {
            command = SSLTest.class.getName();
        }

        System.out.println("Usage: java " + command + " [opts] host[:port]");
        System.out.println();
        System.out.println("-sslprotocol                 Sets the SSL/TLS protocol to be used (e.g. SSL, TLS, SSLv3, TLSv1.2, etc.)");
        System.out.println("-enabledprotocols protocols  Sets individual SSL/TLS ptotocols that should be enabled");
        System.out.println("-ciphers cipherspec          A comma-separated list of SSL/TLS ciphers");
        System.out.println("-cipherFilter filter         A regular expression containing cipher suite patterns which should be REMOVED from the acceptable list (e.g. '(NULL|anon|RC4)')");
        System.out.println("-connectonly                 Don't scan; only connect a single time");

        System.out.println("-keystore                    Sets the key store for connections (for TLS client certificates)");
        System.out.println("-keystoretype type           Sets the type for the key store");
        System.out.println("-keystorepassword pass       Sets the password for the key store");
        System.out.println("-keystoreprovider provider   Sets the crypto provider for the key store");

        System.out.println("-truststore                  Sets the trust store for connections");
        System.out.println("-truststoretype type         Sets the type for the trust store");
        System.out.println("-truststorepassword pass     Sets the password for the trust store");
        System.out.println("-truststorealgorithm alg     Sets the algorithm for the trust store");
        System.out.println("-truststoreprovider provider Sets the crypto provider for the trust store");
        System.out.println("-crlfilename                 Sets the CRL filename to use for the trust store");

        System.out.println("-check-certificate           Checks certificate trust (default: false)");
        System.out.println("-no-check-certificate        Ignores certificate errors (default: true)");
        System.out.println("-verify-hostname             Verifies certificate hostname (default: false)");
        System.out.println("-no-verify-hostname          Ignores hostname mismatches (default: true)");

        System.out.println("-showcerts                   Show server's certificate chain information");
        System.out.println("-showsslerrors               Show SSL/TLS error details");
        System.out.println("-showhandshakeerrors         Show SSL/TLS handshake error details");
        System.out.println("-showerrors                  Show all connection error details");
        System.out.println("-hiderejects                 Only show protocols/ciphers which were successful");
        System.out.println();
        System.out.println("-client-info                 Show this client's capabilities and exit");
        System.out.println("-h -help --help              Shows this help message");
    }

    public static void main(String[] args)
            throws Exception {
        /*
        System.out.println("a:" + System.getProperty("jdk.tls.namedCurves"));
        System.out.println("b:" + Security.getProperty("jdk.tls.namedCurves"));
        System.out.println("c:" + System.getProperty("jdk.disabled.namedCurves"));
        System.out.println("d:" + Security.getProperty("jdk.disabled.namedCurves"));
        System.out.println("a:" + System.getProperty("jdk.tls.NamedCurves"));
        System.out.println("b:" + Security.getProperty("jdk.tls.NamedCurves"));
        System.out.println("c:" + System.getProperty("jdk.disabled.NamedCurves"));
        System.out.println("d:" + Security.getProperty("jdk.disabled.NamedCurves"));

        jdk.certpath.disabledAlgorithms
        jdk.tls.disabledAlgorithms
*/
        // Enable all algorithms, protocols, and curves
        // System.setProperty("jdk.tls.client.protocols", "SSLv2Hello,SSLv3,TLSv1,TLSv1.1,TLSv1.2");
        Security.setProperty("jdk.tls.disabledAlgorithms", "");
        System.setProperty("jdk.tls.disabledAlgorithms", "");
//        System.setProperty("jdk.tls.ephemeralDHKeySize", "1024");
        Security.setProperty("jdk.security.legacyAlgorithms", "");
//        System.setProperty("jdk.tls.namedGroups", "secp256r1, secp384r1, secp521r1, sect283k1, sect283r1, sect409k1, sect409r1, sect571k1, sect571r1, secp256k1");
        System.setProperty("jdk.disabled.namedCurves", "");
        Security.setProperty("crypto.policy", "unlimited"); // For Java 9+

        // https://seanjmullan.org/blog/2020/10/13/jdk15
        System.setProperty("jdk.sunec.disableNative", "false");

        int connectTimeout = 0; // default = infinite
        int readTimeout = 1000;

        boolean disableHostnameVerification = true;
        boolean disableCertificateChecking = true;
        boolean hideRejects = false;

        String trustStoreFilename = System.getProperty("javax.net.ssl.trustStore");
        String trustStorePassword = System.getProperty("javax.net.ssl.trustStorePassword");
        String trustStoreType = System.getProperty("javax.net.ssl.trustStoreType");
        String trustStoreProvider = System.getProperty("javax.net.ssl.trustStoreProvider");
        String trustStoreAlgorithm = null;
        String keyStoreFilename = System.getProperty("javax.net.ssl.keyStore");
        String keyStorePassword = System.getProperty("javax.net.ssl.keyStorePassword");
        String keyStoreType = System.getProperty("javax.net.ssl.keyStoreType");
        String keyStoreProvider = System.getProperty("javax.net.ssl.keyStoreProvider");
        String sslProtocol = "TLS";
        String[] sslEnabledProtocols = null; // new String[] { "SSLv2", "SSLv2hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2" };
        String[] sslCipherSuites = null; // Default = default for protocol
        Pattern sslCipherSuitesFilter = null;
        String crlFilename = null;
        boolean showCerts = false;
        boolean connectOnly = false;
        boolean showHandshakeErrors = false;
        boolean showSSLErrors = false;
        boolean showErrors = false;
        boolean dumpClientInfo = false;

        if (args.length < 1) {
            usage();
            System.exit(0);
        }

        int argIndex;
        for (argIndex = 0; argIndex < args.length; ++argIndex) {
            String arg = args[argIndex];

            if (!arg.startsWith("-"))
                break;
            else if ("--".equals(arg))
                break;
            else if ("-no-check-certificate".equals(arg))
                disableCertificateChecking = true;
            else if ("-check-certificate".equals(arg))
                disableCertificateChecking = false;
            else if ("-no-verify-hostname".equals(arg))
                disableHostnameVerification = true;
            else if ("-verify-hostname".equals(arg))
                disableHostnameVerification = false;
            else if ("-sslprotocol".equals(arg))
                sslProtocol = args[++argIndex];
            else if ("-enabledprotocols".equals(arg))
                sslEnabledProtocols = args[++argIndex].split("\\s*,\\s*");
            else if ("-ciphers".equals(arg))
                sslCipherSuites = args[++argIndex].split("\\s*,\\s*");
            else if ("-cipherFilter".equals(arg)) {
                try {
                    sslCipherSuitesFilter = Pattern.compile(args[++argIndex]);
                } catch (PatternSyntaxException pse) {
                    System.err.println("Invalid cipher filter pattern: " + pse.getMessage());
                    System.exit(1);
                }
            } else if ("-connecttimeout".equals(arg))
                connectTimeout = Integer.parseInt(args[++argIndex]);
            else if ("-readtimeout".equals(arg))
                readTimeout = Integer.parseInt(args[++argIndex]);
            else if ("-truststore".equals(arg))
                trustStoreFilename = args[++argIndex];
            else if ("-truststoretype".equals(arg))
                trustStoreType = args[++argIndex];
            else if ("-truststorepassword".equals(arg))
                trustStorePassword = args[++argIndex];
            else if ("-truststoreprovider".equals(arg))
                trustStoreProvider = args[++argIndex];
            else if ("-truststorealgorithm".equals(arg))
                trustStoreAlgorithm = args[++argIndex];
            else if ("-crlfilename".equals(arg))
                crlFilename = args[++argIndex];
            else if ("-keystore".equals(arg))
                keyStoreFilename = args[++argIndex];
            else if ("-keystoretype".equals(arg))
                keyStoreType = args[++argIndex];
            else if ("-keystorepassword".equals(arg))
                keyStorePassword = args[++argIndex];
            else if ("-keystoreprovider".equals(arg))
                keyStoreProvider = args[++argIndex];
            else if ("-showcerts".equals(arg))
                showCerts = true;
            else if ("-showerrors".equals(arg))
                showErrors = showHandshakeErrors = showSSLErrors = true;
            else if ("-showhandshakeerrors".equals(arg))
                showHandshakeErrors = true;
            else if ("-showsslerrors".equals(arg))
                showSSLErrors = true;
            else if ("-connectonly".equals(arg))
                connectOnly = true;
            else if ("-hiderejects".equals(arg))
                hideRejects = true;
            else if ("-client-info".equals(arg))
                dumpClientInfo = true;
            else if ("-list-curves".equals(arg)) {
                listCurves(System.out);
                return;
            } else if ("--help".equals(arg)
                    || "-h".equals(arg)
                    || "-help".equals(arg)) {
                usage();
                System.exit(0);
            } else {
                System.err.println("Unrecognized option: " + arg);
                System.exit(1);
            }
        }

        int port = 443;
        String host;

        if (argIndex == args.length - 1) {
            host = args[argIndex++];
        } else if (argIndex < args.length) {
            System.err.println("Unexpected additional arguments: "
                    + java.util.Arrays.asList(args).subList(argIndex + 1, args.length));

            usage();
            System.exit(1);
            host = "[unknown]";
        } else if (dumpClientInfo) {
            host = "[unknown]";
        } else {
            System.err.println("Expected hostname[:port]");

            usage();

            System.exit(1);
            host = "[unknown]";
        }

        if (null != sslCipherSuites && null != sslCipherSuitesFilter) {
            System.err.println("The -ciphers and -cipherFilter are mutually-exclusive. Please specify only one of the two.");
            System.exit(1);
        }

        // TODO: Does this actually do anything?
        if (disableHostnameVerification)
            SSLUtils.disableSSLHostnameVerification();

        KeyManager[] keyManagers;
        TrustManager[] trustManagers;

        if (null != keyStoreFilename) {
            if (null == keyStoreType)
                keyStoreType = "JKS";

            KeyStore keyStore = SSLUtils.getStore(keyStoreFilename, keyStorePassword, keyStoreType, keyStoreProvider);
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            char[] kpwd;
            if (null != keyStorePassword && 0 < keyStorePassword.length())
                kpwd = keyStorePassword.toCharArray();
            else
                kpwd = null;
            kmf.init(keyStore, kpwd);
            keyManagers = kmf.getKeyManagers();
        } else
            keyManagers = null;

        if (disableCertificateChecking
                || "true".equalsIgnoreCase(System.getProperty("disable.ssl.cert.checks"))) {
            trustManagers = SSLUtils.getTrustAllCertsTrustManagers();
        } else if (null != trustStoreFilename) {
            if (null == trustStoreType)
                trustStoreType = "JKS";

            trustManagers = SSLUtils.getTrustManagers(trustStoreFilename, trustStorePassword, trustStoreType, trustStoreProvider, trustStoreAlgorithm, null, crlFilename);
        } else {
            // Use platform default
            TrustManagerFactory tmf = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            // null keystore == default trust store
            tmf.init((KeyStore) null);

            trustManagers = tmf.getTrustManagers();
        }

        if (dumpClientInfo) {
            System.out.println("Dumping Clilent Info");

            SecureRandom rand = new SecureRandom();
            String[] supportedCipherSuites = getJVMSupportedCipherSuites(sslProtocol, rand);
            TreeSet<String> supportedCipherSuiteSet = new TreeSet<String>();
            for (String cipherSuite : supportedCipherSuites)
                supportedCipherSuiteSet.add(cipherSuite);

            String[] defaultCipherSuites = getJVMDefaultCipherSuites(sslProtocol, rand);

            HashSet<String> defaultCipherSuiteSet = new HashSet<String>(defaultCipherSuites.length);
            for (String cipherSuite : defaultCipherSuites)
                defaultCipherSuiteSet.add(cipherSuite);

            System.out.println("Supported TLS Protocols: ");
            for (String protocol : getJVMSupportedProtocols(sslProtocol, rand)) {
                System.out.print("  ");
                System.out.println(protocol);
            }

            System.out.println("Supported cipher suites:                            [Enabled by Default]");
            for (String cipherSuite : supportedCipherSuiteSet) {
                System.out.print("  ");
                System.out.print(cipherSuite);
                if (defaultCipherSuiteSet.contains(cipherSuite)) {
                    for (int i = 0; i < 50 - cipherSuite.length(); ++i)
                        System.out.print(' ');
                    System.out.println('*');
                } else {
                    System.out.println();
                }
            }

            System.out.println();
            System.out.println("Supported Elliptic Curves, by provider:");
            System.out.println();

            listCurves(System.out);

            System.out.println();

            if (null != keyManagers) {
                System.out.println("Available Client Keys:");
                for (KeyManager keyManager : keyManagers) {
                    if (keyManager instanceof X509KeyManager) {
                        X509KeyManager xkm = (X509KeyManager) keyManager;

                        String alias = xkm.chooseClientAlias(new String[]{"RSA", "DSA", "EC"}, null, null);
                        boolean first = true;
                        for (X509Certificate cert : xkm.getCertificateChain(alias)) {
                            if (first) first = false;
                            else System.out.println("===");
                            dumpCertificate(cert);
                        }
                    } else {
                        System.out.println(keyManager);
                    }
                }
                System.out.println();
            }
            if (null == trustManagers) {
                System.out.println("No trust managers installed?");
            } else if (1 == trustManagers.length && Arrays.equals(trustManagers, SSLUtils.getTrustAllCertsTrustManagers())) {
                System.out.println("[Trust All Server Certificates]");
            } else {
                for (TrustManager trustManager : trustManagers) {
                    if (trustManager instanceof X509TrustManager) {
                        X509TrustManager xtm = (X509TrustManager) trustManager;

                        System.out.println("Trusted Certificates:");
                        X509Certificate[] issuers = xtm.getAcceptedIssuers();
                        if (null == issuers || 0 == issuers.length) {
                            System.out.println("This trust manager evidently contains no trusted issuers, or the trust store could not be opened.");
                        } else {
                            boolean first = true;
                            for (X509Certificate cert : issuers) {
                                if (first) first = false;
                                else System.out.println("===");
                                dumpCertificate(cert);
                            }
                        }
                    } else {
                        System.out.println(trustManager);
                    }
                }
            }
            System.exit(1);

        }

        int pos = host.indexOf(':');
        if (pos > 0) {
            port = Integer.parseInt(host.substring(pos + 1));
            host = host.substring(0, pos);
        }

        try {
            InetAddress[] iaddrs = InetAddress.getAllByName(host);
            if (null == iaddrs || 0 == iaddrs.length) {
                System.err.println("Unknown hostname: " + host);
                System.exit(1);
            }
            if (1 == iaddrs.length)
                System.out.println("Host [" + host + "] resolves to address [" + iaddrs[0].getHostAddress() + "]");
            else {
                System.out.print("Host [" + host + "] resolves to addresses ");
                for (int i = 0; i < iaddrs.length; ++i) {
                    if (i > 0) System.out.print(", ");
                    System.out.print("[" + iaddrs[i].getHostAddress() + "]");
                }
                System.out.println();
            }
        } catch (UnknownHostException uhe) {
            System.err.println("Unknown hostname: " + host);
            System.exit(1);
        }

        InetSocketAddress address = new InetSocketAddress(host, port);
        if (address.isUnresolved()) {
            System.err.println("Unknown hostname: " + host);
            System.exit(1);
        }

        List<String> supportedProtocols;

        if (null == sslEnabledProtocols) {
            // Auto-detect supported protocols
            ArrayList<String> protocols = new ArrayList<String>();
            // TODO: Allow the specification of a specific provider (or set?)
            for (Provider provider : Security.getProviders()) {
                for (Object prop : provider.keySet()) {
                    String key = (String) prop;
                    if (key.startsWith("SSLContext.")
                            && !"SSLContext.Default".equals(key)
                            && key.matches(".*[0-9].*"))
                        protocols.add(key.substring("SSLContext.".length()));
                    else if (key.startsWith("Alg.Alias.SSLContext.")
                            && key.matches(".*[0-9].*"))
                        protocols.add(key.substring("Alg.Alias.SSLContext.".length()));
                }
            }
            Collections.sort(protocols); // Should give us a nice sort-order by default
            System.out.println("Auto-detected client-supported protocols: " + protocols);
            supportedProtocols = protocols;
            sslEnabledProtocols = supportedProtocols.toArray(new String[supportedProtocols.size()]);
        } else {
            supportedProtocols = new ArrayList<String>(Arrays.asList(sslEnabledProtocols));
        }

        // Warn about operating under limited cryptographic controls.
        if (Integer.MAX_VALUE > Cipher.getMaxAllowedKeyLength("foo"))
            System.err.println("[warning] Client is running under LIMITED cryptographic controls. Consider installing the JCE Unlimited Strength Jurisdiction Policy Files.");

        SecureRandom rand = new SecureRandom();

        if (!connectOnly) {
            System.out.println("Testing server " + host + ":" + port);

            String reportFormat = "%9s %8s %s%n";
            String errorReportFormat = "%9s %8s %s %s%n";

            System.out.print(String.format(reportFormat, "Supported", "Protocol", "Cipher"));

            HashSet<String> cipherSuites = new HashSet<String>();

            boolean stop = false;

            for (int i = 0; i < sslEnabledProtocols.length && !stop; ++i) {
                String protocol = sslEnabledProtocols[i];

                String[] supportedCipherSuites = null;

                try {
                    supportedCipherSuites = getJVMSupportedCipherSuites(protocol, rand);
                } catch (NoSuchAlgorithmException nsae) {
                    System.out.print(String.format(reportFormat, "-----", protocol, " Not supported by client"));
                    supportedProtocols.remove(protocol);
                    continue;
                } catch (Exception e) {
                    e.printStackTrace();
                    continue; // Skip this protocol
                }

                // Restrict cipher suites to those specified by sslCipherSuites
                cipherSuites.clear();
                cipherSuites.addAll(Arrays.asList(supportedCipherSuites));
                if (null != sslCipherSuites)
                    cipherSuites.retainAll(Arrays.asList(sslCipherSuites));
                else if (null != sslCipherSuitesFilter) {
                    for (Iterator<String> j = cipherSuites.iterator(); j.hasNext(); ) {
                        String cipherSuite = j.next();

                        if (sslCipherSuitesFilter.matcher(cipherSuite).find()) {
                            j.remove();
                        }
                    }
                }

                if (cipherSuites.isEmpty()) {
                    System.err.println("No overlapping cipher suites found for protocol " + protocol);
                    supportedProtocols.remove(protocol);
                    continue; // Go to the next protocol
                }

                for (Iterator<String> j = cipherSuites.iterator(); j.hasNext() && !stop; ) {
                    String cipherSuite = j.next();
                    String status;

                    SSLSocketFactory sf = SSLUtils.getSSLSocketFactory(protocol,
                            new String[]{protocol},
                            new String[]{cipherSuite},
                            rand,
                            trustManagers,
                            keyManagers);

                    SSLSocket socket = null;
                    String error = null;

                    try {
                        socket = createSSLSocket(address, host, port, connectTimeout, readTimeout, sf);
/*
socket.addHandshakeCompletedListener(new HandshakeCompletedListener() {

    @Override
    public void handshakeCompleted(HandshakeCompletedEvent evt)
    {
        System.err.println("======== COMPLETED HANDSHAKE, SESSION=" + evt.getSession());
        System.err.println("HANDSHAKE THREADNAME: " + Thread.currentThread().getName());
        SSLSocket socket = evt.getSocket();
        System.err.println("parameters=" + socket.getSSLParameters());
        System.err.println(java.util.Arrays.asList(socket.getSSLParameters().getProtocols()));
        System.err.println(java.util.Arrays.asList(socket.getSSLParameters().getCipherSuites()));
        System.err.println("constraints=" + socket.getSSLParameters().getAlgorithmConstraints());
        System.err.println("endpoint id algo=" + socket.getSSLParameters().getEndpointIdentificationAlgorithm());
        System.err.println("server names=" + socket.getSSLParameters().getServerNames());
try
{
    System.err.println("principal=" + evt.getPeerPrincipal());
        for(Certificate cert : evt.getSession().getPeerCertificates())
        {
            if("X.509".equals(cert.getType()))
            {
                X509Certificate x509cert = (X509Certificate)cert;
                System.out.println("==HS== certificate subject=" + x509cert.getSubjectDN());
                if(null != x509cert.getSigAlgParams())
                    System.out.println("==HS== parameters: " + Arrays.asList(x509cert.getSigAlgParams()));
            }
            else
                System.out.println("==HS== Unrecognized cert type: " + cert.getType());

            PublicKey pk = cert.getPublicKey();
            if("RSA".equals(pk.getAlgorithm()))
            {
                RSAPublicKey rsa = (RSAPublicKey)pk;
                System.out.println("==HS== RSA mod length: " + rsa.getModulus().bitLength());
                System.out.println("==HS== RSA format " + rsa.getFormat());
                System.out.println("==HS== RSA encoded: " + Arrays.asList(rsa.getEncoded()));
            } else {
                System.out.println("==HS== UNKNOWN Certificate algorithm: " + pk.getAlgorithm());
            }
            System.out.println("==HS== Implementing PK class: " + pk.getClass());
        }
}
catch (SSLPeerUnverifiedException e)
{
    e.printStackTrace();
}
    } });
//    */
                        socket.startHandshake();

                    /*
                    System.err.println(socket.getSSLParameters());//.getEndpointIdentificationAlgorithm()
                    System.err.println(java.util.Arrays.asList(socket.getSSLParameters().getProtocols()));
                    System.err.println(java.util.Arrays.asList(socket.getSSLParameters().getCipherSuites()));
                    System.err.println(socket.getSSLParameters().getAlgorithmConstraints());
                    System.err.println(socket.getSSLParameters().getEndpointIdentificationAlgorithm());
                    System.err.println(socket.getSSLParameters().getServerNames());
                    //System.err.println("cert 0: " + socket.getSession().getPeerCertificates()[0]);
                    System.err.println(socket.getSession());
*/

                        SSLSession sess = socket.getSession();
//                    Thread.currentThread().sleep(200);System.exit(0);
//                    System.err.println("NORMAL SESSION = " + sess);
//                    System.err.println("MAIN THREADNAME: " + Thread.currentThread().getName());
                        assert protocol.equals(sess.getProtocol());
                        assert cipherSuite.equals(sess.getCipherSuite());

                    /*
                    Certificate[] certs = sess.getPeerCertificates();
                    int certCount = certs.length;
                    Certificate cert = certs[certCount - 1];
                    // for(Certificate cert : certs)
                    {
                        //                        System.out.println("cert format: " + cert.getPublicKey().getFormat());
                        //                        System.out.println("Implementing class: " + cert.getClass().getName());
                        if("X.509".equals(cert.getType()))
                        {
                            X509Certificate x509cert = (X509Certificate)cert;
                            if(null != x509cert.getSigAlgParams())
                                System.out.println("parameters: " + Arrays.asList(x509cert.getSigAlgParams()));
                        }
                        else
                            System.out.println("Unrecognized cert type: " + cert.getType());
                        PublicKey pk = cert.getPublicKey();
                        if("RSA".equals(pk.getAlgorithm()))
                        {
                            RSAPublicKey rsa = (RSAPublicKey)pk;
                            System.out.println("RSA mod length: " + rsa.getModulus().bitLength());
                        } else {
                            System.out.println("UNKNOWN Certificate algorithm: " + pk.getAlgorithm());
                        }
                        System.out.println("Implementing PK class: " + pk.getClass());
                    }
*/
                        status = "Accepted";
                    } catch (SSLHandshakeException she) {
                        Throwable cause = she.getCause();
                        if (null != cause && cause instanceof CertificateException) {
                            status = "Untrusted";
                            error = "Server certificate is not trusted. All other connections will fail similarly.";
                            stop = true;
                        } else
                            status = "Rejected";

                        if (showHandshakeErrors)
                            error = "SHE: " + she.getLocalizedMessage() + ", type=" + she.getClass().getName() + ", nested=" + she.getCause();
                    } catch (SSLException ssle) {
                        if (showSSLErrors)
                            error = "SE: " + ssle.getLocalizedMessage();

                        status = "Rejected";
                    } catch (SocketTimeoutException ste) {
                        if (showErrors)
                            error = "SocketException" + ste.getLocalizedMessage();

                        status = "Timeout";
                    } catch (SocketException se) {
                        if (showErrors)
                            error = se.getLocalizedMessage();

                        status = "Failed";
                    } catch (IOException ioe) {
                        if (showErrors)
                            error = ioe.getLocalizedMessage();

                        ioe.printStackTrace();
                        status = "Failed";
                    } catch (Exception e) {
                        if (showErrors)
                            error = e.getLocalizedMessage();

                        e.printStackTrace();
                        status = "Failed";
                    } finally {
                        if (null != socket) try {
                            socket.close();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }

                    if (null != error)
                        System.out.print(String.format(errorReportFormat,
                                status,
                                protocol,
                                cipherSuite,
                                error));
                    else if (!hideRejects || !"Rejected".equals(status))
                        System.out.print(String.format(reportFormat,
                                status,
                                protocol,
                                cipherSuite));
                }
            }

            if (supportedProtocols.isEmpty()) {
                System.err.println("This client supports none of the requested protocols: "
                        + Arrays.asList(sslEnabledProtocols));
                System.err.println("Exiting.");
                System.exit(1);
            }
        }

        // Now get generic and allow the server to decide on the protocol and cipher suite
        String[] protocolsToTry = supportedProtocols.toArray(new String[supportedProtocols.size()]);

        // If the user didn't provide a specific set of cipher suites,
        // use the system's *complete* set of supported cipher suites.
        if (null == sslCipherSuites)
            sslCipherSuites = getJVMSupportedCipherSuites(sslProtocol, rand);

        // Java 9-10 doesn't seem to like having any DTLS protocols
        // in the list of enabled protocols.
        // Java 11 seems okay with DTLS being in the mix.
        String javaVersion = System.getProperty("java.vm.specification.version", null);
        if (null != javaVersion) {
            double jv = Double.parseDouble(javaVersion);
            if (jv == 9 || jv == 10) {
                ArrayList<String> cleansedProtocolNames = new ArrayList<String>(protocolsToTry.length);
                for (String protocol : protocolsToTry)
                    if (!protocol.startsWith("DTLS"))
                        cleansedProtocolNames.add(protocol);

                protocolsToTry = cleansedProtocolNames.toArray(new String[cleansedProtocolNames.size()]);
            }
        }

        SSLSocketFactory sf = SSLUtils.getSSLSocketFactory(sslProtocol,
                protocolsToTry,
                sslCipherSuites,
                rand,
                trustManagers,
                keyManagers);

        SSLSocket socket = null;

        try {
            socket = createSSLSocket(address, host, port, connectTimeout, readTimeout, sf);

            try {
                socket.startHandshake();

                SSLSession sess = socket.getSession();
                System.out.print("Given this client's capabilities ("
                        + supportedProtocols
                        + "), the server prefers protocol=");
                System.out.print(sess.getProtocol());
                System.out.print(", cipher=");
                System.out.println(sess.getCipherSuite());

                if (showCerts) {
                    System.out.println("Attempting to check certificates:");
                    Certificate[] certs = sess.getPeerCertificates();
                    int i = 1;
                    for (Certificate cert : certs) {
                        String certType = cert.getType();
                        if ("X.509".equals(certType)) {
                            System.out.println("Certificate " + (i++) + ": " + getCertificateType((X509Certificate) cert));
                            X509Certificate x509 = (X509Certificate) cert;
                            dumpCertificate(x509);
                        } else {
                            System.out.println("Unknown certificate type (" + certType + "): " + cert);
                        }
                    }

                    if (certs instanceof X509Certificate[]) {
                        if (checkTrust((X509Certificate[]) certs, trustManagers, getAuthType(sess.getCipherSuite()))) {
                            System.out.println("Certificate chain is trusted");
                        } else {
                            System.out.println("Certificate chain is UNTRUSTED");
                        }
                    } else {
                        System.out.println("Cannot check certificate chain; not X509Certificate array");
                    }
                }
            } catch (SocketException se) {
                System.out.println("Error during connection handshake for protocols "
                        + supportedProtocols
                        + ": server likely does not support any of these protocols.");

                if (showCerts)
                    System.out.println("Unable to show server certificate without a successful handshake.");
            } catch (SSLHandshakeException she) {
                Throwable cause = she.getCause();
                if (cause instanceof CertificateException)
                    System.out.println("Server certificate is not trusted, cannot complete handshake. Try -no-check-certificate");

                if (showCerts)
                    System.out.println("Unable to show server certificate without a successful handshake.");
            }
        } finally {
            if (null != socket) try {
                socket.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

/*
        System.out.println("Attempting to determine the server's SSLv2 capabilities using OpenSSL s_client...");
        // Try an SSLv2 connection with OpenSSL's s_client, just for kicks.
        Process p = Runtime.getRuntime().exec(new String[] {
                "openssl", "s_client",
                "-ssl2",
                "-connect", host + ":" + port }
        );
        // Make sure this process isn't trying to read from stdin
        OutputStream out = p.getOutputStream();
        out.close();

        InputStream stdout = p.getInputStream();
        InputStream stderr = p.getErrorStream();

        // Use NIO so we don't block like an idiot
        ReadableByteChannel in = Channels.newChannel(stdout);
        ReadableByteChannel err = Channels.newChannel(stderr);
        ByteBuffer buf = ByteBuffer.allocate(4096);
        StringBuilder outsb = new StringBuilder();
        StringBuilder errsb = new StringBuilder();

        byte[] buffer = new byte[4096];
        boolean outDone = false, errDone = false;

        do
        {
            int read;
*/
/*
            if(!outDone) {
                read = in.read(buf);
                if(-1 != read) {
                    buf.flip();
                    buf.get(buffer, 0, read);
                    System.out.println("Read " + read + " from stdout");
                    outsb.append(new String(buffer, 0, read));
                } else {
                    outDone = true;
                    // System.out.println("Output stream is done");
                }

                buf.flip();
            }
*/
/*
outDone = true;
            if(!errDone) {
                read = err.read(buf);
                if(-1 == read) {
                    buf.flip();
                    buf.get(buffer, 0, read);
                    System.out.println("Read " + read + " from stderr");
                    errsb.append(new String(buffer, 0, read));
                } else {
                    errDone = true;
                    // System.out.println("Error stream is done");
                }

                buf.flip();
            }

            Thread.sleep(100);
        } while(!outDone && !errDone);
        int status = p.waitFor();
        System.out.println("finally read " + err.read(buf) + " from stderr");
        if(0 < outsb.length())
            System.out.print("STDOUT: " + outsb);
        if(0 < errsb.length())
            System.out.print("STDERR: " + errsb);
        System.out.println("Process exit code was: " + status);
        if(outsb.toString().contains("SSL handshake")) {
            System.out.println("!!! host " + host + " supports SSLv2");
        }
*/
    }

    public static void listCurves(PrintStream out) throws Exception {
        Provider[] ecProviders = Security.getProviders("AlgorithmParameters.EC");
        if (null != ecProviders) {
            for (Provider provider : ecProviders) {
                // Unfortunately, we have to parse this string
                out.println("Provider: " + provider);
                String list = provider.getService("AlgorithmParameters", "EC").getAttribute("SupportedCurves");
                // Be nice and sort the list of curves
                TreeMap<String, String> sorted = new TreeMap<String, String>();
                for (String curve : list.split("\\|"))
                    sorted.put(curve.toLowerCase(), curve);
                for (String curve : sorted.values())
                    out.println(curve);
            }
        }

    }

    private static SSLSocket createSSLSocket(InetSocketAddress address,
                                             String host,
                                             int port,
                                             int readTimeout,
                                             int connectTimeout,
                                             SSLSocketFactory sf)
            throws IOException {
        //
        // Note: SSLSocketFactory has several create() methods.
        // Those that take arguments all connect immediately
        // and have no options for specifying a connection timeout.
        //
        // So, we have to create a socket and connect it (with a
        // connection timeout), then have the SSLSocketFactory wrap
        // the already-connected socket.
        //
        Socket sock = new Socket();
        sock.setSoTimeout(readTimeout);
        sock.connect(address, connectTimeout);

        // Wrap plain socket in an SSL socket
        return (SSLSocket) sf.createSocket(sock, host, port, true);
    }

    private static String[] getJVMSupportedCipherSuites(String protocol, SecureRandom rand)
            throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance(protocol);

        sc.init(null, null, rand);

        return sc.getSocketFactory().getSupportedCipherSuites();
    }

    private static String[] getJVMDefaultCipherSuites(String protocol, SecureRandom rand)
            throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance(protocol);

        sc.init(null, null, rand);

        return sc.getSocketFactory().getDefaultCipherSuites();
    }

    private static String[] getJVMSupportedProtocols(String protocol, SecureRandom rand)
            throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance(protocol);

        sc.init(null, null, rand);

        return sc.getSupportedSSLParameters().getProtocols();
    }

    private static String getAuthType(String cipherSuite) {
        // Looks like we can just use "UNKNOWN" all the time and Java will
        // figure it out.
        return "UNKNOWN";

/*
        if(cipherSuite.startsWith("TLS_")
           || cipherSuite.startsWith("SSL_")) {
            // DHE_DSS DHE_RSA DH_DSS DH_RSA ECDHE_ECDSA ECDHE_RSA ECDH_ECDSA ECDH_RSA RSA RSA_EXPORT UNKNOWN
            int pos = cipherSuite.indexOf("_WITH_");
            if(pos > 0) {
                return cipherSuite.substring(4, pos);
            } else {
                // TLSv1.3 ciphers don't have _WITH_ anymore and always use ECDHE_E
                return "UNKNOWN";
            }
        } else {
            throw new IllegalArgumentException("Cannot determine auth type from unrecognizerd cipher suite: " + cipherSuite);
        }
*/
/*
        if(cipherSuite.startsWith("TLS_")
           || cipherSuite.startsWith("SSL_")) {
            // DHE_DSS DHE_RSA DH_DSS DH_RSA ECDHE_ECDSA ECDHE_RSA ECDH_ECDSA ECDH_RSA RSA RSA_EXPORT UNKNOWN
            if(cipherSuite.startsWith("ECDHE_ECDSA_")) {
                return "ECDHE_ESDSA";
            } else if(cipherSuite.startsWith("ECDHE_RSA_")) {
                return "ECDHE_RSA";
            } else if(cipherSuite.startsWith("ECDH_ECDSA_")) {
                return "ECDH_ESDSA";
            } else if(cipherSuite.startsWith("RSA_EXPORT_")) {
                return "RSA_EXPORT";
            } else if(cipherSuite.startsWith("RSA_")) {
                return "RSA";
            } else if(cipherSuite.startsWith("")) {
                return "";
            } else if(cipherSuite.startsWith("")) {
                return "";
            } else {
                throw new UnsupportedOperationException("Cannot determine auth type from cipher suite: " + cipherSuite);
            }
        } else {
            throw new IllegalArgumentException("Cannot determine auth type from unrecognizerd cipher suite: " + cipherSuite);
        }
*/
    }

    private static boolean checkTrust(X509Certificate[] chain, TrustManager[] trustManagers, String authType) {
        if (null == trustManagers) {
            System.out.println("NOTE: No trust managers configured; all certs will appear to be 'untrusted'");
            return false;
        }

        if (1 == trustManagers.length
                && trustManagers[0] instanceof SSLUtils.TrustAllTrustManager)
            System.out.println("NOTE: Certificate chain will be trusted because all certificates are trusted");

        for (TrustManager tm : trustManagers) {
            if (tm instanceof X509TrustManager) {
                try {
                    ((X509TrustManager) tm).checkServerTrusted(chain, authType);
                    return true;
                } catch (CertificateException ce) {
                    // Check the whole chain to see where we failed
                    for (X509Certificate cert : chain) {
                        try {
                            ((X509TrustManager) tm).checkServerTrusted(new X509Certificate[]{cert}, authType);
                            System.out.println("Cert " + cert.getSubjectX500Principal().getName() + " is trusted");
                        } catch (CertificateException ce2) {
                            System.out.println("Cert " + cert.getSubjectX500Principal().getName() + " is UNTRUSTED");
                        }
                    }

                    for (X509Certificate ca : ((X509TrustManager) tm).getAcceptedIssuers()) {
                        System.out.println("Would have trusted " + ca.getSubjectX500Principal().getName());
                    }
                    return false;
                }
            }
        }

        return false;
    }

    static void dumpCertificate(X509Certificate cert) throws GeneralSecurityException {
        System.out.print("  Subject: ");
        System.out.println(cert.getSubjectDN());
        Collection<List<?>> altNames = cert.getSubjectAlternativeNames();
        if (null != altNames && !altNames.isEmpty()) {
            System.out.print("Subject Alternative Names (SANs): ");

            // NOTE: cert.getSubjectAlternativeNames is a really bad API
            boolean needsComma = false;
            for (List<?> sanList : altNames) {
                if (null != sanList && !sanList.isEmpty() && sanList.size() > 1) {
                    if (needsComma) System.out.print(", ");
                    else needsComma = true;
                    // Ignore sanList[0]
                    // sanList[1] is either a String or a byte array :(
                    Object thing = sanList.get(1);
                    if (thing instanceof String) {
                        System.out.print(thing);
                    } else {
                        System.out.print("[binary]"); // TODO
                    }
                }
            }
            System.out.println();
        }

        System.out.print("  Issuer: ");
        System.out.println(cert.getIssuerDN());
        if (null != cert.getIssuerUniqueID()
                && null != cert.getSubjectUniqueID()
                && Arrays.equals(cert.getIssuerUniqueID(), cert.getSubjectUniqueID())) {
            System.out.println("Subject unique id: ");
            for (boolean b : cert.getSubjectUniqueID()) {
                System.out.print(b ? 1 : 0);
            }
            System.out.println();
            System.out.println("         (Self-Signed Certificate)");
        }

        System.out.print("  Signature Algorithm: ");
        System.out.println(cert.getSigAlgName());

        System.out.print("  SHA-256 Fingerprint: ");
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] sig = md.digest(cert.getEncoded());

        System.out.println(toHexString(sig, ":"));

        System.out.println("  Valid from " + cert.getNotBefore() + " until " + cert.getNotAfter());
        Date now = new Date();
        System.out.println("  Currently valid: " + (cert.getNotBefore().before(now) && cert.getNotAfter().after(now)));
        String encoded = getEncodedCertificate(cert);
        if (null != encoded) {
            System.out.println(encoded);
        }
    }

    static String getEncodedCertificate(Certificate cert) throws CertificateEncodingException {
        String encoded = base64Encode(cert.getEncoded());
        if (null == encoded) {
            return null;
        } else {
            return new StringBuilder("-----BEGIN CERTIFICATE-----\n")
                    .append(encoded)
                    .append("\n-----END CERTIFICATE-----")
                    .toString()
                    ;
        }
    }

    static String base64Encode(byte[] bytes) {
        // YUCK: Plumbing for a base64 encoder is really ugly.
        //
        // This is being done so we can compile this source file
        // on Java 1.1 - 1.7 (using the sun.mistc encoder)
        // or on 1.8 or later (using the java.util encoder)
        // without any errors.

        try {
            Class<?> b64 = Class.forName("java.util.Base64");

            Method m = b64.getMethod("getMimeEncoder", new Class[]{int.class, byte[].class});

            Object enc = m.invoke(null, 64, new byte[]{'\n'});

            m = enc.getClass().getMethod("encodeToString", new Class[]{byte[].class});

            return (String) m.invoke(enc, bytes);
        } catch (ClassNotFoundException cnfe) {
            // Old-school base64 encoder available?
            try {
                Class<?> b64 = Class.forName("sun.misc.BASE64Encoder");

                Object enc = b64.getDeclaredConstructor().newInstance();

                Method m = b64.getMethod("encode", new Class[]{byte[].class});

                return (String) m.invoke(enc, bytes);
            } catch (Exception e) {
                // Give up
                return null;
            }
        } catch (Exception e) {
            // Give up
            e.printStackTrace();

            return null;
        }
    }

    static String getCertificateType(X509Certificate cert) {
        PublicKey pubKey = cert.getPublicKey();

        if (pubKey instanceof RSAPublicKey) {
            return ((RSAPublicKey) pubKey).getModulus().bitLength() + "-bit RSA";
        } else if (pubKey instanceof ECPublicKey) {
            ECParameterSpec params = ((ECPublicKey) pubKey).getParams();
            if (null != params) {
                return params.getOrder().bitLength() + "-bit Elliptic-curve";
            } else {
                return "Unknown strength Elliptic-curve";
            }
        } else if (pubKey instanceof DSAPublicKey) {
            DSAParams params = ((DSAPublicKey) pubKey).getParams();
            if (null != params) {
                return params.getP().bitLength() + "-bit DSA";
            } else {
                return ((DSAPublicKey) pubKey).getY().bitLength() + "-bit DSA";
            }
        } else {
            return "Other X.509 key, class=" + pubKey.getClass().getName();
        }
    }

    static final char[] hexChars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f'};

    static String toHexString(byte[] bytes, String separator) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);

        boolean first = true;
        for (byte b : bytes) {
            if (first) first = false;
            else if (null != separator) sb.append(separator);
            sb.append(hexChars[(b >> 4) & 0x0f])
                    .append(hexChars[b & 0x0f]);
        }

        return sb.toString();
    }
}