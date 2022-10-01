package com.academicplus.aplication.university.find;

import com.academicplus.domain.university.UniversityID;
import com.academicplus.domain.university.UniversityRepository;

import java.util.Objects;

public class FindUniversityByIdUseCase {
    private final UniversityRepository universityRepository;

    public FindUniversityByIdUseCase(final UniversityRepository universityRepository) {
        this.universityRepository = Objects.requireNonNull(universityRepository);
    }

    public OutputFindUniversityByIdDTO execute(final String id) {
        final var university = this.universityRepository.findById(UniversityID.from(id));
        return new OutputFindUniversityByIdDTO(university.getId().getValue(), university.getName(), university.getAddress());
    }
}
