package com.robo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.robo.application.web.rest", "com.robo.application.service"})
@SpringBootApplication
public class RoboHooverApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoboHooverApplication.class, args);
    }

}
