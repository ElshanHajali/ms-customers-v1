package com.example.fraud.dao.repository;

import com.example.fraud.dao.entity.FraudCheckHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistoryEntity, Integer> {
}
