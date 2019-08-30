package com.hms.usercourses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.hms.usercourses")
@EnableAutoConfiguration
public class App {


    public static void main(String[] args){
        SpringApplication.run(App.class, args);

    }
}
