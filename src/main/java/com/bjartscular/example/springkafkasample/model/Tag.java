package com.bjartscular.example.springkafkasample.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "tags")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Version
    Integer version;

    String name;
    Integer counter;

    public Tag(String name, Integer counter) {
        this.name = name;
        this.counter = counter;
    }
}
