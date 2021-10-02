package com.pkslow.springboot.cassandra.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "users")
public class User {
    @Id
    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
