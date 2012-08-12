import com.twu.whatever.Temperature;
import com.twu.whatever.TemperatureType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TemperatureTests {

    @Test
    public void shouldBeAbleToCompareTwoTemperatures(){
         Temperature tempInF = new Temperature(212, TemperatureType.FAHRENHEIT);
         Temperature tempInC = new Temperature(100,TemperatureType.CELSIUS);

         int result = tempInF.compare(tempInC);

         assertThat(result, is(0));
     }

    @Test
    public void shouldGetMinusOneIfTempInFLessThanTempInC(){
         Temperature tempInF = new Temperature(200, TemperatureType.FAHRENHEIT);
         Temperature tempInC = new Temperature(100,TemperatureType.CELSIUS);

         int result = tempInF.compare(tempInC);

         assertThat(result, is(-1));
     }
    @Test
    public void shouldAddTwoTemperatures(){
         Temperature temp1 = new Temperature(50, TemperatureType.CELSIUS);
         Temperature temp2 = new Temperature(100,TemperatureType.CELSIUS);

         Temperature result = temp1.add(temp2);

         assertThat(result, is(new Temperature(150,TemperatureType.CELSIUS)));
     }
    @Test
    public void shouldAddTwoTemperaturesOfDifferentTypes(){
         Temperature temp1 = new Temperature(-40, TemperatureType.CELSIUS);
         Temperature temp2 = new Temperature(-40,TemperatureType.FAHRENHEIT);

         Temperature result = temp2.add(temp1,TemperatureType.FAHRENHEIT);

         assertThat(result, is(new Temperature(-80,TemperatureType.FAHRENHEIT)));
     }
}
