package com.example.FeetMeasuementQualityUC2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityMeasurementTest {

    // -------- FEET TESTS --------

    @Test
    void testFeetEquality_SameValue() {
        assertTrue(QuantityMeasurement.compareFeet(1.0, 1.0));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(QuantityMeasurement.compareFeet(1.0, 2.0));
    }

    @Test
    void testFeetEquality_SameReference() {
        QuantityMeasurement.Feet f =
                new QuantityMeasurement.Feet(1.0);
        assertTrue(f.equals(f));
    }

    @Test
    void testFeetEquality_NullComparison() {
        QuantityMeasurement.Feet f =
                new QuantityMeasurement.Feet(1.0);
        assertFalse(f.equals(null));
    }

    @Test
    void testFeetEquality_NonNumericInput() {
        QuantityMeasurement.Feet f =
                new QuantityMeasurement.Feet(1.0);
        assertFalse(f.equals("abc"));
    }

    // -------- INCHES TESTS --------

    @Test
    void testInchEquality_SameValue() {
        assertTrue(QuantityMeasurement.compareInches(1.0, 1.0));
    }

    @Test
    void testInchEquality_DifferentValue() {
        assertFalse(QuantityMeasurement.compareInches(1.0, 2.0));
    }
}
