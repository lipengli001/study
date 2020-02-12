package com.mall.merge.controller;

import com.mall.merge.feign.HelloFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping (value = "/merge")
public class MergeController {

    @Autowired
    private HelloFeignClient helloFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping (value = "/hello")
    public String hello (@RequestParam (value = "name", defaultValue = "lpl") String name) {
        return helloFeignClient.hello(name);
    }

    @GetMapping (value = "/timeout")
    public String timeout () {
        String server1 = helloFeignClient.hello("lpl");
        String server2 = helloFeignClient.timeout();
        return server1 + "---" + server2;
    }

    @GetMapping (value = "/hi")
    public String hi (@RequestParam (value = "name", defaultValue = "lpl") String name) {
        return restTemplate.getForObject("http://USER/user/hello?name=" + name, String.class);
    }

}
