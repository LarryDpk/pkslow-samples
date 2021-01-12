package com.pkslow.cloud.webflux.web;

import com.pkslow.cloud.webflux.util.ReactiveRequestContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GetRequestController {

    @RequestMapping("/request")
    public Mono<String> getRequest() {
        return ReactiveRequestContextHolder.getRequest()
                .map(request -> request.getHeaders().getFirst("user"));
    }
}
