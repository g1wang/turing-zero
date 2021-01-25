package com.stars.userservice.feign;


import com.stars.userservice.domain.User;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "GATEWAY/v1/userdataapi", fallbackFactory = UserFallbackFactory.class)
public interface UserFeign {

    @PostMapping("/user")
    String saveUser(@RequestBody User user);

    @PostMapping("/users")
    String saveUsers(@RequestBody List<User> users);


    @GetMapping("/user")
    String getUsers(@RequestParam("username") String username);

}

class FallbackWithFactory implements UserFeign {

    @Override
    public String saveUser(User user) {
        return "boom";
    }

    @Override
    public String saveUsers(List<User> users) {
        return "boom";
    }

    @Override
    public String getUsers(String username) {
        return "boom";
    }
}

@Component
class UserFallbackFactory implements FallbackFactory<FallbackWithFactory> {

    @Override
    public FallbackWithFactory create(Throwable throwable) {
        return new FallbackWithFactory();
    }
}
