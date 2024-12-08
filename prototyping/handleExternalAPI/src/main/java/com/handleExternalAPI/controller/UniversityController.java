package com.handleExternalAPI.controller;

import java.util.List;
import com.handleExternalAPI.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("uni")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping("/{country}")
    public List<Object> getUniversitiesByCountry(@PathVariable("country") String country){
        return universityService.getUniversitiesByCountry(country);
    }

    @PostMapping("/{country}")
    public boolean submitUniData(@PathVariable("country") String country){
        return universityService.insertDataIntoUniDB(country);
    }
}
