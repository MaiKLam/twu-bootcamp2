import com.twu.bootcamp.Measurement;
import com.twu.bootcamp.LengthType;
import com.twu.bootcamp.TemperatureType;
import com.twu.bootcamp.VolumeType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MeasurementTests {

    @Test(expected = Exception.class)
    public void shouldThrowErrorIfCompareDifferentTypesOfMeasurements(){
        Measurement length = new Measurement(1, LengthType.CENTIMETER);
        Measurement volume = new Measurement(2, VolumeType.GALLON);
        length.compare(volume);
    }

    @Test(expected = Exception.class)
    public void shouldThrowErrorIfAddDifferentTypesOfMeasurements(){
        Measurement length = new Measurement(1, LengthType.CENTIMETER);
        Measurement volume = new Measurement(2, VolumeType.GALLON);
        length.add(volume);
    }

    @Test
    public void shouldGet0IfLengthsEqual(){
        Measurement lengthInFeet = new Measurement(1, LengthType.FEET);
        Measurement lengthInInches = new Measurement(12, LengthType.INCH);

        int result = lengthInFeet.compare(lengthInInches);

        assertThat(result, is(0));
    }

    @Test
    public void shouldGet1IfLength1GreaterThanLength2(){
        Measurement lengthInCm = new Measurement(5, LengthType.CENTIMETER);
        Measurement lengthInInches = new Measurement(1, LengthType.INCH);

        int result = lengthInCm.compare(lengthInInches);

        assertThat(result, is(1));

    }

    @Test
    public void shouldGetMinus1IfLength1LessThanLength2(){
        Measurement lengthInCm = new Measurement(1, LengthType.CENTIMETER);
        Measurement lengthInMm = new Measurement(15, LengthType.MILLIMETER);

        int result = lengthInCm.compare(lengthInMm);

        assertThat(result, is(-1));
    }

    @Test
    public void shouldBeAbleToAddTwoLengths(){
        Measurement length1 = new Measurement(2, LengthType.INCH);
        Measurement length2 = new Measurement(2, LengthType.INCH);

        Measurement result = length1.add(length2);

        assertThat(result, is(new Measurement(4, LengthType.INCH)));
    }

    @Test
    public void shouldBeAbleToAddTwoLengthsOfDifferentTypes(){
        Measurement length1 = new Measurement(2, LengthType.INCH);
        Measurement length2 = new Measurement(2.5, LengthType.CENTIMETER);

        Measurement result = length1.add(length2, LengthType.INCH);

        assertThat(result, is(new Measurement(3, LengthType.INCH)));
    }

    @Test
    public void shouldGet0IfVolumesEqual(){
        Measurement volumeInLiter=new Measurement(3.78, VolumeType.LITER);
        Measurement volumeInGallon=new Measurement(1, VolumeType.GALLON);

        int result=volumeInGallon.compare(volumeInLiter);

        assertThat(result,is(0));
    }

    @Test
    public void shouldGetMinus1IfVolume1IsLesserThanVolume2(){
        Measurement volumeInLiter=new Measurement(1, VolumeType.LITER);
        Measurement volumeInGallon=new Measurement(1, VolumeType.GALLON);

        int result=volumeInLiter.compare(volumeInGallon);

        assertThat(result,is(-1));
    }

    @Test
    public void shouldGet1IfVolume1IsGreaterThanVolume2(){
        Measurement volumeInLiter=new Measurement(5.78, VolumeType.LITER);
        Measurement volumeInGallon=new Measurement(1, VolumeType.GALLON);

        int result=volumeInLiter.compare(volumeInGallon);

        assertThat(result,is(1));
    }

    @Test
    public void shouldAdd2Volumes(){
        Measurement volume1=new Measurement(5, VolumeType.LITER);
        Measurement volume2=new Measurement(1, VolumeType.LITER);

        Measurement volumeResult =volume1.add(volume2);

        assertThat(volumeResult,is(new Measurement(6,VolumeType.LITER)));
    }

    @Test
    public void shouldAdd2VolumesOfDifferentTypes(){
        Measurement volume1=new Measurement(1, VolumeType.GALLON);
        Measurement volume2=new Measurement(1, VolumeType.LITER);

        Measurement volumeResult =volume2.add(volume1, VolumeType.LITER);

        assertThat(volumeResult,is(new Measurement(4.78d,VolumeType.LITER)));
    }

    @Test
    public void shouldBeAbleToCompareTwoTemperatures(){
        Measurement tempInF = new Measurement(212, TemperatureType.FAHRENHEIT);
        Measurement tempInC = new Measurement(100,TemperatureType.CELSIUS);

        int result = tempInF.compare(tempInC);

        assertThat(result, is(0));
    }

    @Test
    public void shouldGetMinusOneIfTempInFLessThanTempInC(){
        Measurement tempInF = new Measurement(200, TemperatureType.FAHRENHEIT);
        Measurement tempInC = new Measurement(100,TemperatureType.CELSIUS);

        int result = tempInF.compare(tempInC);

        assertThat(result, is(-1));
    }

    @Test
    public void shouldAddTwoTemperatures(){
        Measurement temp1 = new Measurement(50, TemperatureType.CELSIUS);
        Measurement temp2 = new Measurement(100,TemperatureType.CELSIUS);

        Measurement result = temp1.add(temp2);

        assertThat(result, is(new Measurement(150,TemperatureType.CELSIUS)));
    }

    @Test
    public void shouldAddTwoTemperaturesOfDifferentTypesWithOutputAsCelsius(){
        Measurement temp1 = new Measurement(-40, TemperatureType.CELSIUS);
        Measurement temp2 = new Measurement(-40,TemperatureType.FAHRENHEIT);

        Measurement result = temp2.add(temp1,TemperatureType.CELSIUS);

        assertThat(result, is(new Measurement(-80,TemperatureType.CELSIUS)));
    }

    @Test
    public void shouldAddTwoTemperaturesOfDifferentTypesWithOutputAsFahrenheit(){
        Measurement temp1 = new Measurement(-40, TemperatureType.CELSIUS);
        Measurement temp2 = new Measurement(-40,TemperatureType.FAHRENHEIT);

        Measurement result = temp2.add(temp1,TemperatureType.FAHRENHEIT);

        assertThat(result, is(new Measurement(-80,TemperatureType.FAHRENHEIT)));
    }

}
