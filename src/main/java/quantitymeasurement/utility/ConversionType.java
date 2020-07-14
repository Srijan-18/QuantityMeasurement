package quantitymeasurement.utility;

public enum ConversionType {
    FEET_TO_YARD(1.0/3.0),
    INCH_TO_YARD(1.0/36.0),
    YARD_TO_INCH(36.0),
    YARD_TO_FEET(3.0);

    public double value;
    ConversionType(double value) {
        this.value = value;
    }
}