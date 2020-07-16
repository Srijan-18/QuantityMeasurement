package quantitymeasurement.model;

import quantitymeasurement.exception.QuantityMeasurementException;

public class Unit {

    public enum UnitType {
        /**
         * UNIT TYPE enums that contain information of unit category and relation with base unit.
         */
        INCH(1.0, UnitCategory.LENGTH),
        FEET(12.0, UnitCategory.LENGTH),
        YARD(36.0, UnitCategory.LENGTH),
        CM(1.0/2.5, UnitCategory.LENGTH),
        GALLON(3.78, UnitCategory.VOLUME),
        LITRE(1.0, UnitCategory.VOLUME),
        MILLILITRE(0.001, UnitCategory.VOLUME),
        GRAM(0.001, UnitCategory.WEIGHT),
        KILOGRAM(1.0, UnitCategory.WEIGHT),
        TONNE(1000, UnitCategory.WEIGHT),
        CELSIUS(1.8, UnitCategory.TEMPERATURE),
        FAHRENHEIT(1, UnitCategory.TEMPERATURE);

        /**
         * Enum to store Unit category,used to facilitate conversion and addition of same categories only.
         */
        public enum UnitCategory {
            LENGTH, VOLUME, WEIGHT, TEMPERATURE;
        }

       public double conversionToBaseFactor;
       public UnitCategory unitCategory;

        /**
         * Constructor of enum to initialize conversionToBaseFactor adn UnitCategory through specific enum constants.
         * @param conversionToBaseFactor
         * @param unitCategory
         */
        UnitType(double conversionToBaseFactor, UnitCategory unitCategory) {
            this.conversionToBaseFactor = conversionToBaseFactor;
            this.unitCategory = unitCategory;
        }
    }

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