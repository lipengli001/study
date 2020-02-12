package com.mall.merge.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloFallback implements FallbackFactory<HelloFeignClient> {

    @Override
    public HelloFeignClient create (Throwable cause) {
        return new HelloFeignClient() {

            @Override
            public String hello (String name) {
                return "接口被降级，请稍后重试";
            }

            @Override
            public String timeout () {
                return "接口被降级，请稍后重试";
            }
        };
    }

}
