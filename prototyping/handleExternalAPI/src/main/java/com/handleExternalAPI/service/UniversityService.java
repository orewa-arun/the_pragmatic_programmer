package com.handleExternalAPI.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.handleExternalAPI.externalAPIClient.UniversityAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UniversityService {

    @Autowired
    private UniversityAPIClient universityAPIClient;

    public List<Object> getUniversitiesByCountry(String country){
        return universityAPIClient.GetUniversitiesByCountry(country);
    }

    public boolean isDataValidatedAgainstTable(String schemaPath, JsonNode data){
        boolean result = false;
        File schemaFile = new File(schemaPath);

        try {
            JsonNode schemaNode = JsonLoader.fromFile(schemaFile);
            JsonSchema schema = JsonSchemaFactory.byDefault().getJsonSchema(schemaNode);
            ProcessingReport report = schema.validate(data);
            result = report.isSuccess();
        } catch (ProcessingException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean insertDataIntoUniDB(String countryParam){
        boolean result = false;
        List<Object> data = getUniversitiesByCountry(countryParam);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonData = objectMapper.valueToTree(data);

        // organising the data for validation
        Map<String, Object> requiredFields = new HashMap<>();

        for(JsonNode uni : jsonData){
            String country = uni.get("country").asText();
            String name = uni.get("name").asText();
            String web_pages = uni.get("web_pages").get(0).asText();
            String domains = uni.get("domains").get(0).asText();

            requiredFields.put("country" , country);
            requiredFields.put("name", name);
            requiredFields.put("web_pages", web_pages);
            requiredFields.put("domains", domains);
        }

        JsonNode tableData = objectMapper.valueToTree(requiredFields);

        if(isDataValidatedAgainstTable("src/main/resources/uniTableSchema.json", tableData)){
            result = true;
        }

        return result;
    }

}
