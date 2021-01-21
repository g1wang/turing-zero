package com.stars.demoservice.feign;


import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "DEMO-DATA-SERVICE", fallbackFactory = DemoFallbackFactory.class)
public interface DemoFeign {

    @PostMapping("/demo")
    String save(@RequestParam("name") String name);

//    @PostMapping("/users")
//    String saveUsers(@RequestBody List<User> users);


    @GetMapping("/demo")
    String getName(@RequestParam("name") String name);

}

class FallbackWithFactory implements DemoFeign {


    @Override
    public String save(String name) {
        return "BOOM!!!";
    }

    @Override
    public String getName(String username) {
        return "boom";
    }
}

@Component
class DemoFallbackFactory implements FallbackFactory<FallbackWithFactory> {

    @Override
    public FallbackWithFactory create(Throwable throwable) {
        return new FallbackWithFactory();
    }
}
