package main.java.api.DL;

import main.java.api.models.Person;

import java.util.List;

public interface DLPersonsInterface {

    String test();
    boolean personExists(Person person);
    void addPerson(Person person);
    List<Person> getPersons();
}
