package main.java.api.DL.local;

import main.java.api.DL.DLPersonsInterface;
import main.java.api.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class DLPersonsLocal implements DLPersonsInterface {
    private final HashMap<Integer, Person> persons;

    public DLPersonsLocal() {
        persons = new HashMap<>();
        persons.put(1, new Person(1, "roee"));
        persons.put(2, new Person(1, "shachar"));
    }

    @Override
    public String test() {
        return "Local";
    }

    /**
     * Checks whether the given person exists in the system
     *
     * @param person - the person to check if exists
     * @return true if exists, false otherwise
     */
    public boolean personExists(Person person) {
        return (this.persons.containsKey(person.getId()));
    }

    /**
     * Adds a person to the collection of Persons
     *
     * @param person - the person to add
     */
    public void addPerson(Person person) {
        this.persons.put(person.getId(), person);
    }

    /**
     * Returns the list of persons in the system
     *
     * @return - The list of persons in the system
     */
    public List<Person> getPersons() {
        return new ArrayList<>(this.persons.values());
    }
}
