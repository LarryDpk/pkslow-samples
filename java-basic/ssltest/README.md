
copy from [open source ssltest](https://github.com/ChristopherSchultz/ssltest)

# ssltest
A Java-based tool to test SSL connections to servers.

This is a command-line tool to test server support for TLS protocols and ciphers. It can be used to debug problems you may be having with either a Java-based client tool (such as your own Java application) or the server itself (though there are better tools available to test the server if that's all you care about).

The code is meant to be readable, reusable, and instructive. Many TLS-related operations in Java appear to be complicated and verbose, and this code is intended to show Java programmers how to e.g. load key stores and trust stores, configure `SSLSocketFactory` objects, and make secure connections to remote servers.

Note that this code merely *connects* to the server and completes a TLS handshake. It does not perform e.g. any HTTP request or handle any response. That means that it will be equally useful for testing a web server's HTTPS connector as it will be for testing an LDAP server's LDAPS connector.

There are two .java source files which contain everything. You can use Apache `ant` or the `build.sh` script to compile the .java source and bundle it into an executable JAR file, which an be run like this:

```
$ java -jar ssltest.jar [options]
```

The options SSLTest accepts are as follows. Only the hostname of the target server is required, and the default port is 443 (HTTPS).

```
Usage: java class SSLTest [opts] host[:port]

-sslprotocol                 Sets the SSL/TLS protocol to be used (e.g. SSL, TLS, SSLv3, TLSv1.2, etc.)
-enabledprotocols protocols  Sets individual SSL/TLS ptotocols that should be enabled
-ciphers cipherspec          A comma-separated list of SSL/TLS ciphers
-cipherFilter filter         A regular expression containing cipher suite patterns which should be REMOVED from the acceptable list (e.g. '(NULL|anon|RC4)')
-connectonly                 Don't scan; only connect a single time
-keystore                    Sets the key store for connections (for TLS client certificates)
-keystoretype type           Sets the type for the key store
-keystorepassword pass       Sets the password for the key store
-keystoreprovider provider   Sets the crypto provider for the key store
-truststore                  Sets the trust store for connections
-truststoretype type         Sets the type for the trust store
-truststorepassword pass     Sets the password for the trust store
-truststorealgorithm alg     Sets the algorithm for the trust store
-truststoreprovider provider Sets the crypto provider for the trust store
-crlfilename                 Sets the CRL filename to use for the trust store
-check-certificate           Checks certificate trust (default: false)
-no-check-certificate        Ignores certificate errors (default: true)
-verify-hostname             Verifies certificate hostname (default: false)
-no-verify-hostname          Ignores hostname mismatches (default: true)
-showcerts                   Show server's certificate chain information
-showsslerrors               Show SSL/TLS error details
-showhandshakeerrors         Show SSL/TLS handshake error details
-showerrors                  Show all connection error details
-hiderejects                 Only show protocols/ciphers which were successful

-client-info                 Show this client's capabilities and exit
-h -help --help              Shows this help message
```