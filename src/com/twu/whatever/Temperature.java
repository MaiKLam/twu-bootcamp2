package com.twu.whatever;

public class Temperature {

    private double value;
    private TemperatureType type;
    private static final double ZERO_IN_FAHRENHEIT = 32;
    private static final double CONV_RATIO_F_TO_C = 5/9d;

    public Temperature(double value, TemperatureType type) {
        this.value = value;
        this.type = type;
    }

    public int compare(Temperature another) {
        if(this.getClass() != another.getClass())
            throw new IllegalArgumentException("Cannot compare different types of measurement");

        if(this.toBaseUnit() > another.toBaseUnit()) return 1;
        if(this.toBaseUnit() < another.toBaseUnit()) return -1;
        return 0;
    }

    protected double toBaseUnit(){
        if(this.type == TemperatureType.CELSIUS)
            return this.value;
        return (this.value - ZERO_IN_FAHRENHEIT)* CONV_RATIO_F_TO_C;

    }

    private double toFahrenheit() {
        if(this.type == TemperatureType.FAHRENHEIT)
            return this.value;
        return (this.value)/ CONV_RATIO_F_TO_C + ZERO_IN_FAHRENHEIT;
    }

    public Temperature add(Temperature another) {
        if(this.type != another.type)
            throw new IllegalArgumentException("Output type need specified!");
        return new Temperature(this.value + another.value, this.type);
    }

    public Temperature add(Temperature another, TemperatureType outputType) {
        if(this.type == another.type)
            return this.add(another);
        if(outputType == TemperatureType.CELSIUS)
            return new Temperature(this.toBaseUnit() + another.toBaseUnit(), outputType);
        if(outputType == TemperatureType.FAHRENHEIT)
            return new Temperature(this.toFahrenheit() + another.toFahrenheit(),outputType);
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Temperature that = (Temperature) o;

        if (Double.compare(that.value, value) != 0) return false;
        if (type != that.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = value != +0.0d ? Double.doubleToLongBits(value) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

}
