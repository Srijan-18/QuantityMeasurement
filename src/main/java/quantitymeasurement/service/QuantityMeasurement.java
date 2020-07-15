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

    public double addValues(Length length1, Length length2) {
        return convertToCommonBase(length1.value, length1.lengthType)
               + convertToCommonBase(length2.value, length2.lengthType) ;
    }
}