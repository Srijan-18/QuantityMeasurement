package quantitymeasurement.model;

import quantitymeasurement.exception.QuantityMeasurementException;

public class Length {

    public enum LengthType {
        INCH(1.0),
        FEET(12.0),
        YARD(36.0),
        CM(1.0/2.5);
       public double conversionToBaseFactor;
        LengthType(double conversionToBaseFactor) {
            this.conversionToBaseFactor = conversionToBaseFactor;
        }
    }
    public LengthType lengthType;
    public double value;

    /**
     *
     * @param value
     * @param lengthType
     * @throws QuantityMeasurementException
     */
    public Length(Double value, LengthType lengthType) throws QuantityMeasurementException {
        try {
            this.value = value;
            this.lengthType = lengthType;
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.NULL_VALUE,
                                                    "Null Value");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        Length length = (Length) o;
        return Double.compare(length.value, value) == 0 &&
                lengthType == length.lengthType;
    }
}