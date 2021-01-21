package com.stars.userdataservice.service;


import com.stars.userdataservice.domain.User;
import com.stars.userdataservice.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMapper userMapper;

    @Transactional
    public void saveUsers(List<User> userList){
        userMapper.intsertAll(userList);
    }

    @Transactional
    public void saveUser(User user){
        userMapper.insertUser(user);
    }

    public List<User> getUsers(String username) {
        List<User> list = userMapper.selectUsers(username);
        return list;
    }


}
