package quantitymeasurement.exception;

public class QuantityMeasurementOperationsException extends RuntimeException {

    public enum ExceptionType {
        DIFFERENT_CATEGORIES, NEGATIVE_VALUE, TEMPERATURE_ADDITION
    }
    public ExceptionType type;

    /**
     *Constructor to initialise class variables.
     * @param type
     * @param message
     */
    public QuantityMeasurementOperationsException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}