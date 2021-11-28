package com.bjartscular.example.springkafkasample.services;

import com.bjartscular.example.commondto.PersonPostRequestDto;
import com.bjartscular.example.springkafkasample.mappers.PersonMapper;
import com.bjartscular.example.springkafkasample.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonService personService;

    @KafkaListener(topics = "${kafka.consumer.topic}")
    public void consume(PersonPostRequestDto personPostRequestDto) {
        log.info(String.format("#### -> Consumed message -> %s", personPostRequestDto));
        Person person = personMapper.postRequestDtoToModel(personPostRequestDto);
        personService.saveOrUpdate(person);
    }

}
