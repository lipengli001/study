package com.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
//@EnableHystrixDashboard
@SpringBootApplication
public class Application {

    public static void main (String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //@Bean
    //public ServletRegistrationBean getServlet () {
    //
    //    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
    //
    //    ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
    //
    //    registrationBean.setLoadOnStartup(1);
    //
    //    registrationBean.addUrlMappings("/hystrix.stream");
    //
    //    registrationBean.setName("HystrixMetricsStreamServlet");
    //
    //    return registrationBean;
    //
    //}



}
