package com.example.ExtendedUnitSupport;

import java.util.Objects;

public class GenericQuantity {

    private final double value;
    private final LengthUnit unit;

    public GenericQuantity(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.toBaseUnit(value);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        GenericQuantity other = (GenericQuantity) obj;

        return Double.compare(this.toBaseUnit(),
                              other.toBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBaseUnit());
    }
}