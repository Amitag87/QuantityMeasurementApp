package quantitymeasurement.model;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Value must be finite");

        this.value = value;
        this.unit = unit;
    }

    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue = unit.convertToBaseUnit(value);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(convertedValue, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {

        if (other == null)
            throw new IllegalArgumentException("Cannot add null quantity");

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double sumBase = thisBase + otherBase;

        double sumInThisUnit = unit.convertFromBaseUnit(sumBase);

        return new Quantity<>(sumInThisUnit, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Cannot add null quantity");

        double thisBase = unit.convertToBaseUnit(value);
        double otherBase = other.unit.convertToBaseUnit(other.value);

        double sumBase = thisBase + otherBase;

        double sumTarget = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(sumTarget, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Quantity<?> that = (Quantity<?>) obj;

        if (!this.unit.getClass().equals(that.unit.getClass()))
            return false;

        double thisBase = unit.convertToBaseUnit(value);
        double thatBase = that.unit.convertToBaseUnit(that.value);

        return Double.compare(thisBase, thatBase) == 0;
    }

    @Override
    public int hashCode() {

        long bits = Double.doubleToLongBits(unit.convertToBaseUnit(value));
        return (int) (bits ^ (bits >>> 32));
    }

    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }
}