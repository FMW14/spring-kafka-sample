package com.bjartscular.example.springkafkasample.controllers;

import com.bjartscular.example.springkafkasample.services.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestParam String text) {
        kafkaProducer.sendMessage(text);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
