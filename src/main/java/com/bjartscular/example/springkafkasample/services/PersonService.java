package com.bjartscular.example.springkafkasample.services;

import com.bjartscular.example.springkafkasample.model.Person;
import com.bjartscular.example.springkafkasample.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void saveOrUpdate(Person person){
        personRepository.save(person);
    }

}
