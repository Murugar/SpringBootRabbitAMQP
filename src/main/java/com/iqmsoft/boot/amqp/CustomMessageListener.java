package com.iqmsoft.boot.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageListener {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);

    @RabbitListener(queues = MessagingApplication.QUEUE_GENERIC_NAME)
    public void receiveMessage(final Message message) {
        log.info("Listener : Received Message as Generic: {}", message.toString());
    }

   @RabbitListener(queues = MessagingApplication.QUEUE_SPECIFIC_NAME)
   public void receiveMessage1(final Message Message) {
       log.info("Listener : Received Message as Specific Class: {}", Message.toString());
    }
}
