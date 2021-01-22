package com.stars.zipkinclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ZipkinClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinClientApplication.class, args);
    }

}
