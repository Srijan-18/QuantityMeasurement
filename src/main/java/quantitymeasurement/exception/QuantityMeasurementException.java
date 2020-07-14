package quantitymeasurement.exception;

public class QuantityMeasurementException extends Exception {
    public enum ExceptionType {
        TYPE_MISMATCH, NULL_VALUE;
    }
    public ExceptionType type;

    public QuantityMeasurementException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
