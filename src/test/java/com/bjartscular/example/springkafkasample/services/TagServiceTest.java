package com.bjartscular.example.springkafkasample.services;

import com.bjartscular.example.springkafkasample.model.Tag;
import com.bjartscular.example.springkafkasample.repositories.TagRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TagServiceTest {
    @InjectMocks
    TagService tagService;

    @Mock
    TagRepository tagRepository;

    @Test
    public void incrementTagCounterTest() {
        String tagName = "tag1";
        Tag findByNameTag = new Tag(tagName, 1);

        when(tagRepository.findByName(tagName)).thenReturn(Optional.of(findByNameTag));
        when(tagRepository.save(findByNameTag)).thenReturn(findByNameTag);

        Tag tagFromDb = tagService.incrementTagCounter(tagName);
        Assertions.assertEquals(tagFromDb.getCounter(), 2);

//        tagService.incrementTagCounter(tagName);
//        Assertions.assertEquals(findByNameTag.getCounter(), 2);
    }


}
