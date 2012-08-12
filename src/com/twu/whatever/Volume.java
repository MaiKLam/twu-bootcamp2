package com.twu.whatever;

public class Volume extends Measurement {

    public Volume(double value, VolumeType type) {
        super(value, type);
    }

    public Volume add(Volume anotherVolume) {
        if(this.type != anotherVolume.type)
            throw new IllegalArgumentException("Output type need to be specified");
        return new Volume(this.value + anotherVolume.value, (VolumeType)this.type);
    }

    public Volume add(Volume another, VolumeType outputType) {
        if(this.type == another.type)
            return this.add(another);

        double totalValueInBaseUnit = this.toBaseUnit() + another.toBaseUnit();

        return new Volume(totalValueInBaseUnit/outputType.getRatioToBaseUnit(),outputType);
    }
}
