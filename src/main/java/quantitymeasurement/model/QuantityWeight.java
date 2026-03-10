package quantitymeasurement.model;
public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

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

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new QuantityWeight(convertedValue, targetUnit);
    }

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
