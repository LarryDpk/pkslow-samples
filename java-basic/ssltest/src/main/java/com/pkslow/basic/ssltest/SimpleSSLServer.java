package com.pkslow.basic.ssltest;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SimpleSSLServer {
    public static void main(String[] args) throws Exception {
        SSLContext sslContext = SSLContext.getInstance("TLS");

        String keyStoreFilename = "keystore-ec-secp256k1.p12";
        String keyStorePassword = "changeit";
        String keyStoreType = "PKCS12";
        String keyStoreProvider = null;

        int argindex = 0;
        while (argindex < args.length) {
            String arg = args[argindex++];

            if ("-keystore".equals(arg))
                keyStoreFilename = args[argindex++];
        }

        System.out.println("Using keystore " + keyStoreFilename);
        KeyStore keyStore = SSLUtils.getStore(keyStoreFilename, keyStorePassword, keyStoreType, keyStoreProvider);
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        char[] kpwd;
        if (null != keyStorePassword && 0 < keyStorePassword.length())
            kpwd = keyStorePassword.toCharArray();
        else
            kpwd = null;
        kmf.init(keyStore, kpwd);

        sslContext.init(kmf.getKeyManagers(), SSLUtils.getTrustAllCertsTrustManagers(), new SecureRandom());

        SSLServerSocketFactory sssf = sslContext.getServerSocketFactory();

        final ServerSocket serverSocket;
        serverSocket = sssf.createServerSocket(8443);
        // serverSocket = new ServerSocket(8443);

        Thread serverThread = new Thread() {
            public void run() {
                try {
                    System.out.println("Listening on port " + 8443 + "...");
                    Socket clientSocket = serverSocket.accept();

                    System.out.println("Got a connection. Writing response.");
//                    InputStream in = clientSocket.getInputStream();
//                    in.close();

                    OutputStream out = clientSocket.getOutputStream();
                    out.write("Hello World\n".getBytes("UTF-8"));
                    out.flush();
                    out.close();

                    System.out.println("Shutting down server socket.");
                    serverSocket.close();
                } catch (Exception e) {
                    System.err.println("Server error:");
                    e.printStackTrace(System.err);
                }
            }
        };
        serverThread.start();

        System.out.println("Starting client...");
        SSLSocketFactory ssf = (SSLSocketFactory) sslContext.getSocketFactory();
        final SSLSocket clientSocket = ((SSLSocket) ssf.createSocket("localhost", 8443));
        System.out.println("Starting handshake with server....");
        clientSocket.startHandshake();
        System.out.println("Client completed handshake; closing output stream.");
//        clientSocket.getOutputStream().close();
        System.out.println("Client finished writing; reading server response.");
        InputStream in = clientSocket.getInputStream();
        int c;
        while (-1 != (c = in.read()))
            System.out.write(c);
        System.out.println("Client is finished.");
    }
}