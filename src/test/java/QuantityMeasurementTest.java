import org.junit.Assert;
import org.junit.Test;
import quantitymeasurement.exception.QuantityMeasurementException;
import quantitymeasurement.model.Feet;
import quantitymeasurement.model.Inch;
import quantitymeasurement.model.Yard;
import quantitymeasurement.service.QuantityMeasurement;
import quantitymeasurement.utility.ConversionType;

public class QuantityMeasurementTest {

    @Test
    public void givenValuesInFeet_ShouldReturnCorrectValueInInches() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement();
        double feet = 1.99;
        double inches = quantityMeasurement.convert(feet);
        Assert.assertEquals(22.8, inches, 0.001);
    }

    @Test
    public void given0FeetAnd0Feet_ShouldReturnTrue() throws QuantityMeasurementException {
        Feet feetValue1 = new Feet(0.0);
        Feet feetValue2 = new Feet(0.0);
        Assert.assertTrue(feetValue1.equals(feetValue2));
    }

    @Test
    public void givenNullFeetValue_ShouldThrowAnException() {
        try {
            Feet feetValue = new Feet(null);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }

    @Test
    public void givenValuesInFeetAndOtherFormToCompare_ShouldReturnFalse() throws QuantityMeasurementException {
        Feet feetValue = new Feet(25.0);
        String checkVariable = "STR";
        Assert.assertFalse(feetValue.equals(checkVariable));
    }

    @Test
    public void givenDifferentValuesInSameFromToCompare_ShouldReturnFalse() throws QuantityMeasurementException {
        Feet feetValue1 = new Feet(24.0);
        Feet feetValue2 = new Feet(36.0);
        Assert.assertFalse(feetValue1.equals(feetValue2));
    }
    @Test
    public void given0InchAnd0Inch_ShouldReturnTrue() throws QuantityMeasurementException {
        Inch inchValue1 = new Inch(0.0);
        Inch inchValue2 = new Inch(0.0);
        Assert.assertTrue(inchValue1.equals(inchValue2));
    }

    @Test
    public void givenInchAndOtherFormToCompare_ShouldReturnFalse() throws QuantityMeasurementException {
        Inch inchValue = new Inch(2.0);
        Feet feetValue = new Feet(2.0);
        Assert.assertFalse(inchValue.equals(feetValue));
    }

    @Test
    public void givenInchWithValueNull_ShouldThroeCustomException() {
        try {
            Inch inch = new Inch(null);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }

    @Test
    public void givenDifferentValuesInInchToCompare_ShouldReturnFalse() throws QuantityMeasurementException {
        Inch inchValue1 = new Inch(4.0);
        Inch inchValue2 = new Inch(6.0);
        Assert.assertFalse(inchValue1.equals(inchValue2));
    }

    @Test
    public void given1YardAnd3Feet_ShouldReturnTrue() throws QuantityMeasurementException {
        Feet feet = new Feet(3.0);
        Yard yard = new Yard(1.0);
       Assert.assertTrue(new QuantityMeasurement()
                        .checkConversion(yard.value, feet.value, ConversionType.FEET_TO_YARD));
    }
}