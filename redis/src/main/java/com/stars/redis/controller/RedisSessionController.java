package com.stars.redis.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RefreshScope
public class RedisSessionController {

    @GetMapping("/getStatus")
    public String getStatus(HttpServletRequest request){

        HttpSession session = request.getSession();
        String status = (String)session.getAttribute("status");
        if(StringUtils.isEmpty(status)){
            session.setAttribute("status", "testSessionRedis|" + System.currentTimeMillis());
        }
        return status;

    }

}
