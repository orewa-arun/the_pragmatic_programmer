package com.handleExternalAPI.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handleExternalAPI.externalAPIClient.ExternalAPIClient;

@Service
public class LinkedInScrapperService {

    @Autowired
    private ExternalAPIClient linkedInScrapperClient;

    public Map<String, Object> retrieveProfileData(){
        List<String> links = new ArrayList<String>();
        links.add("http://www.linkedin.com/in/luke-sharp-b3838719a");
        links.add("http://www.linkedin.com/in/hollie-smith-96ab44b5");
        links.add("http://www.linkedin.com/in/jeannie-wyrick-b4760710a");
        links.add("http://www.linkedin.com/in/rodneydbainjr");
        links.add("http://www.linkedin.com/in/arielschmid");   

        Map<String, Object> body = new HashMap<>();
        
        body.put("links", links);

        String apiKey = "your-key-here";
        String apiHost = "linkedin-bulk-data-scraper.p.rapidapi.com";
        String apiUser = "arun";

        return linkedInScrapperClient.scrapLinkedInData(apiKey, apiHost, apiUser, body);
    }
}
