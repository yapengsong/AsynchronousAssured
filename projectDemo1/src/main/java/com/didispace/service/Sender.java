package com.didispace.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者用来发送消息
 * Created by Administrator on 2017/9/7 0007.
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send(String tag,String  json) {
        System.out.println("Sender : " + json);
        try {
            this.rabbitTemplate.convertAndSend(tag, json);
        }catch (Exception e){
            System.err.println("========================消息队列异常===================");
        }

    }
}
