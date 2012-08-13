import com.twu.bootcamp.VolumeType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VolumeTypeTests {

    @Test
    public void shouldBeAbleToConvertGallonToLiters(){
        double volumeInGallon = 1;
        double volumeInLiters = VolumeType.GALLON.getValueInBaseUnit(volumeInGallon);
        assertThat(volumeInLiters, is(3.78d));
    }

    @Test
    public void shouldUseLitersAsBaseUnit(){
        double volumeInLiters = 1;
        double volumeInBaseUnit = VolumeType.LITER.getValueInBaseUnit(volumeInLiters);
        assertThat(volumeInBaseUnit, is(1d));
    }
}
