package com.bjartscular.example.springkafkasample.services;

import com.bjartscular.example.springkafkasample.model.Tag;
import com.bjartscular.example.springkafkasample.repositories.TagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void incrementTagCounter(String tagName) {
        Tag tag = tagRepository.findByName(tagName).orElse(new Tag(tagName, 0));
        log.info("Current counter value for tag {}: {}; new value = {}", tagName, tag.getCounter(), tag.getCounter() + 1);
        tag.setCounter(tag.getCounter() + 1);
        tagRepository.save(tag);
    }
}
