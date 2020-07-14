package quantitymeasurement.exception;

public class QuantityMeasurementException extends RuntimeException {
    public enum ExceptionType {
        TYPE_MISMATCH, NULL_VALUE, DIFFERENT_REFERENCE
    }
    public ExceptionType type;

    public QuantityMeasurementException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}