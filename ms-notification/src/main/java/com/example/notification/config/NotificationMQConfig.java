package com.example.notification.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class NotificationMQConfig {
    private final ApplicationProperties applicationProperties;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(applicationProperties.getInternalExchange());
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(applicationProperties.getNotificationQueue());
    }

    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(internalTopicExchange())
                .with(applicationProperties.getInternalNotificationRoutingKey());
    }
}
