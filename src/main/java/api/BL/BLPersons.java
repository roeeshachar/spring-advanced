package main.java.api.BL;

import main.java.api.DL.DLPersonsInterface;
import main.java.api.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BLPersons {

    private DLPersonsInterface dl;

    @Autowired
    public void setDl(@Qualifier("DLPersonsLocal") DLPersonsInterface dl){
        this.dl=dl;
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
        return (this.dl.personExists(person));
    }

    /**
     * Adds a person to the collection of Persons
     *
     * @param person - the person to add
     */
    public void addPerson(Person person) {
        this.dl.addPerson(person);
    }


    /**
     * Returns the list of persons in the system
     *
     * @return - The list of persons in the system
     */
    public List<Person> getPersons() {
        return this.dl.getPersons();
    }
}
