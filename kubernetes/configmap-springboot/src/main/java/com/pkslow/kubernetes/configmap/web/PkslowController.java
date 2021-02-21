package com.pkslow.kubernetes.configmap.web;

import com.pkslow.kubernetes.configmap.config.PkslowProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PkslowController {
    private final PkslowProperties pkslowProperties;

    public PkslowController(PkslowProperties pkslowProperties) {
        this.pkslowProperties = pkslowProperties;
    }

    @GetMapping("/pkslow")
    public PkslowProperties pkslowProperties() {
        PkslowProperties properties = new PkslowProperties();
        properties.setAge(pkslowProperties.getAge());
        properties.setName(pkslowProperties.getName());
        properties.setWebSite(pkslowProperties.getWebSite());
        return properties;
    }
}
