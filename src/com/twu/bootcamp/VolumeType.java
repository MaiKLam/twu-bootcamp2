package com.twu.bootcamp;

public enum VolumeType implements IUnitType {
    LITER(1),
    GALLON(3.78);

    private double ratioToBaseUnit;

    VolumeType(double ratioToBaseUnit){
        this.ratioToBaseUnit = ratioToBaseUnit;
    }

    public double convertFromBaseUnit(double value){
        return value/ratioToBaseUnit;
    }

    public double getValueInBaseUnit(double value) {
        return value * this.ratioToBaseUnit;
    }
}
