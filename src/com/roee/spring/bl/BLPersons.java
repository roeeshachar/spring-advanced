package com.roee.spring.bl;

import com.roee.spring.dl.IPersonsRepositoryAdapter;
import com.roee.spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Business Layer for managing persons
 */
@Component
public class BLPersons {

    private final IPersonsRepositoryAdapter dl;

    /**
     * A constructor for BLPersons
     * @param dl - data layer - injected.
     */
    @Autowired
    public BLPersons(IPersonsRepositoryAdapter dl) {
        this.dl = dl;
    }

    public String test() {
        return this.dl.test();
    }

    /**
     * Checks whether the given person exists in the system
     *
     * @param person - the person to check if exists
     * @return true if exists, false otherwise
     */
    public boolean personExists(Person person) {
        return (this.dl.exists(person));
    }

    /**
     * Adds a person to the collection of Persons
     *
     * @param person - the person to add
     */
    public void addPerson(Person person) {
        this.dl.save(person);
    }


    /**
     * Returns the list of persons in the system
     *
     * @return - The list of persons in the system
     */
    public List<Person> getPersons() {
        return this.dl.findAll();
    }
}
