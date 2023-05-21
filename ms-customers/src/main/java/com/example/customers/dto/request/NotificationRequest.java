package com.example.customers.dto.request;

public record NotificationRequest(
        Long toCustomerId,
        String toCustomerName,
        String toCustomerEmail,
        String message)
{}
