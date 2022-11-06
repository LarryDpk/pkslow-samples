package com.pkslow.cloud.dapr.web;

import com.pkslow.cloud.dapr.http.PkslowRequest;
import com.pkslow.cloud.dapr.http.PkslowResponse;
import io.dapr.client.DaprClient;
import io.dapr.client.domain.HttpExtension;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pkslow")
@Slf4j
public class TestController {
    private final DaprClient daprClient;

    public TestController(DaprClient daprClient) {
        this.daprClient = daprClient;
    }

    @GetMapping("/hello")
    public PkslowResponse hello() {
        log.info("hello");

        PkslowRequest request = new PkslowRequest();
        request.setName("Larry Deng");
        request.setAge("18");

        PkslowResponse response = daprClient.invokeMethod(
                "pkslow-data",
                "/pkslow/data",
                request,
                HttpExtension.POST,
                PkslowResponse.class
        ).block();

        return response;
    }

    @GetMapping("/feedback")
    public PkslowResponse feedback() {
        log.info("feedback");
        PkslowResponse response = new PkslowResponse();
        response.setCode(200);
        response.setStatus("OK");
        response.setBody("Request Received and processed");
        return response;
    }

    @PostMapping("/data")
    public PkslowResponse data(@RequestBody PkslowRequest request) {
        log.info("data");
        daprClient.invokeMethod(
                "pkslow-hello",
                "/pkslow/feedback",
                "",
                HttpExtension.GET,
                PkslowResponse.class
        ).block();


        PkslowResponse response = new PkslowResponse();
        response.setCode(200);
        response.setStatus("OK");
        response.setBody("This is data from www.pkslow.com: " + request.toString());
        return response;
    }


}
