package com.twu.whatever;

public enum LengthType implements IUnitType {
    FEET (300),
    INCH(25),
    CENTIMETER(10),
    MILLIMETER(1);

    private double ratioToBaseUnit;

    LengthType(double ratioToBaseUnit){
        this.ratioToBaseUnit = ratioToBaseUnit;
    }

    public double getRatioToBaseUnit(){
        return this.ratioToBaseUnit;
    }

}
