package com.example.czldemo.controller;

import com.example.czldemo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("test")
    public void test() {
        redisUtils.set("testkey4",12345);
        System.out.println(redisUtils.get("testkey4"));
    }
}
