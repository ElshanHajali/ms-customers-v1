package com.example.notification.service;

import com.example.notification.dao.entity.NotificationEntity;
import com.example.notification.dao.repository.NotificationRepository;
import com.example.notification.dto.request.NotificationRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {
    private final ObjectMapper objectMapper;
    private final NotificationRepository notificationRepository;

    @SneakyThrows
    public void send(String message) {
        NotificationRequest notificationRequest = objectMapper.readValue(message, NotificationRequest.class);

        notificationRepository.save(
                NotificationEntity.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("Producer: " + Math.random() * 1000)
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                NotificationEntity.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("Producer: " + Math.random() * 1000)
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }

}
