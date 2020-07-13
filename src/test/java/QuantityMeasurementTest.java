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
}