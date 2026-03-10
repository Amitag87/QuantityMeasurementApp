package quantitymeasurement.model;

/**
 * Represents a length measurement with a value and unit.
 * Provides functionality for equality comparison and unit conversion.
 * Immutable value object with thread-safe operations.
 */
public class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    /**
     * Creates a new QuantityLength with the specified value and unit.
     * @param value the numeric value of the measurement
     * @param unit the unit of measurement
     * @throws IllegalArgumentException if unit is null or value is not finite
     */
    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        this.value = value;
        this.unit = unit;
    }

    /**
     * Converts this quantity to the specified target unit.
     * @param targetUnit the unit to convert to
     * @return a new QuantityLength with the converted value
     * @throws IllegalArgumentException if targetUnit is null
     */
    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new QuantityLength(convertedValue, targetUnit);
    }

    /**
     * Static method to convert a value from source unit to target unit.
     * @param value the value to convert
     * @param sourceUnit the source unit
     * @param targetUnit the target unit
     * @return the converted value
     * @throws IllegalArgumentException if units are null or value is not finite
     */
    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (sourceUnit == null || targetUnit == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        
        // Convert to base unit (feet) then to target unit
        double valueInFeet = value * sourceUnit.getConversionFactor();
        return valueInFeet / targetUnit.getConversionFactor();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityLength that = (QuantityLength) obj;
        return Double.compare(this.getValueInFeet(), that.getValueInFeet()) == 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit.name().toLowerCase());
    }

    /**
     * Gets the value converted to the base unit (feet).
     * @return value in feet
     */
    private double getValueInFeet() {
        return value * unit.getConversionFactor();
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    /**
     * Adds another QuantityLength to this one and returns result in this object's unit.
     * @param other the QuantityLength to add
     * @return a new QuantityLength with the sum in this object's unit
     * @throws IllegalArgumentException if other is null
     */
    public QuantityLength add(QuantityLength other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot add null quantity");
        }
        double thisInFeet = this.getValueInFeet();
        double otherInFeet = other.getValueInFeet();
        double sumInFeet = thisInFeet + otherInFeet;
        double sumInThisUnit = sumInFeet / this.unit.getConversionFactor();
        return new QuantityLength(sumInThisUnit, this.unit);
    }

    /**
     * Static method to add two QuantityLength objects and return result in specified unit.
     * @param length1 first quantity
     * @param length2 second quantity
     * @param targetUnit unit for the result
     * @return a new QuantityLength with the sum in target unit
     * @throws IllegalArgumentException if any parameter is null
     */
    public static QuantityLength add(QuantityLength length1, QuantityLength length2, LengthUnit targetUnit) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Cannot add null quantities");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double value1InFeet = length1.getValueInFeet();
        double value2InFeet = length2.getValueInFeet();
        double sumInFeet = value1InFeet + value2InFeet;
        double sumInTargetUnit = sumInFeet / targetUnit.getConversionFactor();
        return new QuantityLength(sumInTargetUnit, targetUnit);
    }
}