package quantitymeasurement.utility;

import quantitymeasurement.exception.QuantityMeasurementException;
import quantitymeasurement.model.Unit;

public class UnitConversionAndAddition {

    /**
     * TASK : To convert one type to A common base.
     * @param value
     * @param unitType
     * @return
     */
    public double convertToCommonBase(double value, Unit.UnitType unitType) {
        if(unitType.equals(Unit.UnitType.CELSIUS))
            return value * unitType.conversionToBaseFactor + 32;
        return value * unitType.conversionToBaseFactor;
    }

    /**
     * TASK: To Add values in two units and return result to in common base unit.
     * @param unit1
     * @param unit2
     * @return result in common base unit.
     */
    public double addValues(Unit unit1, Unit unit2) {
        if(unit1.unitType.unitCategory.equals(unit2.unitType.unitCategory))
            return convertToCommonBase(unit1.value, unit1.unitType)
                    + convertToCommonBase(unit2.value, unit2.unitType) ;
        throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.DIFFERENT_CATEGORIES,
                "DIFFERENT UNIT CATEGORIES");
    }
}
