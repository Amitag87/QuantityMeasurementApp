package quantitymeasurement.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_SameValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        assertTrue(feet1.equals(feet2), "1.0 ft should equal 1.0 ft");
    }

    @Test
    public void testEquality_DifferentValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);
        assertFalse(feet1.equals(feet2), "1.0 ft should not equal 2.0 ft");
    }

    @Test
    public void testEquality_NullComparison() {
        Feet feet1 = new Feet(1.0);
        assertFalse(feet1.equals(null), "Feet should not equal null");
    }

    @Test
    public void testEquality_NonNumericInput() {
        Feet feet1 = new Feet(1.0);
        String nonNumeric = "1.0";
        assertFalse(feet1.equals(nonNumeric), "Feet should not equal non-Feet object");
    }

    @Test
    public void testEquality_SameReference() {
        Feet feet1 = new Feet(1.0);
        assertTrue(feet1.equals(feet1), "Feet should equal itself (reflexive)");
    }

    @Test
    public void testInchesEquality_SameValue() {
        Inches inches1 = new Inches(1.0);
        Inches inches2 = new Inches(1.0);
        assertTrue(inches1.equals(inches2), "1.0 inch should equal 1.0 inch");
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Inches inches1 = new Inches(1.0);
        Inches inches2 = new Inches(2.0);
        assertFalse(inches1.equals(inches2), "1.0 inch should not equal 2.0 inch");
    }
 
    @Test
    public void testInchesEquality_NullComparison() {
        Inches inches1 = new Inches(1.0);
        assertFalse(inches1.equals(null), "Inches should not equal null");
    }

    @Test
    public void testInchesEquality_NonNumericInput() {
        Inches inches1 = new Inches(1.0);
        String nonNumeric = "1.0";
        assertFalse(inches1.equals(nonNumeric), "Inches should not equal non-Inches object");
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches inches1 = new Inches(1.0);
        assertTrue(inches1.equals(inches1), "Inches should equal itself (reflexive)");
    }

    // UC3: Generic Quantity Class Tests
    @Test
    public void testEquality_FeetToFeet_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2), "1.0 feet should equal 1.0 feet");
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2), "1.0 inch should equal 1.0 inch");
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2), "1.0 feet should equal 12.0 inches");
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2), "12.0 inches should equal 1.0 feet");
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2), "1.0 feet should not equal 2.0 feet");
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.INCH);
        assertFalse(q1.equals(q2), "1.0 inch should not equal 2.0 inch");
    }

    @Test
    public void testEquality_QuantityLength_SameReference() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(q1.equals(q1), "QuantityLength should equal itself (reflexive)");
    }

    @Test
    public void testEquality_QuantityLength_NullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q1.equals(null), "QuantityLength should not equal null");
    }

    // UC4: Extended Unit Support Tests
    @Test
    public void testEquality_YardToYard_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q2), "1.0 yard should equal 1.0 yard");
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.YARDS);
        assertFalse(q1.equals(q2), "1.0 yard should not equal 2.0 yards");
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        assertTrue(q1.equals(q2), "1.0 yard should equal 3.0 feet");
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q2), "3.0 feet should equal 1.0 yard");
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(36.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2), "1.0 yard should equal 36.0 inches");
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(36.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q2), "36.0 inches should equal 1.0 yard");
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2), "1.0 yard should not equal 2.0 feet");
    }

    @Test
    public void testEquality_CentimetersToCentimeters_SameValue() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.CENTIMETERS);
        assertTrue(q1.equals(q2), "2.0 cm should equal 2.0 cm");
    }

    @Test
    public void testEquality_CentimetersToInches_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(0.393701, LengthUnit.INCH);
        assertTrue(q1.equals(q2), "1.0 cm should equal 0.393701 inches");
    }

    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(q1.equals(q2), "1.0 cm should not equal 1.0 feet");
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength q3 = new QuantityLength(36.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2) && q2.equals(q3) && q1.equals(q3), "Transitive property should hold");
    }

    @Test
    public void testEquality_YardSameReference() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(q1.equals(q1), "Yard should equal itself (reflexive)");
    }

    @Test
    public void testEquality_YardNullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertFalse(q1.equals(null), "Yard should not equal null");
    }

    @Test
    public void testEquality_CentimetersSameReference() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        assertTrue(q1.equals(q1), "Centimeters should equal itself (reflexive)");
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        assertFalse(q1.equals(null), "Centimeters should not equal null");
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(6.0, LengthUnit.FEET);
        QuantityLength q3 = new QuantityLength(72.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2) && q2.equals(q3) && q1.equals(q3), "Complex multi-unit scenario should work");
    }

    // UC5: Unit-to-Unit Conversion Tests
    @Test
    public void testConversion_FeetToInches() {
        double result = QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH);
        assertEquals(12.0, result, 1e-6, "1.0 feet should convert to 12.0 inches");
    }

    @Test
    public void testConversion_InchesToFeet() {
        double result = QuantityLength.convert(24.0, LengthUnit.INCH, LengthUnit.FEET);
        assertEquals(2.0, result, 1e-6, "24.0 inches should convert to 2.0 feet");
    }

    @Test
    public void testConversion_YardsToInches() {
        double result = QuantityLength.convert(1.0, LengthUnit.YARDS, LengthUnit.INCH);
        assertEquals(36.0, result, 1e-6, "1.0 yard should convert to 36.0 inches");
    }

    @Test
    public void testConversion_InchesToYards() {
        double result = QuantityLength.convert(72.0, LengthUnit.INCH, LengthUnit.YARDS);
        assertEquals(2.0, result, 1e-6, "72.0 inches should convert to 2.0 yards");
    }

    @Test
    public void testConversion_CentimetersToInches() {
        double result = QuantityLength.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCH);
        assertEquals(1.0, result, 1e-3, "2.54 cm should convert to ~1.0 inches");
    }

    @Test
    public void testConversion_FeetToYards() {
        double result = QuantityLength.convert(6.0, LengthUnit.FEET, LengthUnit.YARDS);
        assertEquals(2.0, result, 1e-6, "6.0 feet should convert to 2.0 yards");
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double original = 5.0;
        double converted = QuantityLength.convert(original, LengthUnit.FEET, LengthUnit.INCH);
        double backConverted = QuantityLength.convert(converted, LengthUnit.INCH, LengthUnit.FEET);
        assertEquals(original, backConverted, 1e-6, "Round-trip conversion should preserve original value");
    }

    @Test
    public void testConversion_ZeroValue() {
        double result = QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCH);
        assertEquals(0.0, result, 1e-6, "Zero should convert to zero");
    }

    @Test
    public void testConversion_NegativeValue() {
        double result = QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH);
        assertEquals(-12.0, result, 1e-6, "Negative values should convert correctly");
    }

    @Test
    public void testConversion_SameUnit() {
        double result = QuantityLength.convert(5.0, LengthUnit.FEET, LengthUnit.FEET);
        assertEquals(5.0, result, 1e-6, "Same unit conversion should return original value");
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(1.0, null, LengthUnit.FEET);
        }, "Null source unit should throw IllegalArgumentException");
        
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(1.0, LengthUnit.FEET, null);
        }, "Null target unit should throw IllegalArgumentException");
    }

    @Test
    public void testConversion_NaNValue_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCH);
        }, "NaN value should throw IllegalArgumentException");
    }

    @Test
    public void testConversion_InfiniteValue_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCH);
        }, "Infinite value should throw IllegalArgumentException");
    }

    @Test
    public void testConvertTo_InstanceMethod() {
        QuantityLength original = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength converted = original.convertTo(LengthUnit.INCH);
        assertEquals(12.0, converted.getValue(), 1e-6, "Instance convertTo should work correctly");
        assertEquals(LengthUnit.INCH, converted.getUnit(), "Converted unit should be correct");
    }

    @Test
    public void testConvertTo_NullUnit_Throws() {
        QuantityLength quantity = new QuantityLength(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            quantity.convertTo(null);
        }, "convertTo with null unit should throw IllegalArgumentException");
    }

    @Test
    public void testQuantityLength_Constructor_InvalidInputs() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1.0, null);
        }, "Constructor with null unit should throw IllegalArgumentException");
        
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(Double.NaN, LengthUnit.FEET);
        }, "Constructor with NaN value should throw IllegalArgumentException");
    }

    @Test
    public void testToString_Method() {
        QuantityLength quantity = new QuantityLength(1.5, LengthUnit.FEET);
        String result = quantity.toString();
        assertEquals("1.50 feet", result, "toString should format correctly");
    }

    // UC6: Addition of Two Length Units Tests
    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(3.0, result.getValue(), 1e-6, "1 ft + 2 ft should equal 3 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch() {
        QuantityLength q1 = new QuantityLength(6.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(6.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2);
        assertEquals(12.0, result.getValue(), 1e-6, "6 in + 6 in should equal 12 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result unit should be INCH");
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2);
        assertEquals(2.0, result.getValue(), 1e-6, "1 ft + 12 in should equal 2 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(24.0, result.getValue(), 1e-6, "12 in + 1 ft should equal 24 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result unit should be INCH");
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(2.0, result.getValue(), 1e-6, "1 yd + 3 ft should equal 2 yd");
        assertEquals(LengthUnit.YARDS, result.getUnit(), "Result unit should be YARDS");
    }

    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {
        QuantityLength q1 = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2);
        assertEquals(5.08, result.getValue(), 1e-2, "2.54 cm + 1 in should equal ~5.08 cm");
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit(), "Result unit should be CENTIMETERS");
    }

    @Test
    public void testAddition_Commutativity() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result1 = QuantityLength.add(q1, q2, LengthUnit.FEET);
        QuantityLength result2 = QuantityLength.add(q2, q1, LengthUnit.FEET);
        assertEquals(result1.getValue(), result2.getValue(), 1e-6, "Addition should be commutative");
    }

    @Test
    public void testAddition_WithZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2);
        assertEquals(5.0, result.getValue(), 1e-6, "5 ft + 0 in should equal 5 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_NegativeValues() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(3.0, result.getValue(), 1e-6, "5 ft + (-2 ft) should equal 3 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_NullSecondOperand() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            q1.add(null);
        }, "Adding null should throw IllegalArgumentException");
    }

    @Test
    public void testAddition_StaticMethod_NullOperands() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.add(null, q1, LengthUnit.FEET);
        }, "Null first operand should throw IllegalArgumentException");
    }

    @Test
    public void testAddition_LargeValues() {
        QuantityLength q1 = new QuantityLength(1e6, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1e6, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(2e6, result.getValue(), 1e-6, "Large values should add correctly");
    }

    @Test
    public void testAddition_SmallValues() {
        QuantityLength q1 = new QuantityLength(0.001, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.002, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(0.003, result.getValue(), 1e-6, "Small values should add correctly");
    }

    @Test
    public void testAddition_StaticMethod_WithTargetUnit() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(36.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.FEET);
        assertEquals(6.0, result.getValue(), 1e-6, "1 yd + 36 in should equal 6 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_Immutability() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        QuantityLength result = q1.add(q2);
        assertEquals(1.0, q1.getValue(), 1e-6, "Original q1 should remain unchanged");
        assertEquals(2.0, q2.getValue(), 1e-6, "Original q2 should remain unchanged");
    }

    // UC7: Addition with Target Unit Specification Tests
    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.FEET);
        assertEquals(2.0, result.getValue(), 1e-6, "1 ft + 12 in should equal 2 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.INCH);
        assertEquals(24.0, result.getValue(), 1e-6, "1 ft + 12 in should equal 24 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result unit should be INCH");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        assertEquals(0.667, result.getValue(), 1e-3, "1 ft + 12 in should equal ~0.667 yd");
        assertEquals(LengthUnit.YARDS, result.getUnit(), "Result unit should be YARDS");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.CENTIMETERS);
        assertEquals(5.08, result.getValue(), 1e-2, "1 in + 1 in should equal ~5.08 cm");
        assertEquals(LengthUnit.CENTIMETERS, result.getUnit(), "Result unit should be CENTIMETERS");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        assertEquals(3.0, result.getValue(), 1e-6, "2 yd + 3 ft should equal 3 yd");
        assertEquals(LengthUnit.YARDS, result.getUnit(), "Result unit should be YARDS");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.FEET);
        assertEquals(9.0, result.getValue(), 1e-6, "2 yd + 3 ft should equal 9 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result1 = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        QuantityLength result2 = QuantityLength.add(q2, q1, LengthUnit.YARDS);
        assertEquals(result1.getValue(), result2.getValue(), 1e-6, "Addition should be commutative with explicit target unit");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        assertEquals(1.667, result.getValue(), 1e-3, "5 ft + 0 in should equal ~1.667 yd");
        assertEquals(LengthUnit.YARDS, result.getUnit(), "Result unit should be YARDS");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.INCH);
        assertEquals(36.0, result.getValue(), 1e-6, "5 ft + (-2 ft) should equal 36 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result unit should be INCH");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.add(q1, q2, null);
        }, "Null target unit should throw IllegalArgumentException");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
        QuantityLength q1 = new QuantityLength(1000.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(500.0, LengthUnit.FEET);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.INCH);
        assertEquals(18000.0, result.getValue(), 1e-6, "1000 ft + 500 ft should equal 18000 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result unit should be INCH");
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        assertEquals(0.667, result.getValue(), 1e-3, "12 in + 12 in should equal ~0.667 yd");
        assertEquals(LengthUnit.YARDS, result.getUnit(), "Result unit should be YARDS");
    }

    // UC8: Refactoring Unit Enum to Standalone with Conversion Responsibility Tests
    @Test
    public void testLengthUnitEnum_FeetConstant() {
        assertEquals(1.0, LengthUnit.FEET.getConversionFactor(), 1e-6, "FEET conversion factor should be 1.0");
    }

    @Test
    public void testLengthUnitEnum_InchesConstant() {
        assertEquals(0.0833, LengthUnit.INCH.getConversionFactor(), 1e-3, "INCH conversion factor should be ~0.0833");
    }

    @Test
    public void testLengthUnitEnum_YardsConstant() {
        assertEquals(3.0, LengthUnit.YARDS.getConversionFactor(), 1e-6, "YARDS conversion factor should be 3.0");
    }

    @Test
    public void testLengthUnitEnum_CentimetersConstant() {
        assertEquals(0.0328, LengthUnit.CENTIMETERS.getConversionFactor(), 1e-3, "CENTIMETERS conversion factor should be ~0.0328");
    }

    @Test
    public void testConvertToBaseUnit_FeetToFeet() {
        double result = LengthUnit.FEET.convertToBaseUnit(5.0);
        assertEquals(5.0, result, 1e-6, "5 feet to base unit should be 5.0");
    }

    @Test
    public void testConvertToBaseUnit_InchesToFeet() {
        double result = LengthUnit.INCH.convertToBaseUnit(12.0);
        assertEquals(1.0, result, 1e-6, "12 inches to base unit should be 1.0 feet");
    }

    @Test
    public void testConvertToBaseUnit_YardsToFeet() {
        double result = LengthUnit.YARDS.convertToBaseUnit(1.0);
        assertEquals(3.0, result, 1e-6, "1 yard to base unit should be 3.0 feet");
    }

    @Test
    public void testConvertToBaseUnit_CentimetersToFeet() {
        double result = LengthUnit.CENTIMETERS.convertToBaseUnit(30.48);
        assertEquals(1.0, result, 1e-2, "30.48 cm to base unit should be ~1.0 feet");
    }

    @Test
    public void testConvertFromBaseUnit_FeetToFeet() {
        double result = LengthUnit.FEET.convertFromBaseUnit(2.0);
        assertEquals(2.0, result, 1e-6, "2.0 feet from base unit should be 2.0 feet");
    }

    @Test
    public void testConvertFromBaseUnit_FeetToInches() {
        double result = LengthUnit.INCH.convertFromBaseUnit(1.0);
        assertEquals(12.0, result, 1e-6, "1.0 feet from base unit should be 12.0 inches");
    }

    @Test
    public void testConvertFromBaseUnit_FeetToYards() {
        double result = LengthUnit.YARDS.convertFromBaseUnit(3.0);
        assertEquals(1.0, result, 1e-6, "3.0 feet from base unit should be 1.0 yard");
    }

    @Test
    public void testConvertFromBaseUnit_FeetToCentimeters() {
        double result = LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0);
        assertEquals(30.48, result, 1e-2, "1.0 feet from base unit should be ~30.48 cm");
    }

    @Test
    public void testQuantityLengthRefactored_Equality() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        assertTrue(q1.equals(q2), "Refactored equality should work: 1 ft = 12 in");
    }

    @Test
    public void testQuantityLengthRefactored_ConvertTo() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = q1.convertTo(LengthUnit.INCH);
        assertEquals(12.0, result.getValue(), 1e-6, "Refactored convertTo should work: 1 ft = 12 in");
        assertEquals(LengthUnit.INCH, result.getUnit(), "Result unit should be INCH");
    }

    @Test
    public void testQuantityLengthRefactored_Add() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = q1.add(q2);
        assertEquals(2.0, result.getValue(), 1e-6, "Refactored add should work: 1 ft + 12 in = 2 ft");
        assertEquals(LengthUnit.FEET, result.getUnit(), "Result unit should be FEET");
    }

    @Test
    public void testQuantityLengthRefactored_AddWithTargetUnit() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        assertEquals(0.667, result.getValue(), 1e-3, "Refactored add with target unit: 1 ft + 12 in = ~0.667 yd");
        assertEquals(LengthUnit.YARDS, result.getUnit(), "Result unit should be YARDS");
    }

    @Test
    public void testRoundTripConversion_RefactoredDesign() {
        double original = 5.0;
        double toInches = QuantityLength.convert(original, LengthUnit.FEET, LengthUnit.INCH);
        double backToFeet = QuantityLength.convert(toInches, LengthUnit.INCH, LengthUnit.FEET);
        assertEquals(original, backToFeet, 1e-6, "Round-trip conversion should preserve value in refactored design");
    }
}