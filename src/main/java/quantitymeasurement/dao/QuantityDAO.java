package quantitymeasurement.dao;

import quantitymeasurement.model.Feet;
import quantitymeasurement.model.Inches;

public class QuantityDAO {
    
    public Feet createFeet(double value) {
        return new Feet(value);
    }

    public Inches createInches(double value) {
        return new Inches(value);
    }
}