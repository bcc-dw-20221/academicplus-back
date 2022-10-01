package com.academicplus.domain.calendar;

import com.academicplus.domain.ValueObject;
import com.academicplus.domain.exception.DomainException;

import java.util.Objects;

public class SchoolYear extends ValueObject {
    private final Integer year;
    private final Integer period;

    public SchoolYear(final Integer year, final Integer period) {
        this.year = year;
        this.period = period;
        this.validate();
    }

    private void validate() {
        if (Objects.isNull(year))
            throw new DomainException("'%s' can not be null".formatted(year));
        if (Objects.isNull(period))
            throw new DomainException("'%s' can not be null".formatted(period));
    }

    public int getYear() {
        return year;
    }

    public int getPeriod() {
        return period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolYear that = (SchoolYear) o;
        return getYear() == that.getYear() && getPeriod() == that.getPeriod();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getPeriod());
    }

    @Override
    public String toString() {
        return "SchoolYear{" +
                "year=" + year +
                ", period=" + period +
                '}';
    }
}
