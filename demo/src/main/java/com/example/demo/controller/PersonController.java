package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public Iterable<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@PathVariable String id) {
        return personService.findById(id);
    }

    @PostMapping("/")
    public void save(@RequestBody Person person) {
        personService.save(person);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        personService.deleteById(id);
    }
}