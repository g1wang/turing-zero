package com.stars.zipkinclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZipkinController {

    @GetMapping("zipkinclient")
    public String zipkin(String name){
        return name;
    }
}
