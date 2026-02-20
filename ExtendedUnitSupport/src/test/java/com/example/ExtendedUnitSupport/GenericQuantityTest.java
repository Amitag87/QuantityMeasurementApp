package com.example.ExtendedUnitSupport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GenericQuantityTest {

    @Test
    void testEquality_YardToYard_SameValue() {
        assertTrue(
            new GenericQuantity(1.0, LengthUnit.YARDS)
            .equals(new GenericQuantity(1.0, LengthUnit.YARDS))
        );
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        assertTrue(
            new GenericQuantity(1.0, LengthUnit.YARDS)
            .equals(new GenericQuantity(3.0, LengthUnit.FEET))
        );
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        assertTrue(
            new GenericQuantity(1.0, LengthUnit.YARDS)
            .equals(new GenericQuantity(36.0, LengthUnit.INCH))
        );
    }

    @Test
    void testEquality_CmToInch_EquivalentValue() {
        assertTrue(
            new GenericQuantity(1.0, LengthUnit.CENTIMETERS)
            .equals(new GenericQuantity(0.393701, LengthUnit.INCH))
        );
    }

    @Test
    void testEquality_CmToFeet_NonEquivalent() {
        assertFalse(
            new GenericQuantity(1.0, LengthUnit.CENTIMETERS)
            .equals(new GenericQuantity(1.0, LengthUnit.FEET))
        );
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {

        GenericQuantity yard = new GenericQuantity(1.0, LengthUnit.YARDS);
        GenericQuantity feet = new GenericQuantity(3.0, LengthUnit.FEET);
        GenericQuantity inch = new GenericQuantity(36.0, LengthUnit.INCH);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inch));
        assertTrue(yard.equals(inch));
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new GenericQuantity(1.0, null));
    }

    @Test
    void testNullComparison() {
        assertFalse(
            new GenericQuantity(1.0, LengthUnit.YARDS)
            .equals(null)
        );
    }
}