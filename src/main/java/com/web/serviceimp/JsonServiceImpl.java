package com.web.serviceimp;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.FormattedData;
import com.web.repo.FormattedDataRepository;
import com.web.service.JsonService;

@Service
public class JsonServiceImpl implements JsonService {

    private final FormattedDataRepository formattedDataRepository;

    @Autowired
    public JsonServiceImpl(FormattedDataRepository formattedDataRepository) {
        this.formattedDataRepository = formattedDataRepository;
    }

    @Override
    @Transactional
    public void formatAndSave(MultipartFile jsonFile) throws IOException {
        try (InputStream inputStream = jsonFile.getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(inputStream);
            System.out.println(root);

            JsonNode items = root.get("item");
            for (JsonNode itemNode : items) {
                String name = itemNode.get("name").asText();
                String method = itemNode.get("request").get("method").asText();
                String url = itemNode.get("request").get("url").get("raw").asText();

                JsonNode headersNode = itemNode.get("request").get("header");
                Map<String, String> headers = new HashMap<>();
                if (headersNode.isArray()) {
                    for (JsonNode headerNode : headersNode) {
                        String key = headerNode.get("key").asText();
                        String value = headerNode.get("value").asText();
                        headers.put(key, value);
                    }
                }

                String headersStr = headers.isEmpty() ? "" : headers.toString();
                
                String apiConfig = "{"
                        + "\"name\":\"" + name + "\","
                        + "\"method\":\"" + method + "\","
                        + "\"url\":\"" + url + "\""
                        + "}";
                

                FormattedData formattedData = new FormattedData();
                formattedData.setName(name);
                formattedData.setMethod(method);
                formattedData.setUrl(url);
                formattedData.setHeaders(headersStr);
                formattedData.setApiConfig(apiConfig);

                formattedDataRepository.save(formattedData);
            }
        }
    }
}
