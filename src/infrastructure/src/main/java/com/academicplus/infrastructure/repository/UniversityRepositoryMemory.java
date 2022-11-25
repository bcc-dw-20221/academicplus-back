package com.academicplus.infrastructure.repository;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.university.University;
import com.academicplus.domain.university.UniversityID;
import com.academicplus.domain.university.UniversityRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class UniversityRepositoryMemory implements UniversityRepository {
    private static final List<University> universities = new ArrayList<>();

    static {
        final var address = new Address("Rua abc", "12", "62800-000");
        final var university = University.create(UniversityID.from("1"), "IFCE Aracati", address);
        universities.add(university);
    }

    @Override
    public University create(final University university) {
        universities.add(university);
        return university;
    }

    @Override
    public University findById(UniversityID id) {
        return universities.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    @Override
    public List<University> findAll() {
        return universities;
    }

    @Override
    public boolean existsById(UniversityID universityId) {
        return universities.stream().anyMatch(u -> u.getId().equals(universityId));
    }
}
