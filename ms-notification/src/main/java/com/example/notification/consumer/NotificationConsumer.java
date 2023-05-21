package com.example.notification.consumer;

import com.example.notification.dto.request.NotificationRequest;
import com.example.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(String notificationRequest) {
        log.info("ActionLog.consumer.start: {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
