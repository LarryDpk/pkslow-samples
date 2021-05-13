package com.pkslow.basic;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class JavaProxy {
    public static void main(String[] args) throws IOException {
        System.setProperty("http.proxyHost", "localhost");
        System.setProperty("http.proxyPort", "1087");
        System.setProperty("https.proxyHost", "localhost");
        System.setProperty("https.proxyPort", "1087");

        URL website = new URL("https://www.google.com");
        try (InputStream in = website.openStream()) {
            Files.copy(in, Paths.get("google.html"), StandardCopyOption.REPLACE_EXISTING);
        }

    }
}
