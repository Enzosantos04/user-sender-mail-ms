package dev.java10x.user.producer;

import dev.java10x.user.dto.UserRequest;
import dev.java10x.user.dto.UserResponse;
import dev.java10x.user.entity.User;
import dev.java10x.user.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(@Payload UserRequest user) {
        rabbitTemplate.convertAndSend(user);
    }
}
