package com.pkslow.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class PkslowServer {
    public static void main(String[] args) {
        Server server = ServerBuilder.forPort(9999)
                .addService(new OrderServiceImpl())
                .build();

        try {
            System.out.println("Start server...");
            server.start();
            System.out.println("Started");
            server.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
