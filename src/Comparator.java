public class Comparator {

    public enum ConversionType {
        FEET_TO_INCHES(12),
        INCHES_TO_CM(2.5),
        CM_TO_MM(10),
        GALLON_TO_LITER(3.78);

        private final double ratio;
        ConversionType(double ratio){
            this.ratio = ratio;
        }
    }

    public int compare(double valueInLargerUnit, double valueInSmallerUnit, ConversionType conversionType) {
        double convertedLength = valueInLargerUnit * conversionType.ratio;

        if(convertedLength >valueInSmallerUnit) return 1;
        if(convertedLength <valueInSmallerUnit) return -1;
        return 0;
    }
}
