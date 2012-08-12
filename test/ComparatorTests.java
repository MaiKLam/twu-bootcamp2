import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ComparatorTests {

    @Test
    public void shouldReturnZeroWhenEqualLength(){
        double lengthInFeet = 1;
        double lengthInInches = 12;
        Comparator comparator = new Comparator();

        int result = comparator.compare(lengthInFeet, lengthInInches, Comparator.ConversionType.FEET_TO_INCHES);

        assertThat(result, is(0));

    }

    @Test
    public void shouldReturnMinusOne_WhenLengthInFeetLessThan_LengthInInches(){
        double lengthInFeet = 1;
        double lengthInInches = 15;
        Comparator comparator = new Comparator();

        int result = comparator.compare(lengthInFeet, lengthInInches, Comparator.ConversionType.FEET_TO_INCHES);

        assertThat(result, is(-1));

    }

    @Test
    public void shouldReturnOne_WhenLengthInFeetMoreThan_LengthInInches(){
        double lengthInFeet = 2;
        double lengthInInches = 15;
        Comparator comparator = new Comparator();

        int result = comparator.compare(lengthInFeet, lengthInInches, Comparator.ConversionType.FEET_TO_INCHES);

        assertThat(result, is(1));

    }

    @Test
    public void shouldReturnZero_WhenLengthInInchesEqualTo_LengthInCm(){
        double lengthInCm = 5;
        double lengthInInches = 2;
        Comparator comparator = new Comparator();

        int result = comparator.compare(lengthInInches, lengthInCm, Comparator.ConversionType.INCHES_TO_CM);

        assertThat(result, is(0));

    }

    @Test
    public void shouldReturnMinusOne_WhenLengthInInchesLessThan_LengthInCm(){
        double lengthInCm = 10;
        double lengthInInches = 2;
        Comparator comparator = new Comparator();

        int result = comparator.compare(lengthInInches, lengthInCm, Comparator.ConversionType.INCHES_TO_CM);

        assertThat(result, is(-1));
    }

    @Test
    public void shouldReturnOne_WhenLengthInInchesMoreThan_LengthInCm(){
        double lengthInCm = 4;
        double lengthInInches = 2;
        Comparator comparator = new Comparator();

        int result = comparator.compare(lengthInInches, lengthInCm, Comparator.ConversionType.INCHES_TO_CM);

        assertThat(result, is(1));
    }

    @Test
    public void shouldReturnZero_WhenLengthInCmEqualTo_LengthInMm(){
        double lengthInCm = 1;
        double lengthInMm = 10;
        Comparator comparator = new Comparator();

        int result = comparator.compare(lengthInCm, lengthInMm, Comparator.ConversionType.CM_TO_MM);

        assertThat(result, is(0));

    }

    @Test
    public void shouldReturnMinusOne_WhenLengthInCmLessThan_LengthInMm(){
        double lengthInCm = 1;
        double lengthInMm = 16;
        Comparator comparator = new Comparator();

        int result = comparator.compare(lengthInCm, lengthInMm, Comparator.ConversionType.CM_TO_MM);

        assertThat(result, is(-1));

    }

    @Test
    public void shouldReturnOne_WhenLengthInCmMoreThan_LengthInMm(){
        double lengthInCm = 2;
        double lengthInMm = 16;
        Comparator comparator = new Comparator();

        int result = comparator.compare(lengthInCm, lengthInMm, Comparator.ConversionType.CM_TO_MM);

        assertThat(result, is(1));

    }

    @Test
    public void shouldReturnZeroIfVolumesInGallon_EqualTo_VolumesInLiters(){
        double volumeInLiter = 3.78;
        double volumeInGallon = 1;
        Comparator comparator = new Comparator();

        int result = comparator.compare(volumeInGallon, volumeInLiter, Comparator.ConversionType.GALLON_TO_LITER);

        assertThat(result, is(0));
    }

    @Test
    public void shouldReturnOneIfVolumesInGallon_MoreThan_VolumesInLiters(){
        double volumeInLiter = 3.78;
        double volumeInGallon = 2;
        Comparator comparator = new Comparator();

        int result = comparator.compare(volumeInGallon, volumeInLiter, Comparator.ConversionType.GALLON_TO_LITER);

        assertThat(result, is(1));
    }

    @Test
    public void shouldReturnMinusOneIfVolumesInGallon_LessThan_VolumesInLiters(){
        double volumeInLiter = 6.78;
        double volumeInGallon = 1;
        Comparator comparator = new Comparator();

        int result = comparator.compare(volumeInGallon, volumeInLiter, Comparator.ConversionType.GALLON_TO_LITER);

        assertThat(result, is(-1));
    }



}
