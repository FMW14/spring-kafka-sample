package com.bjartscular.example.springkafkasample.repositories;

import com.bjartscular.example.springkafkasample.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
