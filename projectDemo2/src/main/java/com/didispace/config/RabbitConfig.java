package com.didispace.config;

import com.didispace.Application;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Administrator on 2017/9/7 0007.
 */

@Configuration
public class RabbitConfig {


    @Bean
    public Queue queue() {
        return new Queue(Application.Queue, true);
    }

}
