package com.handleExternalAPI.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.handleExternalAPI.externalAPIClient.DemonSlayerAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class DemonSlayerService {

    @Autowired
    private DemonSlayerAPIClient demonSlayerAPIClient;

    public Map<String, Object> getDemonSlayers(){
        return demonSlayerAPIClient.GetDemonSlayers();
    }

    public boolean validateFetchedData(Map<String, Object> data, String schemaPath){

        boolean result = false;

        ObjectMapper objectMapper = new ObjectMapper();
        File schemaFile = new File(schemaPath);

        try {
            JsonNode jsonData = objectMapper.valueToTree(data);
            JsonNode demonsContentData = jsonData.get("content");

            JsonNode schemaNode = JsonLoader.fromFile(schemaFile);
            JsonSchema schema = JsonSchemaFactory.byDefault().getJsonSchema(schemaNode);
            ProcessingReport report = schema.validate(demonsContentData);
            result = report.isSuccess();
        } catch (ProcessingException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean insertDataIntoDB(){

        boolean result = false;
        Map<String, Object> jsonData = getDemonSlayers();

        if(validateFetchedData(jsonData, "src/main/resources/schema.json")){
            result = true;
        }

        return result;
    }}
