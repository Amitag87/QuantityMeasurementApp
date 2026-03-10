package quantitymeasurement.model;

public class QuantityLength {
    private final double value;
    private final LengthUnit unit;

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


    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new QuantityLength(convertedValue, targetUnit);
    }

    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (sourceUnit == null || targetUnit == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        double baseValue = sourceUnit.convertToBaseUnit(value);
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityLength that = (QuantityLength) obj;
        double thisBase = unit.convertToBaseUnit(value);
        double thatBase = that.unit.convertToBaseUnit(that.value);
        return Double.compare(thisBase, thatBase) == 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit.name().toLowerCase());
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public QuantityLength add(QuantityLength other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot add null quantity");
        }
        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);
        double sumBase = thisBase + otherBase;
        double sumInThisUnit = unit.convertFromBaseUnit(sumBase);
        return new QuantityLength(sumInThisUnit, unit);
    }

    public static QuantityLength add(QuantityLength length1, QuantityLength length2, LengthUnit targetUnit) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Cannot add null quantities");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double value1Base = length1.unit.convertToBaseUnit(length1.value);
        double value2Base = length2.unit.convertToBaseUnit(length2.value);
        double sumBase = value1Base + value2Base;
        double sumInTargetUnit = targetUnit.convertFromBaseUnit(sumBase);
        return new QuantityLength(sumInTargetUnit, targetUnit);
    }
}