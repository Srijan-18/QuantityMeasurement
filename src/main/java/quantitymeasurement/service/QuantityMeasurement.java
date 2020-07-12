package quantitymeasurement.service;

public class QuantityMeasurement {

    private final int FEET_TO_INCHES_CONVERSION_FACTOR = 12;
    public double convert(double feet) {
        return feet * FEET_TO_INCHES_CONVERSION_FACTOR;
    }
}