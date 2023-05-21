package com.example.fraud.controller;

import com.example.fraud.dto.response.FraudCheckResponse;
import com.example.fraud.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("v1/fraud-check")
@RequiredArgsConstructor
public class FraudCheckController {

    private final FraudCheckService fraudCheckService;

    @GetMapping("{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public FraudCheckResponse isFraudster(@PathVariable Long customerId) {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("ActionLog.isFraudster.start {}", customerId);

        return FraudCheckResponse.builder().isFraudulentCustomer(isFraudulentCustomer).build();
    }
}
