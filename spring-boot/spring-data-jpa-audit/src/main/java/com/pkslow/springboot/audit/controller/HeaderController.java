package com.pkslow.springboot.audit.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/header")
public class HeaderController {
    @GetMapping("/webSite")
    public String webSite(@RequestHeader("webSite")String webSite) {
        return "The webSite is " + webSite;
    }

    @GetMapping("/webSite-not-required")
    public String webSiteNotRequired(@RequestHeader(value = "webSite", required = false)String webSite) {
        return "The webSite is " + webSite;
    }

    @GetMapping("/webSite-defaultValue")
    public String webSiteDefaultValue(@RequestHeader(value = "webSite", defaultValue = "pkslow.com")String webSite) {
        return "The webSite is " + webSite;
    }

    @GetMapping("/allMap")
    public Map<String, String> allMap(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @GetMapping("/allMultiValueMap")
    public Map<String, String> allMultiValueMap(@RequestHeader MultiValueMap<String, String> headers) {
        return headers.toSingleValueMap();
    }

    @GetMapping("/allHttpHeaders")
    public String allHttpHeaders(@RequestHeader HttpHeaders headers) {
        return headers.toString();
    }

    @GetMapping("/webSite-RequestContextHolder")
    public String webSiteRequestContextHolder() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        // get the request
        HttpServletRequest request = requestAttributes.getRequest();
        return "The webSite is " + request.getHeader("webSite");
    }
}
