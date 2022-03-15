package com.example.czldemo.controller;

import com.example.czldemo.service.IRabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author chenzl
 * @Date 2022/2/19 19:24
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitmqController {
    @Autowired
    private IRabbitmqService rabbitmqService;

    @GetMapping("/sendWork")
    public Object sendWork(){
        rabbitmqService.sendWork();
        return "发送成功...";
    }

}
