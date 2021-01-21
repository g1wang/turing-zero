package com.stars.userdataservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.stars.userdataservice.domain.User;
import com.stars.userdataservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/users")
    public String saveUsers(@RequestBody List<User> users) {

        JSONObject result = new JSONObject();
        userService.saveUsers(users);
        result.put("status", "ok");
        return result.toJSONString();
    }

    @PostMapping(value = "/user")
    public String saveUser(@RequestBody User user) {
        JSONObject result = new JSONObject();
        userService.saveUser(user);
        result.put("status", "ok");
        return result.toJSONString();
    }


    @GetMapping(value = "/user")
    public String getUsers(String username) {
        JSONObject result = new JSONObject();
        List<User> userList = userService.getUsers(username);
        result.put("status", "ok");
        result.put("users", userList);
        return result.toJSONString();
    }

}
