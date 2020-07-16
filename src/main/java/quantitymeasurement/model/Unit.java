package quantitymeasurement.model;

import quantitymeasurement.exception.QuantityMeasurementException;
import quantitymeasurement.enums.UnitType;

public class Unit {

    public UnitType unitType;
    public double value;

    /**
     * Constructor to initialize class variables.
     * @param value
     * @param unitType
     * @throws QuantityMeasurementException
     */
    public Unit(Double value, UnitType unitType) throws QuantityMeasurementException {
        try {
            this.value = value;
            this.unitType = unitType;
        } catch (NullPointerException e) {
            throw new QuantityMeasurementException(QuantityMeasurementException.ExceptionType.NULL_VALUE,
                                                    "Null Value");
        }
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof Unit)) return false;
        Unit unit = (Unit) that;
        return Double.compare(unit.value, value) == 0 &&
                unitType == unit.unitType;
    }
}