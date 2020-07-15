package quantitymeasurement.model;

import quantitymeasurement.exception.QuantityMeasurementException;

public class Feet {
    public double value;

    public Feet(Double value) throws QuantityMeasurementException {
        try {
            this.value = value;
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.NULL_VALUE,
                                                    "Null Value");
        }
    }

    public boolean checkReference(Object checkObject) throws QuantityMeasurementException {
        if (this != checkObject)
            throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.DIFFERENT_REFERENCE,
                                                    "Reference Not Same");
        return true;
    }

    public boolean checkType(Object checkObject) throws QuantityMeasurementException {
        if (checkObject.getClass() != getClass())
         throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.TYPE_MISMATCH,
                                                "TYPE NOT SAME");
        return true;
    }

    @Override
    public boolean equals(Object o) {
        Feet feet = (Feet) o;
        return Double.compare(feet.value, value) == 0;
    }
}