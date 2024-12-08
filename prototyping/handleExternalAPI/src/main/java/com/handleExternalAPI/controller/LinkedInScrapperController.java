package com.handleExternalAPI.controller;

import java.util.Map;
import org.springframework.http.HttpStatus;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.handleExternalAPI.service.LinkedInScrapperService;

@RestController
@RequestMapping("/api")
public class LinkedInScrapperController {

    @Autowired
    private LinkedInScrapperService linkedInScrapperService;
 
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> fetchLinkedInData(){
        return linkedInScrapperService.retrieveProfileData();
    }
}
