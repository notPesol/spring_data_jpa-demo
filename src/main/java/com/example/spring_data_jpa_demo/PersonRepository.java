package com.example.spring_data_jpa_demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findByFirstName(@Param("name") String name);

    List<Person> findByLastName(@Param("name") String name);

    List<Person> findByFirstNameOrLastName(@Param("firstName") String firstName,
                                           @Param("lastName") String lastName);

    List<Person> findByFirstNameAndLastName(@Param("firstName") String firstName,
                                            @Param("lastName") String lastName);


}