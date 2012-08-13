import com.twu.bootcamp.TemperatureType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TemperatureTypeTests {

    @Test
    public void shouldConvert212FahrenheitTo100Celsius(){
        double tempInF = 212;
        double tempInC = TemperatureType.FAHRENHEIT.getValueInBaseUnit(tempInF);
        assertThat(tempInC, is(100d));
    }

    @Test
    public void shouldConvert32FahrenheitTo0Celsius(){
        double tempInF = 32;
        double tempInC = TemperatureType.FAHRENHEIT.getValueInBaseUnit(tempInF);
        assertThat(tempInC, is(0d));
    }
}
