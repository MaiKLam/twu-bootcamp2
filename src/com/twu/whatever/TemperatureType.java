package com.twu.whatever;

public enum TemperatureType implements IUnitType{
    CELSIUS(),
    FAHRENHEIT();


    @Override
    public double getRatioToBaseUnit() {
        return 0;
    }
}
