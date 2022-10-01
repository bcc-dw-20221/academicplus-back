package com.academicplus.domain.person;

import java.util.List;

public interface PersonRepository {
    Person create(Person person);
    Person findById(PersonID id);
    Person findByCpf(String cpf);
    boolean existsById(PersonID id);
    boolean existsByCpf(String cpf);
    List<Person> findAll();
}
