package quantitymeasurement.service;

public class ConversionFactor {
    private double conversionFactor = 0;

    /**
     * TASK: To convert feet to inches according to conversion factor.
     * @param feet
     * @return
     */
    public double feetToInch(double feet) {
        conversionFactor = 12.0;
        return feet*conversionFactor;
    }
}