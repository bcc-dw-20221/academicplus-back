package com.academicplus.domain.university;

import com.academicplus.domain.shared.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    @Test
    void shouldCreateAnUniversity() {
        final var expectedId = UniversityID.from("13");
        final var expectedName = "Campus Aracati";
        final var expectedAddress = new Address("Rua Ana Teles", "45", "62842-000");

        final var university = University.create(expectedId, expectedName, expectedAddress);

        assertEquals(expectedId, university.getId());
        assertEquals(expectedName, university.getName());
        assertEquals(expectedAddress, university.getAddress());
        assertNotNull(university.getCreatedAt());
        assertNotNull(university.getUpdatedAt());
        assertNull(university.getDeletedAt());
    }

    @Test
    void shouldUpdateAddressOfAnUniversity() {
        final var expectedId = UniversityID.from("13");
        final var expectedName = "Campus Aracati";
        final var oldAddress = new Address("Rua Ana Teles", "46", "62842-000");

        final var university = University.create(expectedId, expectedName, oldAddress);

        assertEquals(oldAddress, university.getAddress());

        final var lastUpdatedAt = university.getUpdatedAt();
        final var newAddress = new Address("Rua Ana Teles", "45", "62842-000");
        university.update(university.getName(), newAddress);

        assertEquals(expectedId, university.getId());
        assertEquals(expectedName, university.getName());
        assertEquals(newAddress, university.getAddress());
        assertNotNull(university.getCreatedAt());
        assertTrue(university.getUpdatedAt().isAfter(lastUpdatedAt));
        assertNull(university.getDeletedAt());
    }

}