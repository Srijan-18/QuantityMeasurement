package quantitymeasurement.exception;

public class QuantityMeasurementException extends RuntimeException {

    public enum ExceptionType {
        DIFFERENT_CATEGORIES, NEGATIVE_VALUE, NULL_VALUE
    }
    public ExceptionType type;

    /**
     *
     * @param type
     * @param message
     */
    public QuantityMeasurementException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}