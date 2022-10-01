package com.academicplus.aplication.university.create;

import com.academicplus.aplication.shared.AddressDTO;
import com.academicplus.domain.shared.Address;
import com.academicplus.domain.university.University;
import com.academicplus.domain.university.UniversityID;
import com.academicplus.domain.university.UniversityRepository;

import java.util.Objects;

public class CreateUniversityUseCase {
    private final UniversityRepository universityRepository;

    public CreateUniversityUseCase(final UniversityRepository universityRepository) {
        this.universityRepository = Objects.requireNonNull(universityRepository);
    }

    public OutputCreateUniversityDTO execute(final InputCreateUniversityDTO input) {
        final var address = input.address().toAddress();
        final var university = University.create(UniversityID.unique(), input.name(), address);
        this.universityRepository.create(university);
        return new OutputCreateUniversityDTO(university.getId().getValue(), university.getName(), AddressDTO.from(university.getAddress()));
    }
}
