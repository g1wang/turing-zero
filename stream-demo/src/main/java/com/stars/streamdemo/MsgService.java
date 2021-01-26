package com.stars.streamdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(value = {MyProcessor.class})
public class MsgService {

    @Autowired
    private MyProcessor myProcessor;


    public boolean write1(String data) {
        return myProcessor.output1().send(MessageBuilder.withPayload(data).build());
    }
    public boolean write2(String data) {
        return myProcessor.output2().send(MessageBuilder.withPayload(data).build());
    }

    @StreamListener(MyProcessor.INPUT1)
    public void subscribe(Object object) {

        System.out.println("receive1:"+object);

    }

    @StreamListener(MyProcessor.INPUT2)
    public void subscribe2(Object object) {

        System.out.println("receive2:"+object);

    }


}
