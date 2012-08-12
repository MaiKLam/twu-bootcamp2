package com.twu.whatever;

public class Length extends Measurement {

    public Length(double value, LengthType type){
      super(value, type);
    }

    public Length add(Length another) {
        if(this.type != another.type)
            throw new IllegalArgumentException("Output type not specified!");
        return new Length((this.value + another.value), (LengthType)this.type);
    }

    public Length add(Length another, LengthType outputType) {
        if(this.type == another.type)
            return this.add(another);

        double totalValueInBaseUnit = this.toBaseUnit() + another.toBaseUnit();

        return new Length(totalValueInBaseUnit/outputType.getRatioToBaseUnit(),outputType);
    }

}
