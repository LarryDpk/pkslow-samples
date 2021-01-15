package com.pkslow.springboot.audit.controller;


import com.pkslow.springboot.audit.dao.UserRepository;
import com.pkslow.springboot.audit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public User query() {
        return userRepository.findById(1L).get();
    }
}
