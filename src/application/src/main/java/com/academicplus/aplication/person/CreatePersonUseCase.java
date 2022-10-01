package com.academicplus.aplication.person;

import com.academicplus.aplication.shared.AddressDTO;
import com.academicplus.domain.exception.DomainException;
import com.academicplus.domain.person.Person;
import com.academicplus.domain.person.PersonRepository;
import com.academicplus.domain.shared.Address;

import java.util.Objects;

public class CreatePersonUseCase {

    private final PersonRepository personRepository;

    public CreatePersonUseCase(final PersonRepository personRepository) {
        this.personRepository = Objects.requireNonNull(personRepository);
    }

    public OutputCreatePersonDTO execute(final InputCreatePersonDTO input) {
        final var person = buildPerson(input);
        final var exists = verifyIfPersonAlreadyExists(person);
        if (exists)
            throw new DomainException("Person already exists");
        this.personRepository.create(person);
        return buildOutput(person);
    }

    private Person buildPerson(final InputCreatePersonDTO input) {
        final var address = new Address(input.address().street(), input.address().number(), input.address().zipCode());
        return Person.create(input.name(), input.cpf(), input.sex(), input.motherName(), input.email(), input.birthDate(), address);
    }

    private boolean verifyIfPersonAlreadyExists(final Person person) {
        return Objects.nonNull(this.personRepository.findByCpf(person.getCpf()));
    }

    private OutputCreatePersonDTO buildOutput(final Person person) {
        final var address = new AddressDTO(person.getAddress().getStreet(), person.getAddress().getNumber(), person.getAddress().getZipCode());
        return new OutputCreatePersonDTO(
                person.getId().getValue(),
                person.getName(),
                person.getCpf(),
                person.getSex(),
                person.getMotherName(),
                person.getEmail(),
                person.getBirthDate(),
                address
        );
    }
}
