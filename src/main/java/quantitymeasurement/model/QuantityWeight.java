package quantitymeasurement.model;

/**
 * Represents a weight measurement with a value and unit.
 * Provides functionality for equality comparison, unit conversion, and addition.
 * Immutable value object with thread-safe operations.
 */
public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    /**
     * Creates a new QuantityWeight with the specified value and unit.
     * @param value the numeric value of the measurement
     * @param unit the unit of measurement
     * @throws IllegalArgumentException if unit is null or value is not finite
     */
    public QuantityWeight(double value, WeightUnit unit) {
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
     * @return a new QuantityWeight with the converted value
     * @throws IllegalArgumentException if targetUnit is null
     */
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new QuantityWeight(convertedValue, targetUnit);
    }

    /**
     * Static method to convert a value from source unit to target unit.
     * @param value the value to convert
     * @param sourceUnit the source unit
     * @param targetUnit the target unit
     * @return the converted value
     * @throws IllegalArgumentException if units are null or value is not finite
     */
    public static double convert(double value, WeightUnit sourceUnit, WeightUnit targetUnit) {
        if (sourceUnit == null || targetUnit == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        
        double valueInKilogram = sourceUnit.convertToBaseUnit(value);
        return targetUnit.convertFromBaseUnit(valueInKilogram);
    }

    /**
     * Adds this weight to another weight, returning result in this object's unit.
     * @param other the weight to add
     * @return a new QuantityWeight representing the sum
     * @throws IllegalArgumentException if other is null
     */
    public QuantityWeight add(QuantityWeight other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot add null weight");
        }
        double thisInKg = this.getValueInKilogram();
        double otherInKg = other.getValueInKilogram();
        double sumInKg = thisInKg + otherInKg;
        double sumInThisUnit = this.unit.convertFromBaseUnit(sumInKg);
        return new QuantityWeight(sumInThisUnit, this.unit);
    }

    /**
     * Adds two weights and returns the result in the specified target unit.
     * @param weight1 the first weight
     * @param weight2 the second weight
     * @param targetUnit the unit for the result
     * @return a new QuantityWeight representing the sum in the target unit
     * @throws IllegalArgumentException if any parameter is null
     */
    public static QuantityWeight add(QuantityWeight weight1, QuantityWeight weight2, WeightUnit targetUnit) {
        if (weight1 == null || weight2 == null) {
            throw new IllegalArgumentException("Cannot add null weights");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        
        double sum1InKg = weight1.getValueInKilogram();
        double sum2InKg = weight2.getValueInKilogram();
        double sumInKg = sum1InKg + sum2InKg;
        double sumInTargetUnit = targetUnit.convertFromBaseUnit(sumInKg);
        return new QuantityWeight(sumInTargetUnit, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityWeight that = (QuantityWeight) obj;
        return Double.compare(this.getValueInKilogram(), that.getValueInKilogram()) == 0;
    }

    @Override
    public int hashCode() {
        long bits = Double.doubleToLongBits(getValueInKilogram());
        return (int) (bits ^ (bits >>> 32));
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit.name().toLowerCase());
    }

    /**
     * Gets the value converted to the base unit (kilogram).
     * @return value in kilogram
     */
    private double getValueInKilogram() {
        return unit.convertToBaseUnit(value);
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }
}
