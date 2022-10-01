package com.academicplus.infrastructure.repository;

import com.academicplus.domain.person.Person;
import com.academicplus.domain.person.PersonID;
import com.academicplus.domain.person.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryMemory implements PersonRepository {
    private static final List<Person> people = new ArrayList<>();

    @Override
    public Person create(final Person person) {
        people.add(person);
        return person;
    }

    @Override
    public Person findById(final PersonID id) {
        return people.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Person findByCpf(final String cpf) {
        return people.stream().filter(p -> p.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    @Override
    public boolean existsById(final PersonID id) {
        return people.stream().anyMatch(p -> p.getId().equals(id));
    }

    @Override
    public boolean existsByCpf(final String cpf) {
        return people.stream().anyMatch(p -> p.getCpf().equals(cpf));
    }


    @Override
    public List<Person> findAll() {
        return people;
    }
}
