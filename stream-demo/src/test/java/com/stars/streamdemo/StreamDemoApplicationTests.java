package com.stars.streamdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StreamDemoApplicationTests {

    @Autowired
    MsgService msgService;


    @Test
    void contextLoads() {
        msgService.write1("banana1");
        msgService.write2("banana2");
    }

}
