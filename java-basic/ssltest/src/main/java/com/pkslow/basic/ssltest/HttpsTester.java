package com.pkslow.basic.ssltest;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class HttpsTester {
    public static void main(String[] args)
            throws Exception {
        SSLSocketFactory ssf = SSLUtils.getSSLSocketFactory("TLS",
                new String[]{"TLSv1.2", "TLSv1.3"},
                null, null, SSLUtils.getTrustAllCertsTrustManagers(), null);

        URL url = new URL("https://www.pkslow.com/");

        fetch(ssf, url);
        fetch(ssf, url);
        fetch(ssf, url);
        fetch(ssf, url);
    }

    private static void fetch(SSLSocketFactory ssf, URL url)
            throws IOException {
        URLConnection c = url.openConnection();
        c.setRequestProperty("Connection", "keep-alive");
        if (!(c instanceof HttpsURLConnection))
            throw new IllegalStateException("Expected HttpsURLConnection");
        HttpsURLConnection conn = ((HttpsURLConnection) c);
        conn.setSSLSocketFactory(ssf);

        InputStream in = null;
        try {
            in = conn.getInputStream();
            int read;
            byte[] buffer = new byte[4096];
            while (0 <= (read = in.read(buffer)))
                System.out.write(buffer, 0, read);
        } finally {
            if (null != in) try {
                in.close();
            } catch (IOException ioe) {
                System.err.println("Failed to close stream");
                ioe.printStackTrace(System.err);
            }
        }
    }
}