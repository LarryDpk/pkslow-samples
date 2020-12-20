package com.pkslow.cloud.rest;

import com.pkslow.cloud.rest.model.Admin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PkslowController {
    @Value("${pkslow.admin}")
    private String admin;

    @Value("${pkslow.admin}")
    private Admin adminBean;

    @GetMapping("/getAdmin")
    public String getAdmin() {
        return admin;
    }

    @GetMapping("/getAdminBean")
    public Admin getAdminBean() {
        return adminBean;
    }
}
