package com.twu.bootcamp;

public class Measurement {

    protected final double value;
    protected final IUnitType type;
    private static final double EPSILON = 0.0000001;

    public Measurement(double value, IUnitType type){
        this.value = value;
        this.type = type;
    }

    public int compare(Measurement another) {
        if(this.type.getClass() != another.type.getClass())
            throw new IllegalArgumentException("Cannot Add Different Types of Measurement");

        if(this.toBaseUnit() > another.toBaseUnit()) return 1;
        if(this.toBaseUnit() < another.toBaseUnit()) return -1;
        return 0;
    }

    protected double toBaseUnit(){
        return this.type.getValueInBaseUnit(this.value);
    }

    public Measurement add(Measurement another) {
        if(this.type != another.type)
            throw new IllegalArgumentException("Output type not specified!");
        return new Measurement((this.value + another.value), this.type);
    }

    public Measurement add(Measurement another, IUnitType outputType) {
        if(this.type.getClass() != another.type.getClass())
            throw new IllegalArgumentException("Cannot Add Different Types of Measurement");

        if(this.type == another.type)
            return this.add(another);

        double totalValueInBaseUnit = this.toBaseUnit() + another.toBaseUnit();

        return new Measurement(outputType.convertFromBaseUnit(totalValueInBaseUnit),outputType);
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;

        Measurement that = (Measurement) another;

        if (Math.abs(this.value - that.value) > EPSILON) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

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
