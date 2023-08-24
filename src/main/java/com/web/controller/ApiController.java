package com.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.service.JsonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ApiController {

    private final JsonService jsonService;

    @Autowired
    public ApiController(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    @PostMapping("/process-json")
    public String processJson(@RequestParam("jsonFile") MultipartFile jsonFile) {
        try {
            // Pass the MultipartFile directly to the service
            jsonService.formatAndSave(jsonFile);
            return "JSON processing and saving completed.";
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred while processing the JSON data.";
        }
    }
}
