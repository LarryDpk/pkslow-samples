package com.pkslow.proto;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtobufMain {
    public static void main(String[] args) {
        System.out.println("------create message and serialize------");
        //创建嵌入式消息类Server
        PkslowWebSite.WebSite.Server.Builder serverBuilder = PkslowWebSite.WebSite.Server.newBuilder();
        PkslowWebSite.WebSite.Server server = serverBuilder.setHostname("1024.511.10.1")
                .setPort(80)
                .build();

        //创建主消息类WebSite
        PkslowWebSite.WebSite.Builder webSiteBuilder = PkslowWebSite.WebSite.newBuilder();
        PkslowWebSite.WebSite webSite = webSiteBuilder
                .setName("pkslow")
                .setLink("www.pkslow.com")
                .setAge(1)
                .setServer(server)
                .build();

        //打印结果
        System.out.println("webSite: " + webSite);

        //序列化，可用于网络传输等
        byte[] data = webSite.toByteArray();

        System.out.println("------deserialize------");
        //反序列化
        try {
            PkslowWebSite.WebSite deserializedWebSite = PkslowWebSite.WebSite.parseFrom(data);
            //打印结果
            System.out.println("deserializedWebSite: " + deserializedWebSite);

            System.out.println("------compare------");
            //结果为false，说明是另一个类
            System.out.println(webSite == deserializedWebSite);
            //结果为true，说明序列化和反序列化正确
            System.out.println(webSite.equals(deserializedWebSite));
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
