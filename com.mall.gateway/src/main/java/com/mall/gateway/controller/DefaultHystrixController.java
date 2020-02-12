package com.mall.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultHystrixController {

    @RequestMapping ("/defaultFallback")
    public String defaultfallback () {
        return "接口被降级！";
    }
}
