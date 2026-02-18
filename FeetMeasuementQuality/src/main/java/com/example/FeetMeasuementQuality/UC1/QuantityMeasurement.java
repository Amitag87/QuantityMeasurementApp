import java.util.Scanner;

public class QuantityMeasurement {

    // Inner Class
    public static class Feet {
        private final double value;   // Immutable field

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        // Overriding equals()
        @Override
        public boolean equals(Object obj) {

            // Same reference check (Reflexive property)
            if (this == obj) {
                return true;
            }

            // Null check
            if (obj == null) {
                return false;
            }

            // Type check
            if (getClass() != obj.getClass()) {
                return false;
            }

            // Cast safely
            Feet other = (Feet) obj;

            // Floating point comparison
            return Double.compare(this.value, other.value) == 0;
        }

        // Always override hashCode when overriding equals
        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first value in feet: ");
            double first = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter second value in feet: ");
            double second = Double.parseDouble(scanner.nextLine());

            Feet f1 = new Feet(first);
            Feet f2 = new Feet(second);

            boolean result = f1.equals(f2);

            System.out.println("Equal (" + result + ")");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter numeric values.");
        }

        scanner.close();
    }
}
