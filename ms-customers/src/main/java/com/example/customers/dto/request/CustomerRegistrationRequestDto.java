package com.example.customers.dto.request;

public record CustomerRegistrationRequestDto(
        String firstName,
        String lastName,
        String email) {
}
