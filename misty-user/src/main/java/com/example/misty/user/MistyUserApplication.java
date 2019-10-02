package com.example.misty.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages = "com.example.misty.user.mapper")
public class MistyUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MistyUserApplication.class, args);
    }

}
