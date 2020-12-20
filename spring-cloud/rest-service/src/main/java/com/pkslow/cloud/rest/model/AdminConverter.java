package com.pkslow.cloud.rest.model;

import org.springframework.core.convert.converter.Converter;

public class AdminConverter implements Converter<String, Admin> {
    @Override
    public Admin convert(String s) {
        String[] strings = s.split("\\|");
        return new Admin(strings[0], Integer.parseInt(strings[1]), strings[2]);
    }
}
