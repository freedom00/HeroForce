package com.ys.backend.service;

import com.ys.backend.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public Person create(Person person) {
        return person;
    }
}
