package com.academicplus.aplication.shared;

import com.academicplus.domain.shared.Address;

public record AddressDTO(String street, String number, String zipCode) {
    public static AddressDTO from(Address address) {
        return new AddressDTO(address.getStreet(), address.getNumber(), address.getZipCode());
    }

    public Address toAddress() {
        return new Address(street, number, zipCode);
    }
}
