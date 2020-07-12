import org.junit.Assert;
import org.junit.Test;
import quantitymeasurement.service.QuantityMeasurement;

public class QuantityMeasurementTest {
    @Test
    public void givenValuesInFeet_ShouldReturnCorrectValueInInches() {
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement();
        double feet = 2.0;
        double inches = quantityMeasurement.convert(feet);
        Assert.assertEquals(24, inches, 0.0);
    }
}