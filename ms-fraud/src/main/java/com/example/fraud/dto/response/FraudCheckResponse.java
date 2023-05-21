package com.example.fraud.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FraudCheckResponse {
    private Boolean isFraudulentCustomer;
}
