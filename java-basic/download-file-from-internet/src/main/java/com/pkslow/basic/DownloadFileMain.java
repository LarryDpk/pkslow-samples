package com.pkslow.basic;

import okhttp3.OkHttpClient;
import org.apache.commons.io.FileUtils;
import org.asynchttpclient.*;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class DownloadFileMain {
    private static final String URL = "https://www.pkslow.com";

    public static void main(String[] args) {
        javaIO();
        javaNIO1();
        javaNIO2();
        apacheCommonIO();
        okHttpClient(URL);
        asyncHttpClient();
    }

    private static void javaIO() {
        try {
            try (BufferedInputStream in = new BufferedInputStream(new URL(URL).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream("pkslow.io.html")) {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } catch (Exception e) {
                // handle exception
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void javaNIO1() {
        try {
            URL website = new URL(URL);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("pkslow.nio.html");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void javaNIO2() {
        try {
            URL website = new URL(URL);
            try (InputStream in = website.openStream()) {
                Files.copy(in, Paths.get("pkslow.nio2.html"), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void apacheCommonIO() {
        try {
            URL website = new URL(URL);
            FileUtils.copyURLToFile(website, new File("pkslow.commonsIO.html"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void okHttpClient(String downloadUrl) {
        try {
            OkHttpClient client = new OkHttpClient();
            okhttp3.Request request = new okhttp3.Request.Builder().url(downloadUrl).build();
            okhttp3.Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Failed to download file: " + response);
            }
            FileOutputStream fos = new FileOutputStream("pkslow.okHttpClient.html");
            fos.write(Objects.requireNonNull(response.body()).bytes());
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void asyncHttpClient() {
        try {
            AsyncHttpClient client = Dsl.asyncHttpClient();
            FileOutputStream stream = new FileOutputStream("pkslow.asyncHttpClient.html");
            client.prepareGet(URL).execute(new AsyncCompletionHandler<FileOutputStream>() {
                @Override
                public State onBodyPartReceived(HttpResponseBodyPart bodyPart)
                        throws Exception {
                    stream.getChannel().write(bodyPart.getBodyByteBuffer());
                    return State.CONTINUE;
                }

                @Override
                public FileOutputStream onCompleted(Response response)
                        throws Exception {
                    return stream;
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}