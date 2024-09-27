package com.pkslow.basic.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument; // For .doc files
import org.apache.poi.hwpf.extractor.WordExtractor;

import org.apache.poi.xwpf.usermodel.XWPFDocument; // For .docx files
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

public class DocReader {

    public static String readDocFile(String filePath) {
        String text = "";
        try (FileInputStream fis = new FileInputStream(filePath);
             HWPFDocument document = new HWPFDocument(fis);
             WordExtractor extractor = new WordExtractor(document)) {

            text = extractor.getText();

        } catch (IOException e) {
            System.err.println("Error reading .doc file: " + e.getMessage());
        }
        return text;
    }

    public static String readDocxFile(String filePath) {
        String text = "";
        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis);
             XWPFWordExtractor extractor = new XWPFWordExtractor(document)) {

            text = extractor.getText();

        } catch (IOException e) {
            System.err.println("Error reading .docx file: " + e.getMessage());
        }
        return text;
    }
}
