package com.handleExternalAPI.externalAPIClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "universityApiClient", url = "http://universities.hipolabs.com")
public interface UniversityAPIClient {

    @GetMapping("/search")
    List<Object> GetUniversitiesByCountry(@RequestParam("country") String country);

}
