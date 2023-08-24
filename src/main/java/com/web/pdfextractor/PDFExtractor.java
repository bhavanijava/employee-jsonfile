package com.web.pdfextractor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Component
public class PDFExtractor implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        String filePath = "C:/Users/Bhavani sankar/Downloads/SamplePDFPage.pdf";
        File file = new File(filePath);

        try {
            PDDocument document = PDDocument.load(file);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            List<MetaObject> metaobjects = extractMetaObjects(text);
            Output output = new Output("text", metaobjects.size(), metaobjects);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = "["+gson.toJson(output)+"]";
           // System.out.println(jsonOutput);

            document.close();

        } catch (Exception e) {
            System.out.println("An error occurred while processing the PDF: " + e.getMessage());
        }
    }

    private List<MetaObject> extractMetaObjects(String text) {
        String[] lines = text.split("\\r?\\n"); // Split the text into lines
        List<MetaObject> metaobjects = new ArrayList<>();
        for (String line : lines) {
            String trimmedLine = line.trim(); // Trim leading and trailing whitespaces
            if (!trimmedLine.isEmpty()) { // Ignore empty lines
                metaobjects.add(new MetaObject(trimmedLine));
            }
        }
        return metaobjects;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Output {
        private String type;
        private int count;
        private List<MetaObject> metaobjects;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class MetaObject {
        private String content;
    }
}
