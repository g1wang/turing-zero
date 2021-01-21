package com.stars.demoservice.controller;

import com.stars.demoservice.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    @PostMapping(value = "/demo")
    public String save(String name) {

        return demoService.save(name);
    }

    @GetMapping(value = "/demo")
    public String getName(String name)
    {
        return demoService.get(name);
    }
}
