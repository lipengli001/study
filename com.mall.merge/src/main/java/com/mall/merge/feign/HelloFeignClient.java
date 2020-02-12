package com.mall.merge.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient (value = "user", fallbackFactory = HelloFallback.class)
public interface HelloFeignClient {

    @GetMapping (value = "/user/hello")
    String hello (@RequestParam (value = "name", defaultValue = "lpl") String name);

    @GetMapping (value = "/user/timeout")
    String timeout ();

}
