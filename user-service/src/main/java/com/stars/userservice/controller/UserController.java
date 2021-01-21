package com.stars.userservice.controller;

import com.stars.userservice.domain.User;
import com.stars.userservice.srevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/users")
    public String saveUsers(@RequestBody  List<User> users) {

        return userService.saveUsers(users);
    }

    @PostMapping(value = "/user")
    public String saveUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

    @GetMapping(value = "/user")
    public String getUsers(String username) {
        return userService.getUsers(username);
    }
}
