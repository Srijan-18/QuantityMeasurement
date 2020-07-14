package quantitymeasurement.model;

import quantitymeasurement.exception.QuantityMeasurementException;

public class Inch {

    public double value;

    public Inch(Double value) throws QuantityMeasurementException {
        try {
            this.value = value;
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.NULL_VALUE,
                    " NUll Value");
        }
    }

    public boolean checkType( Object checkObject) throws QuantityMeasurementException {
        if (checkObject.getClass() != getClass())
            throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.TYPE_MISMATCH,
                    "TYPE NOT SAME");
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != getClass()) return false;
        Inch inch = (Inch) o;
        return Double.compare(inch.value, value) == 0;
    }
}