package com.roee.spring.dl.cassandra;

import com.roee.spring.dl.IPersonsRepositoryAdapter;
import com.roee.spring.dl.cassandra.repository.PersonsRepositoryCassandra;
import com.roee.spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonsRepositoryCassandraAdapter implements IPersonsRepositoryAdapter {

    private final PersonsRepositoryCassandra personsRepositoryCassandra;

    @Autowired
    public PersonsRepositoryCassandraAdapter(PersonsRepositoryCassandra personsRepositoryCassandra) {
        this.personsRepositoryCassandra = personsRepositoryCassandra;
    }

    @Override
    public String test() {
        return "DB";
    }

    /**
     * Checks whether the given person exists in the system
     *
     * @param person - the person to check if exists
     * @return true if exists, false otherwise
     */
    public boolean exists(Person person) {
        return false;
    }

    /**
     * Adds a person to the collection of Persons
     *
     * @param person - the person to add
     */
    public void save(Person person) {

    }

    /**
     * Returns the list of persons in the system
     *
     * @return - The list of persons in the system
     */
    public List<Person> findAll() {
        return null;
    }
}
