package com.stars.userservice.srevice;

import com.stars.userservice.domain.User;
import com.stars.userservice.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserFeign userFeign;

    public String saveUser(User user) {

        return userFeign.saveUser(user);

    }

    public String saveUsers(List<User> users) {
        return userFeign.saveUsers(users);

    }

    public String getUsers(String username) {
        return userFeign.getUsers(username);
    }
}
