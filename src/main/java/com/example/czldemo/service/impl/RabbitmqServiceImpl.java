package com.example.czldemo.service.impl;

import com.example.czldemo.mapper.auto.RabbitmqMapper;
import com.example.czldemo.service.IRabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author chenzl
 * @Date 2022/2/19 19:31
 */
@Service
@Primary
public class RabbitmqServiceImpl implements IRabbitmqService {
    @Autowired
    private RabbitmqMapper rabbitmqMapper;

    @Override
    public void sendWork() {
        rabbitmqMapper.sendWork();
    }
}
