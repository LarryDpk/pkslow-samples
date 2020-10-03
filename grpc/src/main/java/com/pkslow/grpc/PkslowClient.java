package com.pkslow.grpc;

import com.pkslow.grpc.gen.OrderRequest;
import com.pkslow.grpc.gen.OrderRespone;
import com.pkslow.grpc.gen.OrderServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PkslowClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999)
                .usePlaintext()
                .build();
        OrderServiceGrpc.OrderServiceBlockingStub stub = OrderServiceGrpc.newBlockingStub(channel);

        callWithOrderId(stub, 511);
        callWithOrderId(stub, 824);
        callWithOrderId(stub, 805);

        channel.shutdown();
    }

    private static void callWithOrderId(OrderServiceGrpc.OrderServiceBlockingStub stub, int orderId) {
        OrderRequest request = OrderRequest.newBuilder()
                .setOrderId(orderId)
                .build();
        OrderRespone respone = stub.getOrder(request);
        System.out.println("Respone from Server: " + respone);
    }
}
