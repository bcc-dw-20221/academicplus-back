package com.academicplus.aplication.person.create;

import com.academicplus.domain.exception.DomainException;
import com.academicplus.domain.person.Person;
import com.academicplus.domain.person.PersonFactory;
import com.academicplus.domain.person.PersonRepository;

import java.util.Objects;

public class CreatePersonUseCase {

    private final PersonRepository personRepository;

    public CreatePersonUseCase(final PersonRepository personRepository) {
        this.personRepository = Objects.requireNonNull(personRepository);
    }

    public OutputCreatePersonDTO execute(final InputCreatePersonDTO input) {
        final var person = PersonFactory.createWithAddress(input.name(), input.cpf(), input.gender(), input.motherName(), input.email(), input.birthDate(), input.address().toAddress());
        final var exists = verifyIfPersonAlreadyExists(person);
        if (exists)
            throw new DomainException("Person already exists");
        this.personRepository.create(person);
        return OutputCreatePersonDTO.from(person);
    }

    private boolean verifyIfPersonAlreadyExists(final Person person) {
        return Objects.nonNull(this.personRepository.findByCpf(person.getCpf()));
    }
}
