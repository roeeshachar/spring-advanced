package main.java.api.DL.db;

import main.java.api.DL.DLPersonsInterface;
import main.java.api.models.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DLPersonsDB implements DLPersonsInterface {
    @Override
    public String test() {
        return "DB";
    }

    @Override
    public boolean personExists(Person person) {
        return false;
    }

    @Override
    public void addPerson(Person person) {

    }

    @Override
    public List<Person> getPersons() {
        return null;
    }
}
