package com.pingan;

import com.pingan.conf.AppConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan(basePackages = "com.pingan.mapper")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

//    @GetMapping("/heather")
//    public String heather() {
//        return String.format("app run success!");
//    }
}