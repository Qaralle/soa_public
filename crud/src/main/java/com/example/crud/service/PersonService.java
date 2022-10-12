package com.example.crud.service;

import com.example.crud.model.Person;
import com.example.crud.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person findByPassport(String passport) {
        return repository.findByPassportID(passport);
    }
}
