package com.example.customers.service;

import com.example.customers.client.FraudClient;
import com.example.customers.config.ApplicationProperties;
import com.example.customers.dao.entity.CustomerEntity;
import com.example.customers.dao.repository.CustomerRepository;
import com.example.customers.dto.request.CustomerRegistrationRequestDto;
import com.example.customers.dto.request.NotificationRequest;
import com.example.customers.dto.response.FraudCheckResponse;
import com.example.customers.producer.RabbitMQMessageProducer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    private final ApplicationProperties applicationProperties;

    public void registerCustomer(CustomerRegistrationRequestDto request) {
        CustomerEntity customer = CustomerEntity.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // TODO: check if email valid
        // TODO: check if email not taken
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.getIsFraudulentCustomer()) {
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getFirstName(),
                customer.getEmail(),
                String.format("Hi %s ...",
                        customer.getFirstName())
        );

        rabbitMQMessageProducer.publish(
                notificationRequest,
                applicationProperties.getInternalExchange(),
                applicationProperties.getInternalNotificationRoutingKey()
        );
    }
}
