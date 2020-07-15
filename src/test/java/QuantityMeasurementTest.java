import org.junit.Assert;
import org.junit.Test;
import quantitymeasurement.exception.QuantityMeasurementException;
import quantitymeasurement.model.Centimeter;
import quantitymeasurement.model.Feet;
import quantitymeasurement.model.Inch;
import quantitymeasurement.model.Yard;
import quantitymeasurement.service.QuantityMeasurement;
import quantitymeasurement.utility.ConversionType;

public class QuantityMeasurementTest {

    @Test
    public void given0FeetAnd0Feet_ShouldReturnTrue() throws QuantityMeasurementException {
        Feet feetValue1 = new Feet(0.0);
        Feet feetValue2 = new Feet(0.0);
        feetValue1.checkType(feetValue2);
        Assert.assertTrue(feetValue1.equals(feetValue2));
    }


    @Test
    public void givenFeetValueAndCheckedForWrongReference_ShouldReturnFalse() {
        try {
            Feet feetValue = new Feet(0.0);
            Feet feetValue1 = new Feet(0.0);
            feetValue.checkReference(feetValue1);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.DIFFERENT_REFERENCE, e.type);
        }
    }

    @Test
    public void givenFeetValueAndCheckedForCorrectReference_ShouldReturnTrue() throws QuantityMeasurementException {
        Feet feetValue1 = new Feet(0.0);
        Assert.assertTrue(feetValue1.checkReference(feetValue1));
    }

    @Test
    public void givenNullFeetValue_ShouldThrowAnException() {
        try {
            new Feet(null);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }

    @Test
    public void givenValuesInFeetAndOtherFormToCompare_ShouldReturnFalse() throws QuantityMeasurementException {
        Feet feetValue = new Feet(25.0);
        String checkVariable = "STR";
        try {
            feetValue.checkType(checkVariable);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.TYPE_MISMATCH , e.type);
        }
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
        inchValue1.checkType(inchValue2);
        Assert.assertTrue(inchValue1.equals(inchValue2));
    }

    @Test
    public void givenInchAndOtherFormToCompare_ShouldThrowCustomException() throws QuantityMeasurementException {
        Inch inchValue = new Inch(2.0);
        Feet feetValue = new Feet(2.0);
        try {
            Assert.assertFalse(inchValue.checkType(feetValue));
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.TYPE_MISMATCH , e.type);
        }
    }

    @Test
    public void givenInchWithValueNull_ShouldThrowCustomException() {
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
    public void givenYardValueNull_ShouldThrowAnException() {
        try {
            new Yard(null);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }

    @Test
    public void given1YardAnd3FeetToCompare_ShouldReturnTrue() throws QuantityMeasurementException {
        Feet feet = new Feet(3.0);
        Yard yard = new Yard(1.0);
       Assert.assertEquals(new QuantityMeasurement()
                        .doConversion(feet.value, ConversionType.FEET_TO_YARD), yard.value , 0.0001);
    }

    @Test
    public void given1YardAnd1FeetToCompare_ShouldReturnFalse() throws QuantityMeasurementException {
        Feet feet = new Feet(1.0);
        Yard yard = new Yard(1.0);
        Assert.assertNotEquals(new QuantityMeasurement()
                            .doConversion(yard.value, ConversionType.FEET_TO_YARD), feet.value , 0.0001);
    }

    @Test
    public void given1InchAnd1YardToCompare_ShouldReturnFalse() throws QuantityMeasurementException {
        Inch inch = new Inch(1.0);
        Yard yard = new Yard(1.0);
        Assert.assertNotEquals(new QuantityMeasurement()
                            .doConversion(inch.value , ConversionType.INCH_TO_YARD), yard.value, 0.0001);
    }

    @Test
    public void given1YardAnd36InchToCompare_ShouldReturnTrue() throws QuantityMeasurementException {
        Inch inch = new Inch(36.0);
        Yard yard = new Yard(1.0);
        Assert.assertEquals(new QuantityMeasurement()
                .doConversion(yard.value , ConversionType.YARD_TO_INCH), inch.value , 0.0001);
    }

    @Test
    public void given36InchANd1YardToCompare_ShouldReturnTrue() throws QuantityMeasurementException {
        Inch inch = new Inch(36.0);
        Yard yard = new Yard(1.0);
        Assert.assertEquals(new QuantityMeasurement()
                .doConversion(inch.value , ConversionType.INCH_TO_YARD), yard.value , 0.0001);
    }

    @Test
    public void given1YdAnd3FeetToCompare_ShouldReturnTrue() throws QuantityMeasurementException {
        Yard yard = new Yard(1.0);
        Feet feet = new Feet(3.0);
        Assert.assertEquals(new QuantityMeasurement()
                .doConversion(yard.value , ConversionType.YARD_TO_FEET), feet.value , 0.0001);
    }

    @Test
    public void given2InchesAnd5CentimeterTCompare_ShouldReturnTrue() {
        Inch inch = new Inch(2.0);
        Centimeter centimeter = new Centimeter(5.0);
        Assert.assertEquals(new QuantityMeasurement()
                .doConversion(inch.value , ConversionType.INCH_TO_CM), centimeter.value , 0.0001);
    }

    @Test
    public void given2InchesAnd10CentimeterToCompare_ShouldReturnFalse() {
        Inch inch = new Inch(2.0);
        Centimeter centimeter = new Centimeter(10.0);
        Assert.assertNotEquals(new QuantityMeasurement()
                .doConversion(inch.value , ConversionType.INCH_TO_CM), centimeter.value , 0.0001);
    }

    @Test
    public void givenNullInputInCentimeter_ShouldThrowAnException() {
        try {
            new Centimeter(null);
        } catch (QuantityMeasurementException e) {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.NULL_VALUE, e.type);
        }
    }
}