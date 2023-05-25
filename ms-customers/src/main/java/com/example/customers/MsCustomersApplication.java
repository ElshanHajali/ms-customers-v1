package com.example.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EnableFeignClients
@PropertySources({
        @PropertySource("classpath:clients/clients-${spring.profiles.active}.properties")
        // it will be replaced to default or kube based on the profile we pass
})
public class MsCustomersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCustomersApplication.class, args);
    }

}
