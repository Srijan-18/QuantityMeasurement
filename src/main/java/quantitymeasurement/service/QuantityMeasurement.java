package quantitymeasurement.service;

import quantitymeasurement.utility.ConversionType;

public class QuantityMeasurement {
    /**
     * TASK : To convert one type to another.
     * @param value
     * @param conversionType
     * @return
     */
    public double doConversion(double value, ConversionType conversionType) {
        return value*conversionType.value;
    }
}