package com.ms.user.producers;


import com.ms.user.Dtos.EmailDtos;
import com.ms.user.models.UserModels;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducers {

    final RabbitTemplate rabbitTemplate;

    public UserProducers(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModels userModels) {

        var emailDtos = new EmailDtos();

        emailDtos.setUserId(userModels.getUserId());
        emailDtos.setEmailTo(userModels.getEmail());
        emailDtos.setSubject("votre compte a ete creer avec success");
        emailDtos.setText(userModels.getName() + " soyez les bien venue \n nous vous remercions pour votre participations");

        rabbitTemplate.convertAndSend("", routingKey, emailDtos);
    }

}
