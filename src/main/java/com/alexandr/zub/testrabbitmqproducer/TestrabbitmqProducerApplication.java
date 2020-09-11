package com.alexandr.zub.testrabbitmqproducer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestrabbitmqProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestrabbitmqProducerApplication.class, args);
    }

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            template.convertAndSend(queue.getName(), "Hello");
            Thread.sleep(1000);
        }
    }
}
