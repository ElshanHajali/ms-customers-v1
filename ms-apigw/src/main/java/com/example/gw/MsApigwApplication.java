package com.example.gw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsApigwApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsApigwApplication.class, args);
    }

}
