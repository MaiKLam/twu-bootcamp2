import com.twu.bootcamp.LengthType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LengthTypeTests {

    @Test
    public void shouldBeAbleToConvertFeetToMillimeters(){
        double lengthInFeet = 1;
        double lengthInMm = LengthType.FEET.getValueInBaseUnit(lengthInFeet);
        assertThat(lengthInMm, is(300d));
    }

    @Test
    public void shouldBeAbleToConvertInchesToMillimeters(){
        double lengthInInches = 1;
        double lengthInMm = LengthType.INCH.getValueInBaseUnit(lengthInInches);
        assertThat(lengthInMm, is(25d));
    }

    @Test
    public void shouldBeAbleToConvertCentimetersToMillimeters(){
        double lengthInCm = 1;
        double lengthInMm = LengthType.CENTIMETER.getValueInBaseUnit(lengthInCm);
        assertThat(lengthInMm, is(10d));
    }

    @Test
    public void shouldHaveMillimeterAsBaseUnit(){
        double lengthInMm = 1;
        double lengthInBaseUnit = LengthType.MILLIMETER.getValueInBaseUnit(lengthInMm);
        assertThat(lengthInBaseUnit, is(1d));
    }
}
