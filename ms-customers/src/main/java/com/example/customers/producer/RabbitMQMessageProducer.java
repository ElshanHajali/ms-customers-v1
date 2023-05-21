package com.example.customers.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMQMessageProducer {
    private final AmqpTemplate amqpTemplate;

    public <T> void publish(T payload, String exchange, String routingKey) {
        log.info("ActionLog.publish.start: exchange{} - routingKey: {} - payload: {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("ActionLog.publish.success: exchange{} - routingKey: {} - payload: {}", exchange, routingKey, payload);
    }
}
