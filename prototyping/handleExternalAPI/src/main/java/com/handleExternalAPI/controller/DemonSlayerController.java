package com.handleExternalAPI.controller;


import com.handleExternalAPI.service.DemonSlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/demon")
public class DemonSlayerController {

    @Autowired
    private DemonSlayerService demonSlayerService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getAllDemonSlayers(){
        return demonSlayerService.getDemonSlayers();
    }

    @GetMapping("/insert")
    @ResponseStatus(HttpStatus.OK)
    public boolean isDemonSlayerInsertable(){
        return demonSlayerService.insertDataIntoDB();
    }
}
