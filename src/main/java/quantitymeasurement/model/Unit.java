package quantitymeasurement.model;

import quantitymeasurement.exception.QuantityMeasurementOperationsException;
import quantitymeasurement.enums.UnitType;

public class Unit {

    public UnitType unitType;
    public double value;

    /**
     * Constructor to initialize class variables.
     * @param value
     * @param unitType
     * @throws QuantityMeasurementOperationsException
     */
    public Unit(double value, UnitType unitType) throws QuantityMeasurementOperationsException {
            this.value = value;
            this.unitType = unitType;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that ==null || that.getClass() != getClass()) return false;
        Unit unit = (Unit) that;
        return Double.compare(unit.value, value) == 0 &&
                unitType == unit.unitType;
    }
}