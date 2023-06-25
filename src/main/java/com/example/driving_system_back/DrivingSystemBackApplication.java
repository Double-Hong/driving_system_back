package com.example.driving_system_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.driving_system_back.mapper")
public class DrivingSystemBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrivingSystemBackApplication.class, args);
    }

}
