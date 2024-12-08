package com.handleExternalAPI.externalAPIClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "DemonSlayerApiClient", url = "https://www.demonslayer-api.com/api/v1")
public interface DemonSlayerAPIClient {

    @GetMapping(value = "/characters", consumes = "application/json")
    Map<String, Object> GetDemonSlayers();
}
