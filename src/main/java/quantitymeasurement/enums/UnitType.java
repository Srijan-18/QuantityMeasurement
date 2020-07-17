package quantitymeasurement.enums;

/**
 * UNIT TYPE enum that contains information of unit category and relation with base unit.
 */
public enum UnitType {

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
