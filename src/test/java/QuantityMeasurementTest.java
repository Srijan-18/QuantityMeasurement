import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quantitymeasurement.exception.QuantityMeasurementException;
import quantitymeasurement.model.Unit;
import quantitymeasurement.service.QuantityMeasurement;

public class QuantityMeasurementTest {

    private  QuantityMeasurement quantityMeasurement;

    @Before
    public void setUp(){
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test
    public void given0FeetAnd0Feet_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementException {
        Unit feetValue1 = new Unit(0.0, Unit.UnitType.FEET);
        Unit feetValue2 = new Unit(0.0, Unit.UnitType.FEET);
        Assert.assertTrue(feetValue1.equals(feetValue2));
    }

    @Test
    public void givenFeetValue_WhenCheckedForCorrectReference_ShouldReturnTrue() throws QuantityMeasurementException {
        Unit feetValue1 = new Unit(0.0, Unit.UnitType.FEET);
        Assert.assertTrue(feetValue1.equals(feetValue1));
    }

    @Test
    public void givenFeetValue_WhenNull_ShouldThrowAnException() {
        try {
            new Unit(null, Unit.UnitType.FEET );
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }

    @Test
    public void givenValuesInFeetAndOtherFormWhenCompared_ShouldReturnFalse() throws QuantityMeasurementException {
        Unit feetValue = new Unit(25.0, Unit.UnitType.FEET);
        String checkVariable = "STR";
        Assert.assertFalse(feetValue.equals(checkVariable));
    }

    @Test
    public void givenDifferentValuesInSameFrom_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementException {
        Unit feetValue1 = new Unit(24.0, Unit.UnitType.FEET );
        Unit feetValue2 = new Unit(36.0, Unit.UnitType.FEET);
        Assert.assertFalse(feetValue1.equals(feetValue2));
    }
    @Test
    public void given0InchAnd0Inch_ShouldReturnTrue() throws QuantityMeasurementException {
        Unit inchValue1 = new Unit(0.0, Unit.UnitType.INCH);
        Unit inchValue2 = new Unit(0.0, Unit.UnitType.INCH);
        Assert.assertTrue(inchValue1.equals(inchValue2));
    }

    @Test
    public void givenInchAndOtherForm_WhenCompared_ShouldThrowCustomException() throws QuantityMeasurementException {
        Unit inchValue = new Unit(2.0 , Unit.UnitType.INCH);
        Unit lengthValue = new Unit(2.0, Unit.UnitType.FEET);
        Assert.assertFalse(inchValue.equals(lengthValue));
    }

    @Test
    public void givenInchValue_WhenNull_ShouldThrowCustomException() {
        try {
            new Unit(null, Unit.UnitType.INCH);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }

    @Test
    public void givenDifferentValuesInInch_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementException {
        Unit inchValue1 = new Unit(4.0, Unit.UnitType.INCH);
        Unit inchValue2 = new Unit(6.0, Unit.UnitType.INCH);
        Assert.assertFalse(inchValue1.equals(inchValue2));
    }

    @Test
    public void givenYardValue_WhenNull_ShouldThrowAnException() {
        try {
            new Unit(null, Unit.UnitType.YARD);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }

    @Test
    public void given1YardAnd3Feet_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementException {
        Unit feet = new Unit(3.0, Unit.UnitType.FEET);
        Unit yard = new Unit(1.0, Unit.UnitType.YARD);
       Assert.assertTrue(quantityMeasurement.compare(feet, yard));
    }

    @Test
    public void given1YardAnd1Feet_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementException {
        Unit feet = new Unit(1.0, Unit.UnitType.FEET);
        Unit yard = new Unit(1.0, Unit.UnitType.YARD);
        Assert.assertFalse(quantityMeasurement.compare(feet, yard));
    }

    @Test
    public void given1InchAnd1Yard_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementException {
        Unit inch = new Unit(1.0, Unit.UnitType.INCH);
        Unit yard = new Unit(1.0, Unit.UnitType.YARD);
       Assert.assertFalse(quantityMeasurement.compare(inch, yard));
    }

    @Test
    public void given1YardAnd36Inch_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementException {
        Unit inch = new Unit(36.0, Unit.UnitType.INCH);
        Unit yard = new Unit(1.0, Unit.UnitType.YARD);
       Assert.assertTrue(quantityMeasurement.compare(inch, yard));
    }

    @Test
    public void given36InchANd1Yard_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementException {
        Unit inch = new Unit(36.0, Unit.UnitType.INCH);
        Unit yard = new Unit(1.0, Unit.UnitType.YARD);
       Assert.assertTrue(quantityMeasurement.compare(yard, inch));
    }

    @Test
    public void given1YdAnd3Feet_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementException {
        Unit yard = new Unit(1.0, Unit.UnitType.YARD);
        Unit feet = new Unit(3.0, Unit.UnitType.FEET);
        Assert.assertTrue(quantityMeasurement.compare(yard, feet));
    }

    @Test
    public void given2InchesAnd5Centimeter_WhenCompared_ShouldReturnTrue() {
        Unit inch = new Unit(2.0, Unit.UnitType.INCH);
        Unit centimeter = new Unit(5.0, Unit.UnitType.CM);
        Assert.assertTrue(quantityMeasurement.compare(inch, centimeter));
    }

    @Test
    public void given2InchesAnd10Centimeter_WhenCompared_ShouldReturnFalse() {
        Unit inch = new Unit(2.0, Unit.UnitType.INCH);
        Unit centimeter = new Unit(10.0, Unit.UnitType.CM);
        Assert.assertFalse(quantityMeasurement.compare(inch, centimeter));
    }

    @Test
    public void givenNullInputInCentimeter_WhenChecked_ShouldThrowAnException() {
        try {
            new Unit(null, Unit.UnitType.CM);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }

    @Test
    public void given2InchAnd2Inch_WhenAdded_ShouldReturn4Inch() {
        Unit inch1 = new Unit(2.0 , Unit.UnitType.INCH);
        Unit inch2 = new Unit(2.0 , Unit.UnitType.INCH);
        double result = quantityMeasurement.addValues(inch1, inch2);
        Assert.assertEquals(result, 4.0, 0.0001);
    }

    @Test
    public void given1FeetAnd2Inches_WhenAdded_ShouldReturn14Inches() {
        Unit feet = new Unit(1.0, Unit.UnitType.FEET);
        Unit inch = new Unit(2.0 , Unit.UnitType.INCH);
        double result = quantityMeasurement.addValues(feet, inch);
        Assert.assertEquals(result, 14.0, 0.0001);
    }

    @Test
    public void given1FeetAnd1Feet_WhenAdded_ShouldReturn24Inches() {
        Unit feet1 = new Unit(1.0, Unit.UnitType.FEET);
        Unit feet2 = new Unit(1.0, Unit.UnitType.FEET);
        double result = quantityMeasurement.addValues(feet1, feet2);
        Assert.assertEquals(result, 24.0, 0.0001);
    }

    @Test
    public void givenValuesInInchesAndCentimeter_WhenAdded_ShouldReturnResultInInches() {
        Unit inch = new Unit(2.0 , Unit.UnitType.INCH);
        Unit centimeter = new Unit(2.5, Unit.UnitType.CM);
        double result = quantityMeasurement.addValues(inch, centimeter);
        Assert.assertEquals(result, 3.0, 0.0001);
    }

    @Test
    public void givenValuesGallonAndLitreToCompare_WhenCorrect_ShouldReturnTrue() {
        Unit gallon = new Unit(1.0, Unit.UnitType.GALLON);
        Unit litre = new Unit(3.78, Unit.UnitType.LITRE);
        Assert.assertTrue(quantityMeasurement.compare(gallon, litre));
    }

    @Test
    public void givenValuesGallonAndLitreToCompare_WhenInCorrect_ShouldReturnTrue() {
        Unit gallon = new Unit(1.0, Unit.UnitType.GALLON);
        Unit litre = new Unit(1.0, Unit.UnitType.LITRE);
        Assert.assertFalse(quantityMeasurement.compare(gallon, litre));
    }
}