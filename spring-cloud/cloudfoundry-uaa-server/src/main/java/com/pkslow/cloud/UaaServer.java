package com.pkslow.cloud;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.catalina.Context;
import org.apache.catalina.Server;
import org.apache.catalina.loader.WebappLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

@SpringBootApplication
public class UaaServer {

    public static void main(String[] args) {
        SpringApplication.run(UaaServer.class, args);
    }

    @Bean
    public ServletWebServerFactory servletContainer() throws IOException {

        final File tempDirectory = Files.createTempDirectory("uaa").toFile();
        final File tempUaaYmlFile = new File(tempDirectory, "uaa.yml");
        final File tempUaaWarFile = new File(tempDirectory, "uaa.war");

        FileCopyUtils.copy(
                new ClassPathResource("uaa-postgresql-ldap.yml").getInputStream(),
                new FileOutputStream(tempUaaYmlFile));

        FileCopyUtils.copy(
                new ClassPathResource("uaa.war").getInputStream(),
                new FileOutputStream(tempUaaWarFile));

        System.out.println("uaa.yml: " + tempUaaYmlFile.getAbsolutePath());
        System.out.println("uaa.war: " + tempUaaWarFile.getAbsolutePath());

        System.setProperty("UAA_CONFIG_FILE", tempUaaYmlFile.getAbsolutePath());

        return new TomcatServletWebServerFactory() {
            protected TomcatWebServer getTomcatWebServer(org.apache.catalina.startup.Tomcat tomcat) {
                final Server tomcatServer = tomcat.getServer();
                final File catalinaBase = new File(tempDirectory, "catalina");
                catalinaBase.mkdirs();

                tomcatServer.setCatalinaBase(catalinaBase);
                new File(tomcatServer.getCatalinaBase(), "webapps").mkdirs();
                try {
                    Context context = tomcat.addWebapp("/uaa", tempUaaWarFile.toString());
                    final ClassLoader properClassLoader = UaaServer.class.getClassLoader();

                    WebappLoader loader =
                            new WebappLoader(properClassLoader);
                    context.setLoader(loader);

                } catch (Exception ex) {
                    throw new IllegalStateException("Failed to add webapp", ex);
                }
                return super.getTomcatWebServer(tomcat);
            }
        };
    }
}