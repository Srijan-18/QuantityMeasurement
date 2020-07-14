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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inch)) return false;
        Inch inch = (Inch) o;
        return Double.compare(inch.value, value) == 0;
    }
}
