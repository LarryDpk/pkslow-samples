package com.pkslow.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.ldap.server.ApacheDSContainer;

import java.io.File;
import java.nio.file.Files;
import java.util.UUID;

@SpringBootApplication
public class LdapServer {
    public static void main(String[] args) throws Throwable {
        SpringApplication.run(LdapServer.class, args);
    }

    @Bean
    public ApacheDSContainer apacheDSContainer() throws Exception {
        final File temporaryFolder = Files.createTempDirectory("ldap_server").toFile();
        final String ldapFileName = "testUsers.ldif";

        ApacheDSContainer apacheDSContainer = new ApacheDSContainer("dc=springframework,dc=org",
                "classpath:" + ldapFileName);

        apacheDSContainer.setPort(40000);
        final File workingDir = new File(temporaryFolder, UUID.randomUUID().toString());
        apacheDSContainer.setWorkingDirectory(workingDir);
        return apacheDSContainer;
    }
}
