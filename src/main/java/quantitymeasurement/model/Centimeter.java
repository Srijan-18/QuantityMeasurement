package quantitymeasurement.model;

import quantitymeasurement.exception.QuantityMeasurementException;

public class Centimeter {

    public double value;

    public Centimeter(double value) {
        try {
            this.value = value;
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.NULL_VALUE, "Null Value");
        }
    }
}
