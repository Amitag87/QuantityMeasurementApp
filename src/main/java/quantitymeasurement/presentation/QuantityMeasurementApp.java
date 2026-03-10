package quantitymeasurement.presentation;

import quantitymeasurement.model.LengthUnit;
import quantitymeasurement.model.QuantityLength;
import quantitymeasurement.model.WeightUnit;
import quantitymeasurement.model.QuantityWeight;
import quantitymeasurement.service.QuantityService;

public class QuantityMeasurementApp {

    public static void demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
        try {
            double result = QuantityLength.convert(value, fromUnit, toUnit);
            System.out.println("Converting " + value + " " + fromUnit.name().toLowerCase() + " to " + toUnit.name().toLowerCase() + ": " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Conversion error: " + e.getMessage());
        }
    }

    public static void demonstrateLengthConversion(QuantityLength quantity, LengthUnit toUnit) {
        try {
            QuantityLength result = quantity.convertTo(toUnit);
            System.out.println("Converting " + quantity.toString() + " to " + toUnit.name().toLowerCase() + ": " + result.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Conversion error: " + e.getMessage());
        }
    }

    public static void demonstrateLengthEquality(QuantityLength length1, QuantityLength length2) {
        boolean isEqual = length1.equals(length2);
        System.out.println(length1.toString() + " equals " + length2.toString() + ": " + isEqual);
    }

    public static void demonstrateLengthComparison(double value1, LengthUnit unit1, double value2, LengthUnit unit2) {
        QuantityLength length1 = new QuantityLength(value1, unit1);
        QuantityLength length2 = new QuantityLength(value2, unit2);
        demonstrateLengthEquality(length1, length2);
    }

    public static void demonstrateLengthAddition(QuantityLength length1, QuantityLength length2) {
        try {
            QuantityLength result = length1.add(length2);
            System.out.println(length1.toString() + " + " + length2.toString() + " = " + result.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Addition error: " + e.getMessage());
        }
    }

    public static void demonstrateLengthAddition(double value1, LengthUnit unit1, double value2, LengthUnit unit2, LengthUnit targetUnit) {
        try {
            QuantityLength q1 = new QuantityLength(value1, unit1);
            QuantityLength q2 = new QuantityLength(value2, unit2);
            QuantityLength result = QuantityLength.add(q1, q2, targetUnit);
            System.out.println(value1 + " " + unit1.name().toLowerCase() + " + " + value2 + " " + unit2.name().toLowerCase() + " = " + result.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Addition error: " + e.getMessage());
        }
    }

    public static void demonstrateWeightEquality(QuantityWeight weight1, QuantityWeight weight2) {
        boolean isEqual = weight1.equals(weight2);
        System.out.println(weight1.toString() + " equals " + weight2.toString() + ": " + isEqual);
    }

    public static void demonstrateWeightConversion(double value, WeightUnit fromUnit, WeightUnit toUnit) {
        try {
            double result = QuantityWeight.convert(value, fromUnit, toUnit);
            System.out.println("Converting " + value + " " + fromUnit.name().toLowerCase() + " to " + toUnit.name().toLowerCase() + ": " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Conversion error: " + e.getMessage());
        }
    }

    public static void demonstrateWeightAddition(double value1, WeightUnit unit1, double value2, WeightUnit unit2, WeightUnit targetUnit) {
        try {
            QuantityWeight q1 = new QuantityWeight(value1, unit1);
            QuantityWeight q2 = new QuantityWeight(value2, unit2);
            QuantityWeight result = QuantityWeight.add(q1, q2, targetUnit);
            System.out.println(value1 + " " + unit1.name().toLowerCase() + " + " + value2 + " " + unit2.name().toLowerCase() + " = " + result.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Addition error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== UC9: Weight Measurement Demo ===");
        
        demonstrateWeightEquality(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityWeight(1.0, WeightUnit.KILOGRAM));
        demonstrateWeightEquality(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityWeight(1000.0, WeightUnit.GRAM));
        demonstrateWeightEquality(new QuantityWeight(1.0, WeightUnit.KILOGRAM), new QuantityWeight(2.20462, WeightUnit.POUND));
        
        System.out.println();
        
        demonstrateWeightConversion(1.0, WeightUnit.KILOGRAM, WeightUnit.GRAM);
        demonstrateWeightConversion(2.0, WeightUnit.POUND, WeightUnit.KILOGRAM);
        demonstrateWeightConversion(500.0, WeightUnit.GRAM, WeightUnit.POUND);
        
        System.out.println();
        
        demonstrateWeightAddition(1.0, WeightUnit.KILOGRAM, 2.0, WeightUnit.KILOGRAM, WeightUnit.KILOGRAM);
        demonstrateWeightAddition(1.0, WeightUnit.KILOGRAM, 1000.0, WeightUnit.GRAM, WeightUnit.GRAM);
        demonstrateWeightAddition(1.0, WeightUnit.POUND, 453.592, WeightUnit.GRAM, WeightUnit.POUND);
    }
}