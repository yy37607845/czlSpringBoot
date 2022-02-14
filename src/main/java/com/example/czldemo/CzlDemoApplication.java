package com.example.czldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.example.czldemo")
@SpringBootApplication
public class CzlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CzlDemoApplication.class, args);
    }

}
