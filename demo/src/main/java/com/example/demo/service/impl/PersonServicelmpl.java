package com.example.demo.service.impl;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServicelmpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(String id) {
        return personRepository.findById(id);
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void deleteById(String id) {
        personRepository.deleteById(id);
    }
}
