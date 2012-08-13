package com.twu.bootcamp;

public enum LengthType implements IUnitType {
    FEET (300),
    INCH(25),
    CENTIMETER(10),
    MILLIMETER(1);

    private double ratioToBaseUnit;

    LengthType(double ratioToBaseUnit){
        this.ratioToBaseUnit = ratioToBaseUnit;
    }

    public double convertFromBaseUnit(double value){
        return value/ratioToBaseUnit;
    }

    public double getValueInBaseUnit(double value) {
        return ratioToBaseUnit * value;
    }
}
