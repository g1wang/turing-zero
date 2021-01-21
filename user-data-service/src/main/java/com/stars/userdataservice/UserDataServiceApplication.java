package com.stars.userdataservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@ServletComponentScan
@MapperScan(value = "com.stars.*.mapper")
public class UserDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserDataServiceApplication.class, args);
    }

}
