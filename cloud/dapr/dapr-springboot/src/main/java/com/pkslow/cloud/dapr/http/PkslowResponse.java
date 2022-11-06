package com.pkslow.cloud.dapr.http;

import lombok.Data;

@Data
public class PkslowResponse {
    private int code;
    private String status;
    private String body;
}
