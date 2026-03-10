package quantitymeasurement.model;

public class Feet {
    private final double value;

    public Feet(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Feet feet = (Feet) obj;
        return Double.compare(feet.value, value) == 0;
    }

    public double getValue() {
        return value;
    }
}