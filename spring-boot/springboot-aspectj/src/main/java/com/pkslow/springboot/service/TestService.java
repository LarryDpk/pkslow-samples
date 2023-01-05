package com.pkslow.springboot.service;

import com.pkslow.springboot.aop.PkslowLogTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService {
    @PkslowLogTime
    public void fetchData() {
        log.info("fetchData");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
