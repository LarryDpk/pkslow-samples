package com.pkslow.liquibase;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.util.Properties;

public class PkslowLiquibaseProperties extends Properties {

    private static final StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    static {
        System.out.println("init for encryptor");
        //设置密钥
        encryptor.setPassword("pkslow-salt");
        //设置加密算法
        encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
    }

    public static void main(String[] args) {
        System.out.println(encryptor.encrypt("pkslow"));
    }

    @Override
    public synchronized Object put(Object key, Object value) {
        if ("password".equals(key)) {
            value = encryptor.decrypt((String) value);
        }
        return super.put(key, value);
    }
}
