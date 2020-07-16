package quantitymeasurement.service;

import quantitymeasurement.exception.QuantityMeasurementException;
import quantitymeasurement.model.Unit;


public class QuantityMeasurement {
    /**
     * TASK : To convert one type to A common base.
     * @param value
     * @param unitType
     * @return
     */
    public double convertToCommonBase(double value, Unit.UnitType unitType) {
        return value* unitType.conversionToBaseFactor;
    }

    public boolean compare(Unit unit1, Unit unit2) {
        if (unit1.unitType.unitCategory.equals(unit2.unitType.unitCategory))
            return compareConvertedValues(convertToCommonBase(unit1.value, unit1.unitType),
                                          convertToCommonBase(unit2.value, unit2.unitType));
        throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.DIFFERENT_CATEGORIES,
                                                "DIFFERENT UNIT CATEGORIES");
    }

    private boolean compareConvertedValues(double value1, double value2) {
     final double requiredPrecision = 0.0001;
     return Math.abs(value1 - value2) <= requiredPrecision;
    }

    public double addValues(Unit unit1, Unit unit2) {
        if(unit1.unitType.unitCategory.equals(unit2.unitType.unitCategory))
        return convertToCommonBase(unit1.value, unit1.unitType)
               + convertToCommonBase(unit2.value, unit2.unitType) ;
        throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.DIFFERENT_CATEGORIES,
                                                "DIFFERENT UNIT CATEGORIES");
    }
}