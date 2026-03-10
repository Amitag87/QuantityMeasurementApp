package quantitymeasurement.model;

/**
 * Enum representing weight units with conversion factors relative to kilogram (base unit).
 * Provides methods for unit conversion operations.
 */
public enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Converts a value from this unit to the base unit (kilogram).
     * @param value the value to convert
     * @return the value in kilograms
     */
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    /**
     * Converts a value from the base unit (kilogram) to this unit.
     * @param baseValue the value in kilograms
     * @return the value in this unit
     */
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}
