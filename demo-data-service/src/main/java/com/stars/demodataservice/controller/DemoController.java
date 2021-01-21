package com.stars.demodataservice.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoController {


    @PostMapping(value = "/demo")
    public String saveName(String name) {

        JSONObject result = new JSONObject();
        result.put("status", "ok");
        return result.toJSONString();
    }


    @GetMapping(value = "/demo")
    public String getName(String name) {
        JSONObject result = new JSONObject();
        result.put("name", name);
        result.put("status", "ok");
        return result.toJSONString();
    }

}
