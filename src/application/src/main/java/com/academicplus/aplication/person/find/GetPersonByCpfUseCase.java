package com.academicplus.aplication.person.find;

import com.academicplus.domain.person.PersonRepository;

public class GetPersonByCpfUseCase {
    private final PersonRepository personRepository;

    public GetPersonByCpfUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public OutputGetPersonByCpfDTO execute(final String cpf) {
        final var person = personRepository.findByCpf(cpf);
        return OutputGetPersonByCpfDTO.from(person);
    }
}
