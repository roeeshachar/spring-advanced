package com.roee.spring.controllers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.roee.spring.bl.BLPersons;
import com.roee.spring.exceptions.PersonAlreadyExistsException;
import com.roee.spring.models.Person;
import com.roee.spring.response.MessageResponse;
import com.roee.spring.response.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * A controller for managing Persons
 */
@RestController
@RequestMapping("/persons")
public class PersonsController {

    private final BLPersons bl;

    /**
     * A constructor for the person controller
     *
     * @param bl - persons business layer
     */
    @Autowired
    public PersonsController(BLPersons bl) {
        this.bl = bl;
    }


    /**
     * An endpoint for retrieving the persons in the system
     *
     * @return - The list of persons in the system
     */
    @GetMapping(path = "")
    public List<Person> get() {
        return this.bl.getPersons();
    }


    /**
     * An endpoint for adding a person to the system
     *
     * @param personToAdd - the person to add, as a json
     * @return - A Person Response containing the person added, if successful
     * @throws PersonAlreadyExistsException - if the person trying to add already exists in the system
     */
    @PostMapping(path = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PersonResponse add(@RequestBody @Valid Person personToAdd) throws PersonAlreadyExistsException {
        if (this.bl.personExists(personToAdd)) {
            throw new PersonAlreadyExistsException(personToAdd.getId());
        }

        this.bl.addPerson(personToAdd);
        return new PersonResponse("Person " + personToAdd.getId() + " Added Successfully", true, personToAdd);
    }


    /**
     * An Exception handler for the PersonAlreadyExistsException Exception
     *
     * @param e - the exception caught
     * @return - A Message Response that extracts the information from the exception to a user visible message
     */
    @ExceptionHandler(value = PersonAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public MessageResponse personAlreadyExists(PersonAlreadyExistsException e) {
        return new MessageResponse(e.getMessage(), false);
    }


    /**
     * An Exception handler for the InvalidFormatException Exception, in case of an invalid request
     *
     * @param e - the exception caught
     * @return - A Message Response that extracts the information from the exception to a user visible message
     */
    @ExceptionHandler(value = InvalidFormatException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public MessageResponse badRequest(InvalidFormatException e) {
        List<JsonMappingException.Reference> refs = e.getPath();
        String message;
        if (refs.size() == 0) {
            message = "Empty Request";
        } else {
            String fieldName = refs.get(0).getFieldName();
            Object value = e.getValue();
            message = "Invalid Value: " + value + " For Field " + fieldName;
        }
        return new MessageResponse(message, false);
    }


    /**
     * An Exception handler for the InvalidFormatException Exception, in case of an empty request
     *
     * @param e - the exception caught
     * @return - A Message Response that extracts the information from the exception to a user visible message
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public MessageResponse badRequest(MethodArgumentNotValidException e) {
        return new MessageResponse("Empty Request", false);
    }


    @GetMapping(path = "/dltest")
    public String blTest() {
        return this.bl.test();
    }

    @GetMapping(path = "/testlist")
    public @ResponseBody List<String> testList() {
        List<String> list =  new ArrayList<String>();
        list.add("hello");
        return list;
    }

    @RequestMapping(path = "/teststring", method = RequestMethod.GET)
    public String testString() {
        return "floob";
    }


}