package com.example.kafkademo.controller;

import com.example.kafkademo.service.KafkaMessageListenerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/kafka")
@RestController
public class KafkaMessageListenerController {

    private KafkaMessageListenerService kafkaMessageListenerService;

    public KafkaMessageListenerController(KafkaMessageListenerService kafkaMessageListenerService) {
        this.kafkaMessageListenerService = kafkaMessageListenerService;
    }

    @GetMapping
    public void fun(){
        kafkaMessageListenerService.run();
    }

}
