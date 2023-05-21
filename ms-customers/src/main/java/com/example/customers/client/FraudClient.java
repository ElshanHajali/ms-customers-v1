package com.example.customers.client;

import com.example.customers.dto.response.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "ms-fraud", value = "fraud", url = "${endpoints.ms-fraud}/v1/fraud-check")
@FeignClient(value = "fraud")
public interface FraudClient {

    @GetMapping("v1/fraud-check/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable Long customerId);
}
