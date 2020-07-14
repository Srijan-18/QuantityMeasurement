package quantitymeasurement.model;

import quantitymeasurement.exception.QuantityMeasurementException;

public class Yard {

    public double value;

    public Yard(Double value) throws QuantityMeasurementException {
        try {
            this.value = value;
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.NULL_VALUE, "Null Value");
        }
    }
}
