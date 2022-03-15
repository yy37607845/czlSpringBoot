package com.example.czldemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Description
 * @Author chenzl
 * @Date 2022/2/19 19:21
 */
//@SpringBootConfiguration
@Configuration
public class RabbitmqConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String userName;

    @Value("${spring.rabbitmq.password}")
    private String passWord;

    /**
    *  交换机
    */
    public static final String EXCHANGE_A = "my-mq-exchange_A";
    public static final String EXCHANGE_B = "my-mq-exchange_B";
    public static final String EXCHANGE_C = "my-mq-exchange_C";

    /**
     *  队列
     */
    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";
    public static final String QUEUE_C = "QUEUE_C";

    /**
     *
     */
    public static final String ROUTINGKEY_A = "springboot-boot-routingkey_A";
    public static final String ROUTINGKEY_B = "springboot-boot-routingkey_B";
    public static final String ROUTINGKEY_C = "springboot-boot-routingkey_C";

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(passWord);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }

    /**
     *  设置交换机类型
     *  将队列绑定到交换机
     */
    @Bean
    public DirectExchange defaultExchange(){
        return new DirectExchange(EXCHANGE_A);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queueA()).to(defaultExchange()).with(RabbitmqConfig.ROUTINGKEY_A);
    }

    @Bean
    public Binding bindingB(){
        return BindingBuilder.bind(queueB()).to(defaultExchange()).with(RabbitmqConfig.ROUTINGKEY_B);
    }

    /**
     *  获取队列
     */
    @Bean
    public Queue queueA(){
        return new Queue(QUEUE_A,true);
    }

    @Bean
    public Queue queueB(){
        return new Queue(QUEUE_B,true);
    }

}
