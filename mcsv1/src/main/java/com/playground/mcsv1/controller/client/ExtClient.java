package com.playground.mcsv1.controller.client;

import com.playground.mcsv1.config.ExtClientFeingConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "mcsv2", url = "${service.mcsv2-url}", configuration = ExtClientFeingConfig.class)
public interface ExtClient {

    @GetMapping("/v1.0/admin/test")
    String test();
}
