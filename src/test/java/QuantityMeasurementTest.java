import org.junit.Assert;
import org.junit.Test;
import quantitymeasurement.exception.QuantityMeasurementException;
import quantitymeasurement.model.Feet;
import quantitymeasurement.service.QuantityMeasurement;

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
}