package com.example.czldemo.listen;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



/**
 * @Description
 * @Author chenzl
 * @Date 2022/2/19 19:37
 */
@Component
public class WorkRecieveListener {
    @RabbitListener(queues = "QUEUE_A")
    public void receiveMessage(String msg, Channel channel, Message message){
        System.out.println("1接收到消息：" + msg);
    }

    @RabbitListener(queues = "QUEUE_A")
    public void receiveMessage2(Object obj, Channel channel, Message message){
        System.out.println("2接收到消息：" + obj);
    }
}
