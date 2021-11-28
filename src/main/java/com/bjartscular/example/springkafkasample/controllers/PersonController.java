package com.bjartscular.example.springkafkasample.controllers;

import com.bjartscular.example.commondto.PersonPostRequestDto;
import com.bjartscular.example.springkafkasample.services.KafkaProducer;
import com.bjartscular.example.springkafkasample.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<Void> addPerson(@RequestParam String tag,
                                          @RequestBody PersonPostRequestDto personPostRequestDto) {
        kafkaProducer.sendPerson(personPostRequestDto);
        tagService.incrementTagCounter(tag);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
