package com.pkslow.basic;

import com.pkslow.basic.utils.TikaReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.pkslow.basic.utils.DocReader.readDocFile;
import static com.pkslow.basic.utils.DocReader.readDocxFile;

public class FileToTextMain {
    public static void main(String[] args) {
        Path docPath = Paths.get("/Users/larry/Downloads/test.doc");
        Path docxPath = Paths.get("/Users/larry/Downloads/test.docx");

        String docText = readDocFile(docPath.toString());
        System.out.println("Content of .doc file:\n" + docText);

        String docxText = readDocxFile(docxPath.toString());
        System.out.println("Content of .docx file:\n" + docxText);

        String tikaDocText = TikaReader.readFile("/Users/larry/Downloads/test.doc");
        System.out.println("Content of .doc file using Tika:\n" + tikaDocText);

        String tikaPdfText = TikaReader.readFile("/Users/larry/Downloads/test.pdf");
        System.out.println("Content of .pdf file using Tika:\n" + tikaPdfText);
    }

}