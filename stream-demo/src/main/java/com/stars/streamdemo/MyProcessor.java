package com.stars.streamdemo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyProcessor {

    /**
     * Input channel name.
     */
    String INPUT1 = "cbanana1";
    String INPUT2 = "cbanana2";

    /**
     * @return input channel.
     */
    @Input(MyProcessor.INPUT1)
    SubscribableChannel input1();

    @Input(MyProcessor.INPUT2)
    SubscribableChannel input2();

    /**
     * Name of the output channel.
     */
    String OUTPUT1 = "cbanana3";
    String OUTPUT2 = "cbanana4";

    /**
     * @return output channel
     */
    @Output(MyProcessor.OUTPUT1)
    MessageChannel output1();

    @Output(MyProcessor.OUTPUT2)
    MessageChannel output2();

}
