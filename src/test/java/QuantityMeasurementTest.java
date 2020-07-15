import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quantitymeasurement.exception.QuantityMeasurementException;
import quantitymeasurement.model.Length;
import quantitymeasurement.service.QuantityMeasurement;

public class QuantityMeasurementTest {

    private  QuantityMeasurement quantityMeasurement;

    @Before
    public void setUp(){
        quantityMeasurement = new QuantityMeasurement();
    }

    @Test
    public void given0FeetAnd0Feet_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementException {
        Length feetValue1 = new Length(0.0, Length.LengthType.FEET);
        Length feetValue2 = new Length(0.0, Length.LengthType.FEET);
        Assert.assertTrue(feetValue1.equals(feetValue2));
    }

    @Test
    public void givenFeetValue_WhenCheckedForCorrectReference_ShouldReturnTrue() throws QuantityMeasurementException {
        Length feetValue1 = new Length(0.0, Length.LengthType.FEET);
        Assert.assertTrue(feetValue1.equals(feetValue1));
    }

    @Test
    public void givenFeetValue_WhenNull_ShouldThrowAnException() {
        try {
            new Length(null, Length.LengthType.FEET );
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }

    @Test
    public void givenValuesInFeetAndOtherFormWhenCompared_ShouldReturnFalse() throws QuantityMeasurementException {
        Length feetValue = new Length(25.0, Length.LengthType.FEET);
        String checkVariable = "STR";
        Assert.assertFalse(feetValue.equals(checkVariable));
    }

    @Test
    public void givenDifferentValuesInSameFrom_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementException {
        Length feetValue1 = new Length(24.0, Length.LengthType.FEET );
        Length feetValue2 = new Length(36.0, Length.LengthType.FEET);
        Assert.assertFalse(feetValue1.equals(feetValue2));
    }
    @Test
    public void given0InchAnd0Inch_ShouldReturnTrue() throws QuantityMeasurementException {
        Length inchValue1 = new Length(0.0, Length.LengthType.INCH);
        Length inchValue2 = new Length(0.0, Length.LengthType.INCH);
        Assert.assertTrue(inchValue1.equals(inchValue2));
    }

    @Test
    public void givenInchAndOtherForm_WhenCompared_ShouldThrowCustomException() throws QuantityMeasurementException {
        Length inchValue = new Length(2.0 , Length.LengthType.INCH);
        Length lengthValue = new Length(2.0, Length.LengthType.FEET);
            Assert.assertFalse(inchValue.equals(lengthValue));
    }

    @Test
    public void givenInchValue_WhenNull_ShouldThrowCustomException() {
        try {
            new Length(null, Length.LengthType.INCH);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }

    @Test
    public void givenDifferentValuesInInch_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementException {
        Length inchValue1 = new Length(4.0, Length.LengthType.INCH);
        Length inchValue2 = new Length(6.0, Length.LengthType.INCH);
        Assert.assertFalse(inchValue1.equals(inchValue2));
    }

    @Test
    public void givenYardValue_WhenNull_ShouldThrowAnException() {
        try {
            new Length(null, Length.LengthType.YARD);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }

    @Test
    public void given1YardAnd3Feet_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementException {
        Length feet = new Length(3.0, Length.LengthType.FEET);
        Length yard = new Length(1.0, Length.LengthType.YARD);
       Assert.assertEquals(quantityMeasurement.convertToCommonBase(feet.value, feet.lengthType),
                           quantityMeasurement.convertToCommonBase(yard.value , yard.lengthType),
                           0.0001);
    }

    @Test
    public void given1YardAnd1Feet_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementException {
        Length feet = new Length(1.0, Length.LengthType.FEET);
        Length yard = new Length(1.0, Length.LengthType.YARD);
        Assert.assertNotEquals(quantityMeasurement.convertToCommonBase(yard.value, Length.LengthType.YARD),
                                quantityMeasurement.convertToCommonBase(feet.value , feet.lengthType),
                                0.0001);
    }

    @Test
    public void given1InchAnd1Yard_WhenCompared_ShouldReturnFalse() throws QuantityMeasurementException {
        Length inch = new Length(1.0, Length.LengthType.INCH);
        Length yard = new Length(1.0, Length.LengthType.YARD);
        Assert.assertNotEquals(quantityMeasurement.convertToCommonBase(inch.value , inch.lengthType),
                                quantityMeasurement.convertToCommonBase(yard.value, yard.lengthType),
                                0.0001);
    }

    @Test
    public void given1YardAnd36Inch_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementException {
        Length inch = new Length(36.0, Length.LengthType.INCH);
        Length yard = new Length(1.0, Length.LengthType.YARD);
        Assert.assertEquals(quantityMeasurement.convertToCommonBase(yard.value , yard.lengthType),
                            quantityMeasurement.convertToCommonBase(inch.value , inch.lengthType),
                            0.0001);
    }

    @Test
    public void given36InchANd1Yard_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementException {
        Length inch = new Length(36.0, Length.LengthType.INCH);
        Length yard = new Length(1.0, Length.LengthType.YARD);
        Assert.assertEquals(quantityMeasurement.convertToCommonBase(yard.value , yard.lengthType),
                            quantityMeasurement.convertToCommonBase(inch.value, inch.lengthType),
                            0.0001);
    }

    @Test
    public void given1YdAnd3Feet_WhenCompared_ShouldReturnTrue() throws QuantityMeasurementException {
        Length yard = new Length(1.0, Length.LengthType.YARD);
        Length feet = new Length(3.0, Length.LengthType.FEET);
        Assert.assertEquals(quantityMeasurement.convertToCommonBase(yard.value , yard.lengthType),
                            quantityMeasurement.convertToCommonBase(feet.value , feet.lengthType),
                            0.0001);
    }

    @Test
    public void given2InchesAnd5Centimeter_WhenCompared_ShouldReturnTrue() {
        Length inch = new Length(2.0, Length.LengthType.INCH);
        Length centimeter = new Length(5.0, Length.LengthType.CM);
        Assert.assertEquals(quantityMeasurement.convertToCommonBase(centimeter.value , centimeter.lengthType),
                            quantityMeasurement.convertToCommonBase(inch.value , inch.lengthType),
                            0.0001);
    }

    @Test
    public void given2InchesAnd10Centimeter_WhenCompared_ShouldReturnFalse() {
        Length inch = new Length(2.0, Length.LengthType.INCH);
        Length centimeter = new Length(10.0, Length.LengthType.CM);
        Assert.assertNotEquals(quantityMeasurement.convertToCommonBase(centimeter.value , centimeter.lengthType),
                               quantityMeasurement.convertToCommonBase(inch.value , inch.lengthType),
                               0.0001);
    }

    @Test
    public void givenNullInputInCentimeter_WhenChecked_ShouldThrowAnException() {
        try {
            new Length(null, Length.LengthType.CM);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }

    @Test
    public void given2InchAnd2Inch_WhenAdded_ShouldReturn4Inch() {
        Length inch1 = new Length(2.0 , Length.LengthType.INCH);
        Length inch2 = new Length(2.0 , Length.LengthType.INCH);
        double result = quantityMeasurement.addValues(inch1, inch2);
        Assert.assertEquals(result, 4.0, 0.0001);
    }
}