package com.example.customers.controller;

import com.example.customers.dto.request.CustomerRegistrationRequestDto;
import com.example.customers.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerCustomer(@RequestBody CustomerRegistrationRequestDto customerRegistrationRequest) {
        log.info("ActionLog.registerCustomer.start: {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
