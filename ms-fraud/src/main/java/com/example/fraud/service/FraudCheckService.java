package com.example.fraud.service;

import com.example.fraud.dao.entity.FraudCheckHistoryEntity;
import com.example.fraud.dao.repository.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Long customerId) {
        FraudCheckHistoryEntity checkHistoryEntity = fraudCheckHistoryRepository.save(
                FraudCheckHistoryEntity.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return checkHistoryEntity.getIsFraudster();
    }

}
