package com.stars.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//动态刷新配置
@RefreshScope
@RestController
public class DemoController {

    @Value("${whoami}")
    String whoami;
    @Value("${isop}")
    String isop;
    @GetMapping(value = "cfg")
    public String getWhoami(){
        return whoami+"-----";
    }
}
