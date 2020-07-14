package quantitymeasurement.utility;

public enum ConversionType {
    FEET_TO_YARD(3), INCH_TO_YARD(36);

    public double value;
    ConversionType(double value) {
        this.value = value;
    }
}