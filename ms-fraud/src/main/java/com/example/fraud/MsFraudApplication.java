package com.example.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsFraudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsFraudApplication.class, args);
    }

}
