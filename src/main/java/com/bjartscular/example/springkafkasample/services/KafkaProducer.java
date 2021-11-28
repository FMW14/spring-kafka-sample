package com.bjartscular.example.springkafkasample.services;

import com.bjartscular.example.commondto.PersonPostRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    @Value(value = "${kafka.producer.topic}")
    private String producerTopic;

    @Autowired
    private KafkaTemplate<String, PersonPostRequestDto> kafkaTemplate;

    public void sendPerson(PersonPostRequestDto personPostRequestDto) {
        log.info(String.format("#### -> Producing message -> %s", personPostRequestDto));
        this.kafkaTemplate.send(producerTopic, personPostRequestDto);
    }
}
