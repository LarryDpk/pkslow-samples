package com.pkslow.basic.utils;

import org.apache.tika.Tika;

import java.io.File;

public class TikaReader {
    public static String readFile(String filePath) {
        Tika tika = new Tika();
        String text = "";
        try {
            text = tika.parseToString(new File(filePath));
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return text;
    }

}
