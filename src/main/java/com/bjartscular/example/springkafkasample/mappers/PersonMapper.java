package com.bjartscular.example.springkafkasample.mappers;

import com.bjartscular.example.commondto.PersonPostRequestDto;
import com.bjartscular.example.springkafkasample.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person postRequestDtoToModel(PersonPostRequestDto personPostRequestDto);

}
