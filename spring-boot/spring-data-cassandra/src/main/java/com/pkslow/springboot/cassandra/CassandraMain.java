package com.pkslow.springboot.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories(basePackages = "com.pkslow.springboot.cassandra.repository")
public class CassandraMain {
    public static void main(String[] args) {
        SpringApplication.run(CassandraMain.class, args);
    }
}
