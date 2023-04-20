package com.example.demo.service;
import com.example.demo.model.Person;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface PersonService  {

    public Iterable<Person> findAll();

    public Optional<Person> findById(String id);

    public void save(Person person);

    public void deleteById(String id);
}