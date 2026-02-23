package com.example.unitToUnitQuantityConversion;


public final class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 1e-6;

   
    public QuantityLength(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite.");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null.");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

   
    public static double convert(double value,
                                 LengthUnit source,
                                 LengthUnit target) {

        validate(value, source, target);

        // Normalize to base unit (feet)
        double valueInBase = value * source.getConversionFactor();

        // Convert to target
        return valueInBase / target.getConversionFactor();
    }

   
    public QuantityLength convertTo(LengthUnit targetUnit) {
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new QuantityLength(convertedValue, targetUnit);
    }

    private static void validate(double value,
                                 LengthUnit source,
                                 LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value.");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units must not be null.");
        }
    }

    /**
     * Equality based on base unit normalization.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityLength)) return false;

        QuantityLength other = (QuantityLength) obj;

        double thisInBase = this.value * this.unit.getConversionFactor();
        double otherInBase = other.value * other.unit.getConversionFactor();

        return Math.abs(thisInBase - otherInBase) < EPSILON;
    }

    @Override
    public int hashCode() {
        double baseValue = value * unit.getConversionFactor();
        return Double.hashCode(baseValue);
    }

    @Override
    public String toString() {
        return String.format("%.4f %s", value, unit.name());
    }
}