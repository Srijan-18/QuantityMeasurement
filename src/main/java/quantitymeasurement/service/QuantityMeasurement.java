package quantitymeasurement.service;

import quantitymeasurement.utility.ConversionType;

public class QuantityMeasurement {
    /**
     * TASK: to convert from feet to inches.
     * @param feet
     * @return
     */
    public double convert(double feet) {
        return new ConversionFactor().feetToInch(feet);
    }

    public<T> boolean compare ( T value1, T value2) {
        return value1.equals(value2);
    }

    public boolean checkConversion(double value1, double value2, ConversionType conversionType) {
        return value1*conversionType.value == value2;
    }
}