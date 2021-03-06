package quantitymeasurement.service;

import quantitymeasurement.enums.UnitCategory;
import quantitymeasurement.enums.UnitType;
import quantitymeasurement.exception.QuantityMeasurementOperationsException;
import quantitymeasurement.model.Unit;

public class QuantityMeasurementOperations {

    /**
     * TASK : To convert one type to a common base.
     * @param value
     * @param unitType
     * @return
     */
    public double convertToCommonBase(double value, UnitType unitType) {
        final double TEMPERATURE_ADDITION_FACTOR = 32.0;
        if(unitType.equals(UnitType.CELSIUS))
            return value * unitType.conversionToBaseFactor + TEMPERATURE_ADDITION_FACTOR;
        return value * unitType.conversionToBaseFactor;
    }

    /**
     * TASK: To Add values in two units and return result to in common base unit.
     * @param unit1
     * @param unit2
     * @return result in common base unit.
     */
    public double addValues(Unit unit1, Unit unit2) {
        if(unit1.value < 0.0 || unit2.value < 0.0 )
            throw new QuantityMeasurementOperationsException(QuantityMeasurementOperationsException.ExceptionType.NEGATIVE_VALUE,
                                                   "Negative Value");
        if(unit1.unitType.unitCategory.equals(UnitCategory.TEMPERATURE) &&
                unit2.unitType.unitCategory.equals(UnitCategory.TEMPERATURE))
            throw new QuantityMeasurementOperationsException(QuantityMeasurementOperationsException.ExceptionType.TEMPERATURE_ADDITION,
                                                   "TEMPERATURES CAN NOT BE ADDED");
        if(unit1.unitType.unitCategory.equals(unit2.unitType.unitCategory))
            return convertToCommonBase(unit1.value, unit1.unitType)
                    + convertToCommonBase(unit2.value, unit2.unitType) ;
        throw new QuantityMeasurementOperationsException(QuantityMeasurementOperationsException.ExceptionType.DIFFERENT_CATEGORIES,
                                               "DIFFERENT UNIT CATEGORIES");
    }

    /**
     * TASK: To Compare values in two units of same category.
     * @param unit1
     * @param unit2
     * @return result of comparison in boolean format
     */
    public boolean compare(Unit unit1, Unit unit2) {
        if(unit1.value < 0.0 || unit2.value < 0.0 )
            throw new QuantityMeasurementOperationsException(QuantityMeasurementOperationsException.ExceptionType.NEGATIVE_VALUE,
                                                   "Negative Value");
        if (unit1.unitType.unitCategory.equals(unit2.unitType.unitCategory))
            return compareConvertedValues(convertToCommonBase(unit1.value, unit1.unitType),
                                          convertToCommonBase(unit2.value, unit2.unitType));
        throw new QuantityMeasurementOperationsException(QuantityMeasurementOperationsException.ExceptionType.DIFFERENT_CATEGORIES,
                                               "DIFFERENT UNIT CATEGORIES");
    }

    /**
     * TASK: To Compare Values with precision of up to fourth decimal place.
     * @param value1
     * @param value2
     * @return result of comparison.
     */
    private boolean compareConvertedValues(double value1, double value2) {
         final double requiredPrecision = 0.0001;
         return Math.abs(value1 - value2) <= requiredPrecision;
    }
}