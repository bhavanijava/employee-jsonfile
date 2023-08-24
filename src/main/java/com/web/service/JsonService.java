package com.web.service;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface JsonService {
    void formatAndSave(MultipartFile jsonFile) throws IOException;
}
