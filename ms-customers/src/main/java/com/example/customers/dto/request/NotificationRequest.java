package com.example.customers.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationRequest {
        Long toCustomerId;
        String toCustomerName;
        String toCustomerEmail;
        String message;
}
