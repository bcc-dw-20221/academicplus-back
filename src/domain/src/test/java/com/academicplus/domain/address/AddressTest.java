package com.academicplus.domain.address;

import com.academicplus.domain.shared.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void giveAValidParams_whenCallsCreate_thenShouldInstantiateAnAddress() {
        final var street = "Rua Ana Teles";
        final var number = "45";
        final var zipCode = "62842-000";

        final var address = new Address(street, number, zipCode);

        assertEquals(street, address.getStreet());
        assertEquals(number, address.getNumber());
        assertEquals(zipCode, address.getZipCode());
    }

}