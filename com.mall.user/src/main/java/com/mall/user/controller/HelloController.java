package com.mall.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping (value = "/user")
public class HelloController {

    @Value ("${server.port}")
    String port;

    @GetMapping (value = "/hello")
    public String hello (@RequestParam (value = "name", defaultValue = "demo") String name) {
        return String.format("hi %s, i am from port: %s", name, port);
    }

    @GetMapping (value = "/timeout")
    public String timeout () {
        Random random = new Random();
        int i = random.nextInt(3);
        if (i % 2 == 0) {
            try {
                Thread.sleep(5000L);
                return "休眠过！";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "未休眠！";
    }

}

