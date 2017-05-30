package com.iqmsoft.boot.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CustomMessageSender {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    
    
    @Scheduled(fixedDelay = 1000L)
    public void sendMessage1() {
        final CustomMessage message = new CustomMessage("Greetings from Spring Boot AMQP!", new Random().nextInt(50), false);
        log.info("Sending Message using Rabbit...");
        rabbitTemplate.convertAndSend(MessagingApplication.EXCHANGE_NAME, MessagingApplication.ROUTING_KEY, message);
        
    }
    
    @Scheduled(fixedDelay = 1000L)
    public void sendMessage() {
        log.info("Sending Ordinary Message using Rabbit...");
        Message m = new Message("Greeting AMQP".getBytes(), new MessageProperties());
        rabbitTemplate.send(MessagingApplication.EXCHANGE_NAME, MessagingApplication.ROUTING_KEY,m);
        
    }
    
}
