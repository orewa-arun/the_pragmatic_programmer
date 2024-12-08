package com.handleExternalAPI.externalAPIClient;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "externalApiClient", url = "https://linkedin-bulk-data-scraper.p.rapidapi.com")
public interface ExternalAPIClient {
    
    @PostMapping(value = "/profiles", consumes = "application/json")
    Map<String, Object> scrapLinkedInData(
            @RequestHeader("x-rapidapi-key") String apiKey,
            @RequestHeader("x-rapidapi-host") String apiHost,
            // @RequestHeader("Content-Type") String contentType,
            @RequestHeader("x-rapidapi-user") String apiUser,
            @RequestBody Map<String, Object> body
    );
}
