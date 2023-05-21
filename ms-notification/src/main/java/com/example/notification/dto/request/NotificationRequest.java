package com.example.notification.dto.request;

import lombok.*;

@Builder
public record NotificationRequest(
        Long toCustomerId,
        String toCustomerName,
        String toCustomerEmail,
        String message
) { }
