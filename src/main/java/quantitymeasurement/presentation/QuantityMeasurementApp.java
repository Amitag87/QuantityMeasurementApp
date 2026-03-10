package quantitymeasurement.presentation;

import quantitymeasurement.model.LengthUnit;
import quantitymeasurement.model.QuantityLength;
import quantitymeasurement.service.QuantityService;

public class QuantityMeasurementApp {

    public static void demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
        try {
            double result = QuantityLength.convert(value, fromUnit, toUnit);
            System.out.printf("Converting %.2f %s to %s: %.6f%n", 
                value, fromUnit.name().toLowerCase(), toUnit.name().toLowerCase(), result);
        } catch (IllegalArgumentException e) {
            System.out.println("Conversion error: " + e.getMessage());
        }
    }

    public static void demonstrateLengthConversion(QuantityLength quantity, LengthUnit toUnit) {
        try {
            QuantityLength result = quantity.convertTo(toUnit);
            System.out.printf("Converting %s to %s: %s%n", 
                quantity.toString(), toUnit.name().toLowerCase(), result.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Conversion error: " + e.getMessage());
        }
    }

 
    public static void demonstrateLengthEquality(QuantityLength length1, QuantityLength length2) {
        boolean isEqual = length1.equals(length2);
        System.out.printf("%s equals %s: %b%n", length1.toString(), length2.toString(), isEqual);
    }

  
    public static void demonstrateLengthComparison(double value1, LengthUnit unit1, double value2, LengthUnit unit2) {
        QuantityLength length1 = new QuantityLength(value1, unit1);
        QuantityLength length2 = new QuantityLength(value2, unit2);
        demonstrateLengthEquality(length1, length2);
    }

    public static void demonstrateLengthAddition(QuantityLength length1, QuantityLength length2) {
        try {
            QuantityLength result = length1.add(length2);
            System.out.printf("%s + %s = %s%n", length1.toString(), length2.toString(), result.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Addition error: " + e.getMessage());
        }
    }

    public static void demonstrateLengthAddition(double value1, LengthUnit unit1, double value2, LengthUnit unit2, LengthUnit targetUnit) {
        try {
            QuantityLength q1 = new QuantityLength(value1, unit1);
            QuantityLength q2 = new QuantityLength(value2, unit2);
            QuantityLength result = QuantityLength.add(q1, q2, targetUnit);
            System.out.printf("%.2f %s + %.2f %s = %s%n", 
                value1, unit1.name().toLowerCase(), value2, unit2.name().toLowerCase(), result.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Addition error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        QuantityService service = new QuantityService();

        System.out.println("=== UC5: Unit-to-Unit Conversion Demo ===");
        
     
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCH);
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        demonstrateLengthConversion(36.0, LengthUnit.INCH, LengthUnit.YARDS);
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCH);
        demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCH);
        
        System.out.println();
        
       
        QuantityLength lengthInYards = new QuantityLength(2.0, LengthUnit.YARDS);
        demonstrateLengthConversion(lengthInYards, LengthUnit.INCH);
        
        System.out.println();
     
        demonstrateLengthComparison(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCH);
        demonstrateLengthComparison(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET);
        
        System.out.println();
        System.out.println("=== UC6: Addition of Two Length Units Demo ===");
        
        demonstrateLengthAddition(1.0, LengthUnit.FEET, 2.0, LengthUnit.FEET, LengthUnit.FEET);
        demonstrateLengthAddition(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCH, LengthUnit.FEET);
        demonstrateLengthAddition(12.0, LengthUnit.INCH, 1.0, LengthUnit.FEET, LengthUnit.INCH);
        demonstrateLengthAddition(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET, LengthUnit.YARDS);
        demonstrateLengthAddition(2.54, LengthUnit.CENTIMETERS, 1.0, LengthUnit.INCH, LengthUnit.CENTIMETERS);
        demonstrateLengthAddition(5.0, LengthUnit.FEET, 0.0, LengthUnit.INCH, LengthUnit.FEET);
        demonstrateLengthAddition(5.0, LengthUnit.FEET, -2.0, LengthUnit.FEET, LengthUnit.FEET);
        
        System.out.println();
        System.out.println("=== UC7: Addition with Target Unit Specification Demo ===");
        
        demonstrateLengthAddition(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCH, LengthUnit.FEET);
        demonstrateLengthAddition(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCH, LengthUnit.INCH);
        demonstrateLengthAddition(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCH, LengthUnit.YARDS);
        demonstrateLengthAddition(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET, LengthUnit.YARDS);
        demonstrateLengthAddition(36.0, LengthUnit.INCH, 1.0, LengthUnit.YARDS, LengthUnit.FEET);
        demonstrateLengthAddition(2.54, LengthUnit.CENTIMETERS, 1.0, LengthUnit.INCH, LengthUnit.CENTIMETERS);
        demonstrateLengthAddition(5.0, LengthUnit.FEET, 0.0, LengthUnit.INCH, LengthUnit.YARDS);
        demonstrateLengthAddition(5.0, LengthUnit.FEET, -2.0, LengthUnit.FEET, LengthUnit.INCH);
        
        System.out.println();
        System.out.println("=== UC8: Refactored Unit Enum Demo ===");
        
        System.out.printf("FEET.convertToBaseUnit(12.0) = %.2f%n", LengthUnit.FEET.convertToBaseUnit(12.0));
        System.out.printf("INCH.convertToBaseUnit(12.0) = %.2f%n", LengthUnit.INCH.convertToBaseUnit(12.0));
        System.out.printf("YARDS.convertToBaseUnit(1.0) = %.2f%n", LengthUnit.YARDS.convertToBaseUnit(1.0));
        System.out.printf("FEET.convertFromBaseUnit(2.0) = %.2f%n", LengthUnit.FEET.convertFromBaseUnit(2.0));
        System.out.printf("INCH.convertFromBaseUnit(1.0) = %.2f%n", LengthUnit.INCH.convertFromBaseUnit(1.0));
        System.out.printf("YARDS.convertFromBaseUnit(3.0) = %.2f%n", LengthUnit.YARDS.convertFromBaseUnit(3.0));
        
        System.out.println();
    
        boolean feetResult = service.checkFeetEquality(1.0, 1.0);
        System.out.println("Are 1.0 ft and 1.0 ft equal? " + feetResult);

        boolean inchesResult = service.checkInchesEquality(1.0, 1.0);
        System.out.println("Are 1.0 inch and 1.0 inch equal? " + inchesResult);
    }
}