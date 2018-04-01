package com.roee.spring.models;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/***
 * Represents a person
 */
@Table("persons")
public class Person implements Serializable{

    @NotNull
    @PrimaryKey
    public Integer id;
    @NotNull
    @Column
    public String name;

    /**
     * A constructor for the Person class
     * @param id - the person's id
     * @param name - the person's name
     */
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
