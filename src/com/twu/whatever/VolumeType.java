package com.twu.whatever;

public enum VolumeType implements IUnitType {
    LITER(1), GALLON(3.78);

    private double ratioToBaseUnit;

    VolumeType(double ratioToBaseUnit){
        this.ratioToBaseUnit = ratioToBaseUnit;
    }

    public double getRatioToBaseUnit(){
        return this.ratioToBaseUnit;
    }

}
