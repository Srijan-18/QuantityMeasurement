package quantitymeasurement.model;

import quantitymeasurement.exception.QuantityMeasurementException;

public class Unit {

    public enum UnitType {

        INCH(1.0, UnitCategory.LENGTH),
        FEET(12.0, UnitCategory.LENGTH),
        YARD(36.0, UnitCategory.LENGTH),
        CM(1.0/2.5, UnitCategory.LENGTH),
        GALLON(3.78, UnitCategory.VOLUME),
        LITRE(1.0, UnitCategory.VOLUME),
        MILLILITRE(1000.0, UnitCategory.VOLUME);


        public enum UnitCategory {
            LENGTH, VOLUME
        }

       public double conversionToBaseFactor;
       public UnitCategory unitCategory;
        UnitType(double conversionToBaseFactor, UnitCategory unitCategory) {
            this.conversionToBaseFactor = conversionToBaseFactor;
            this.unitCategory = unitCategory;
        }
    }

    public UnitType unitType;
    public double value;

    /**
     *
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unit)) return false;
        Unit unit = (Unit) o;
        return Double.compare(unit.value, value) == 0 &&
                unitType == unit.unitType;
    }
}