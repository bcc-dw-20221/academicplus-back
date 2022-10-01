package com.academicplus.infrastructure.api.shared;

import com.academicplus.domain.shared.Address;

public record AddressDTO(String street, String number, String zipCode) {
    public Address toAddress() {
        return new Address(street, number, zipCode);
    }
}
