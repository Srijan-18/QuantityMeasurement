package quantitymeasurement.service;

import quantitymeasurement.exception.QuantityMeasurementException;
import quantitymeasurement.model.Unit;
import quantitymeasurement.utility.UnitConversionAndAddition;


public class QuantityMeasurement {

    private UnitConversionAndAddition unitConversionAndAddition;

    public QuantityMeasurement() {
        unitConversionAndAddition = new UnitConversionAndAddition();
    }

    /**
     * TASK : To convert one type to A common base.
     * @param value
     * @param unitType
     * @return
     */
    public double convertToCommonBase(double value, Unit.UnitType unitType) {
        return unitConversionAndAddition.convertToCommonBase(value, unitType);
    }

    /**
     * TASK: To Add values in two units and return result to in common base unit.
     * @param unit1
     * @param unit2
     * @return result in common base unit.
     */
    public double addValues(Unit unit1, Unit unit2) {
        return unitConversionAndAddition.addValues(unit1,unit2);
    }

    /**
     * TASK: To Compare values in two units of same category.
     * @param unit1
     * @param unit2
     * @return result of comparison in boolean format
     */
    public boolean compare(Unit unit1, Unit unit2) {
        if (unit1.unitType.unitCategory.equals(unit2.unitType.unitCategory))
            return compareConvertedValues(convertToCommonBase(unit1.value, unit1.unitType),
                                          convertToCommonBase(unit2.value, unit2.unitType));
        throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.DIFFERENT_CATEGORIES,
                                                "DIFFERENT UNIT CATEGORIES");
    }

    /**
     * TASK: To Compare Values with precision of upto fourth decimal place.
     * @param value1
     * @param value2
     * @return result of comparison.
     */
    private boolean compareConvertedValues(double value1, double value2) {
     final double requiredPrecision = 0.0001;
     return Math.abs(value1 - value2) <= requiredPrecision;
    }
}