package com.roee.spring.dl.cassandra.repository;

import com.roee.spring.models.Person;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonsRepositoryCassandra extends CassandraRepository<Person, Integer> {

}