import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quantitymeasurement.enums.UnitType;
import quantitymeasurement.exception.QuantityMeasurementOperationsException;
import quantitymeasurement.model.Unit;
import quantitymeasurement.service.QuantityMeasurementOperations;

public class QuantityMeasurementOperationsTest {

    private QuantityMeasurementOperations quantityMeasurementOperations;

    @Before
    public void setUp() {
        quantityMeasurementOperations = new QuantityMeasurementOperations();
    }

    @Test
    public void given0FeetAnd0Feet_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementOperationsException {
        Unit feetValue1 = new Unit(0.0, UnitType.FEET);
        Unit feetValue2 = new Unit(0.0, UnitType.FEET);
        Assert.assertTrue(feetValue1.equals(feetValue2));
    }

    @Test
    public void givenFeetValue_WhenCheckedForCorrectReference_ShouldReturnTrue() throws QuantityMeasurementOperationsException {
        Unit feetValue1 = new Unit(0.0, UnitType.FEET);
        Assert.assertTrue(feetValue1.equals(feetValue1));
    }

    @Test
    public void givenFeetValue_WhenNull_ShouldThrowAnException() {
        Unit feetValue1 = new Unit(0.0, UnitType.FEET);
        Unit feetValue2 = null;
        Assert.assertFalse(feetValue1.equals(feetValue2));
    }

    @Test
    public void givenValuesInFeetAndOtherFormWhenCompared_ShouldReturnFalse() throws QuantityMeasurementOperationsException {
        Unit feetValue = new Unit(25.0, UnitType.FEET);
        String checkVariable = "STR";
        Assert.assertFalse(feetValue.equals(checkVariable));
    }

    @Test
    public void givenDifferentValuesInSameFrom_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementOperationsException {
        Unit feetValue1 = new Unit(24.0, UnitType.FEET);
        Unit feetValue2 = new Unit(36.0, UnitType.FEET);
        Assert.assertFalse(feetValue1.equals(feetValue2));
    }

    @Test
    public void given0InchAnd0Inch_ShouldReturnTrue() throws QuantityMeasurementOperationsException {
        Unit inchValue1 = new Unit(0.0, UnitType.INCH);
        Unit inchValue2 = new Unit(0.0, UnitType.INCH);
        Assert.assertTrue(inchValue1.equals(inchValue2));
    }

    @Test
    public void givenInchAndOtherForm_WhenCompared_ShouldThrowCustomException() throws QuantityMeasurementOperationsException {
        Unit inchValue = new Unit(2.0, UnitType.INCH);
        Unit lengthValue = new Unit(2.0, UnitType.FEET);
        Assert.assertFalse(inchValue.equals(lengthValue));
    }

    @Test
    public void givenInchValue_WhenNull_ShouldThrowCustomException() {
        Unit inchValue1 = new Unit(0.0, UnitType.INCH);
        Unit inchValue2 = null;
        Assert.assertFalse(inchValue1.equals(inchValue2));
    }

    @Test
    public void givenDifferentValuesInInch_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementOperationsException {
        Unit inchValue1 = new Unit(4.0, UnitType.INCH);
        Unit inchValue2 = new Unit(6.0, UnitType.INCH);
        Assert.assertFalse(inchValue1.equals(inchValue2));
    }

    @Test
    public void givenYardValue_WhenNull_ShouldThrowAnException() {
        Unit yardValue1 = new Unit(0.0, UnitType.YARD);
        Unit yardValue2 = null;
        Assert.assertFalse(yardValue1.equals(yardValue2));
    }

    @Test
    public void given1YardAnd3Feet_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementOperationsException {
        Unit feet = new Unit(3.0, UnitType.FEET);
        Unit yard = new Unit(1.0, UnitType.YARD);
        Assert.assertTrue(quantityMeasurementOperations.compare(feet, yard));
    }

    @Test
    public void given1YardAnd1Feet_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementOperationsException {
        Unit feet = new Unit(1.0, UnitType.FEET);
        Unit yard = new Unit(1.0, UnitType.YARD);
        Assert.assertFalse(quantityMeasurementOperations.compare(feet, yard));
    }

    @Test
    public void given1InchAnd1Yard_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementOperationsException {
        Unit inch = new Unit(1.0, UnitType.INCH);
        Unit yard = new Unit(1.0, UnitType.YARD);
        Assert.assertFalse(quantityMeasurementOperations.compare(inch, yard));
    }

    @Test
    public void given1YardAnd36Inch_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementOperationsException {
        Unit inch = new Unit(36.0, UnitType.INCH);
        Unit yard = new Unit(1.0, UnitType.YARD);
        Assert.assertTrue(quantityMeasurementOperations.compare(inch, yard));
    }

    @Test
    public void given36InchANd1Yard_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementOperationsException {
        Unit inch = new Unit(36.0, UnitType.INCH);
        Unit yard = new Unit(1.0, UnitType.YARD);
        Assert.assertTrue(quantityMeasurementOperations.compare(yard, inch));
    }

    @Test
    public void given1YdAnd3Feet_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementOperationsException {
        Unit yard = new Unit(1.0, UnitType.YARD);
        Unit feet = new Unit(3.0, UnitType.FEET);
        Assert.assertTrue(quantityMeasurementOperations.compare(yard, feet));
    }

    @Test
    public void given2InchesAnd5Centimeter_WhenCompared_ShouldReturnTrue() {
        Unit inch = new Unit(2.0, UnitType.INCH);
        Unit centimeter = new Unit(5.0, UnitType.CM);
        Assert.assertTrue(quantityMeasurementOperations.compare(inch, centimeter));
    }

    @Test
    public void given2InchesAnd10Centimeter_WhenCompared_ShouldReturnFalse() {
        Unit inch = new Unit(2.0, UnitType.INCH);
        Unit centimeter = new Unit(10.0, UnitType.CM);
        Assert.assertFalse(quantityMeasurementOperations.compare(inch, centimeter));
    }

    @Test
    public void givenNullInputInCentimeter_WhenChecked_ShouldThrowAnException() {
        Unit centimeterValue1 = new Unit(0.0, UnitType.CM);
        Unit centimeterValue2 = null;
        Assert.assertFalse(centimeterValue1.equals(centimeterValue2));
    }

    @Test
    public void given2InchAnd2Inch_WhenAdded_ShouldReturn4Inch() {
        Unit inch1 = new Unit(2.0, UnitType.INCH);
        Unit inch2 = new Unit(2.0, UnitType.INCH);
        double result = quantityMeasurementOperations.addValues(inch1, inch2);
        Assert.assertEquals(result, 4.0, 0.0001);
    }

    @Test
    public void given1FeetAnd2Inches_WhenAdded_ShouldReturn14Inches() {
        Unit feet = new Unit(1.0, UnitType.FEET);
        Unit inch = new Unit(2.0, UnitType.INCH);
        double result = quantityMeasurementOperations.addValues(feet, inch);
        Assert.assertEquals(result, 14.0, 0.0001);
    }

    @Test
    public void given1FeetAnd1Feet_WhenAdded_ShouldReturn24Inches() {
        Unit feet1 = new Unit(1.0, UnitType.FEET);
        Unit feet2 = new Unit(1.0, UnitType.FEET);
        double result = quantityMeasurementOperations.addValues(feet1, feet2);
        Assert.assertEquals(result, 24.0, 0.0001);
    }

    @Test
    public void givenValuesInInchesAndCentimeter_WhenAdded_ShouldReturnResultInInches() {
        Unit inch = new Unit(2.0, UnitType.INCH);
        Unit centimeter = new Unit(2.5, UnitType.CM);
        double result = quantityMeasurementOperations.addValues(inch, centimeter);
        Assert.assertEquals(result, 3.0, 0.0001);
    }

    @Test
    public void givenValuesGallonAndLitreToCompare_WhenCorrect_ShouldReturnTrue() {
        Unit gallon = new Unit(1.0, UnitType.GALLON);
        Unit litre = new Unit(3.78, UnitType.LITRE);
        Assert.assertTrue(quantityMeasurementOperations.compare(gallon, litre));
    }

    @Test
    public void givenValuesGallonAndLitreToCompare_WhenInCorrect_ShouldReturnTrue() {
        Unit gallon = new Unit(1.0, UnitType.GALLON);
        Unit litre = new Unit(1.0, UnitType.LITRE);
        Assert.assertFalse(quantityMeasurementOperations.compare(gallon, litre));
    }

    @Test
    public void givenValuesInMillilitreAndLitreToCompare_WhenCorrect_ShouldReturnTrue() {
        Unit millilitre = new Unit(1000.0, UnitType.MILLILITRE);
        Unit litre = new Unit(1.0, UnitType.LITRE);
        Assert.assertTrue(quantityMeasurementOperations.compare(millilitre, litre));
    }

    @Test
    public void givenValuesInMillilitreAndLitreToCompare_WhenInCorrect_ShouldReturnTrue() {
        Unit millilitre = new Unit(10.0, UnitType.MILLILITRE);
        Unit litre = new Unit(1.0, UnitType.LITRE);
        Assert.assertFalse(quantityMeasurementOperations.compare(millilitre, litre));
    }

    @Test
    public void givenValuesInGallonAndLitres_WhenAdded_ShouldReturnResultInLitres() {
        Unit gallon = new Unit(1.0, UnitType.GALLON);
        Unit litre = new Unit(3.78, UnitType.LITRE);
        Assert.assertEquals(7.56, quantityMeasurementOperations.addValues(litre, gallon), 0.00);
    }

    @Test
    public void givenValuesInMillilitresAndLitres_WhenAdded_ShouldReturnResultInLitres() {
        Unit millilitre = new Unit(10.0, UnitType.MILLILITRE);
        Unit litre = new Unit(1.0, UnitType.LITRE);
        Assert.assertEquals(1.010, quantityMeasurementOperations.addValues(litre, millilitre), 0.00);
    }

    @Test
    public void givenLitreValue_WhenNull_ShouldThrowCustomException() {
        Unit litreValue1 = new Unit(0.0, UnitType.LITRE);
        Unit litreValue2 = null;
        Assert.assertFalse(litreValue1.equals(litreValue2));
    }

    @Test
    public void givenValuesInGramAndKiloGramToCompare_WhenCorrect_ShouldReturnTrue() {
        Unit grams = new Unit(1000.0, UnitType.GRAM);
        Unit kilogram = new Unit(1.0, UnitType.KILOGRAM);
        Assert.assertTrue(quantityMeasurementOperations.compare(grams, kilogram));
    }

    @Test
    public void givenValuesInTonnesAndKilogramsToCompare_WhenCorrect_ShouldReturnTrue() {
        Unit tonne = new Unit(10.0, UnitType.TONNE);
        Unit kilogram = new Unit(10000.0, UnitType.KILOGRAM);
        Assert.assertTrue(quantityMeasurementOperations.compare(tonne, kilogram));
    }

    @Test
    public void givenValuesInTonneAndKilograms_WhenAdded_ShouldReturnResultInKilograms() {
        Unit tonne = new Unit(1.0, UnitType.TONNE);
        Unit kilogram = new Unit(1250.0, UnitType.KILOGRAM);
        Assert.assertEquals(2250.0, quantityMeasurementOperations.addValues(tonne, kilogram), 0.0);
    }

    @Test
    public void givenValueInCelsiusAndFahrenheitToCompare_WhenCorrect_ShouldReturnTrue() {
        Unit celsius = new Unit(50.0, UnitType.CELSIUS);
        Unit fahrenheit = new Unit(122.0, UnitType.FAHRENHEIT);
        Assert.assertTrue(quantityMeasurementOperations.compare(fahrenheit, celsius));
    }

    @Test
    public void givenValuesToAdd_WhenUnitCategoriesMismatch_ShouldThrowAnException() {
        Unit litre = new Unit(1.0, UnitType.LITRE);
        Unit kilogram = new Unit(1250.0, UnitType.KILOGRAM);
        try {
            quantityMeasurementOperations.addValues(litre, kilogram);
        } catch (QuantityMeasurementOperationsException e) {
            Assert.assertEquals(QuantityMeasurementOperationsException.ExceptionType.DIFFERENT_CATEGORIES, e.type);
        }
    }

    @Test
    public void givenValuesToCompare_WhenUnitCategoriesMismatch_ShouldThrowAnException() {
        Unit litre = new Unit(1.0, UnitType.LITRE);
        Unit kilogram = new Unit(1250.0, UnitType.KILOGRAM);
        try {
            quantityMeasurementOperations.compare(litre, kilogram);
        } catch (QuantityMeasurementOperationsException e) {
            Assert.assertEquals(QuantityMeasurementOperationsException.ExceptionType.DIFFERENT_CATEGORIES, e.type);
        }
    }

    @Test
    public void givenValuesToCompare_WhenNegative_ShouldThrowAnException() {
        Unit litre = new Unit(-1.0, UnitType.LITRE);
        Unit kilogram = new Unit(1250.0, UnitType.KILOGRAM);
        try {
            quantityMeasurementOperations.compare(litre, kilogram);
        } catch (QuantityMeasurementOperationsException e) {
            Assert.assertEquals(QuantityMeasurementOperationsException.ExceptionType.NEGATIVE_VALUE, e.type);
        }
    }

    @Test
    public void givenValuesToAdd_WhenNegative_ShouldThrowAnException() {
        Unit litre = new Unit(-1.0, UnitType.LITRE);
        Unit kilogram = new Unit(1250.0, UnitType.KILOGRAM);
        try {
            quantityMeasurementOperations.addValues(litre, kilogram);
        } catch (QuantityMeasurementOperationsException e) {
            Assert.assertEquals(QuantityMeasurementOperationsException.ExceptionType.NEGATIVE_VALUE, e.type);
        }
    }

    @Test
    public void givenBothTemperatureValues_WhenAdded_ShouldThrowAnException() {
        Unit celsius = new Unit(100.0, UnitType.CELSIUS);
        Unit fahrenheit = new Unit(100.0, UnitType.FAHRENHEIT);
        try {
            quantityMeasurementOperations.addValues(celsius, fahrenheit);
        } catch (QuantityMeasurementOperationsException e) {
            Assert.assertEquals(QuantityMeasurementOperationsException.ExceptionType.TEMPERATURE_ADDITION, e.type);
        }
    }
}