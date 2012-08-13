package com.twu.bootcamp;

public enum TemperatureType implements IUnitType{
    CELSIUS(0,1),
    FAHRENHEIT(32,5/9d);

    private double offset;
    private double ratio;

    TemperatureType(double offset, double ratio){
        this.offset = offset;
        this.ratio = ratio;
    }

    public double convertFromBaseUnit(double value){
        return value/ratio + offset;
    }

    public double getValueInBaseUnit(double value) {
        return (value - this.offset) * this.ratio;
    }
}
