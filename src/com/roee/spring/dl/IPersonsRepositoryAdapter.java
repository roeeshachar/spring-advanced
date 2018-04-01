package com.roee.spring.dl;

import com.roee.spring.models.Person;

import java.util.List;

public interface IPersonsRepositoryAdapter {

    String test();
    boolean exists(Person person);
    void save(Person person);
    List<Person> findAll();
}
