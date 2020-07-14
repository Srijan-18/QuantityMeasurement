package quantitymeasurement.model;

import quantitymeasurement.exception.QuantityMeasurementException;

public class Yard {

    public double value;

    public Yard(double value) throws QuantityMeasurementException {
        try {
            this.value = value;
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.NULL_VALUE, "Null Value");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Yard)) return false;
        Yard yard = (Yard) o;
        return Double.compare(yard.value, value) == 0;
    }
}
