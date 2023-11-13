package com.microservices.clientservice.repository;

import com.microservices.clientservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
