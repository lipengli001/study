package com.mall.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

    /**
     * 根据IP限流
     * @return
     */
    @Bean (value = "addrKeyResolver")
    public KeyResolver addrKeyResolver () {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

    /**
     * 根据URL限流
     * @return
     */
    @Bean (value = "apiKeyResolver")
    public KeyResolver apiKeyResolver () {
        return exchange -> Mono.just(exchange.getRequest().getURI().getPath());
    }

    /**
     * 根据用户限流
     * @return
     */
    @Bean (value = "userKeyResolver")
    public KeyResolver userKeyResolver () {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

}
