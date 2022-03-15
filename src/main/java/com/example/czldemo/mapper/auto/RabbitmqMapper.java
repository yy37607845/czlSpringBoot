package com.example.czldemo.mapper.auto;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author chenzl
 * @Date 2022/2/19 19:32
 */
@Component
public class RabbitmqMapper {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("QUEUE_A","测试work模型：" + i);
        }
    }
}
