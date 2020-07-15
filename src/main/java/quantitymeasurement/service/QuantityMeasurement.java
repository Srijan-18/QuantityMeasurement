package quantitymeasurement.service;

import quantitymeasurement.model.Length;

public class QuantityMeasurement {
    /**
     * TASK : To convert one type to another.
     * @param value
     * @param lengthType
     * @return
     */
    public double convertToCommonBase(double value, Length.LengthType lengthType) {
        return value* lengthType.conversionToBaseFactor;
    }
}