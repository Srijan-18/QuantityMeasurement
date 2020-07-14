package quantitymeasurement.utility;

public enum ConversionType {
    FEET_TO_YARD(3);

    public double value;
    ConversionType(double value) {
        this.value = value;
    }
}
