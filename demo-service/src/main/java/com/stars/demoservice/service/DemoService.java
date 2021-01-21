package com.stars.demoservice.service;

import com.stars.demoservice.feign.DemoFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    DemoFeign demoFeign;

    public String save(String name) {

        return demoFeign.save(name);

    }

    public String get(String name) {

        return demoFeign.getName(name);
    }
}
