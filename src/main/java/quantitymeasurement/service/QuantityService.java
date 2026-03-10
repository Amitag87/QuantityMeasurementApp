package quantitymeasurement.service;

import quantitymeasurement.dao.QuantityDAO;
import quantitymeasurement.model.Feet;
import quantitymeasurement.model.Inches;

public class QuantityService {
    private QuantityDAO dao;

    public QuantityService() {
        this.dao = new QuantityDAO();
    }

    public Feet createFeet(double value) {
        return dao.createFeet(value);
    }

    public Inches createInches(double value) {
        return dao.createInches(value);
    }

    public boolean checkFeetEquality(double value1, double value2) {
        Feet feet1 = createFeet(value1);
        Feet feet2 = createFeet(value2);
        return feet1.equals(feet2);
    }

    public boolean checkInchesEquality(double value1, double value2) {
        Inches inches1 = createInches(value1);
        Inches inches2 = createInches(value2);
        return inches1.equals(inches2);
    }
}