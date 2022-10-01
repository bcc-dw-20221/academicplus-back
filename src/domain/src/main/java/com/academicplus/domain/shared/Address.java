package com.academicplus.domain.shared;

import com.academicplus.domain.ValueObject;
import com.academicplus.domain.exception.DomainException;

import java.util.Objects;

public class Address extends ValueObject {
    private final String street;
    private final String number;
    private final String zipCode;

    public Address(final String street, final String number, final String zipCode) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.validate();
    }

    private void validate() {
        final var nullOrBlankError = "'%s' can not be null or blank";
        if (Objects.isNull(street) || street.isBlank())
            throw new DomainException(nullOrBlankError.formatted("Street"));
        if (Objects.isNull(number) || number.isBlank())
            throw new DomainException(nullOrBlankError.formatted("Number"));
        if (Objects.isNull(zipCode) || zipCode.isBlank())
            throw new DomainException(nullOrBlankError.formatted("Zip code"));
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getNumber(), address.getNumber()) && Objects.equals(getZipCode(), address.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getNumber(), getZipCode());
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
