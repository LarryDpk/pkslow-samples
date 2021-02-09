package com.pkslow.springboot.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {

    private static final Map<String, User> allUsers = new HashMap<>();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    protected void init() {
        allUsers.put("pkslow", new User("pkslow", passwordEncoder.encode("123456"), Collections.singletonList("ROLE_ADMIN")));
        allUsers.put("user", new User("user", passwordEncoder.encode("123456"), Collections.singletonList("ROLE_USER")));
    }

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(allUsers.get(username));
    }
}
