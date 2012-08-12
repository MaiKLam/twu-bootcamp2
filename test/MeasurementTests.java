import com.twu.whatever.Length;
import com.twu.whatever.LengthType;
import com.twu.whatever.Volume;
import com.twu.whatever.VolumeType;
import org.junit.Test;

public class MeasurementTests {

    @Test(expected = Exception.class)
    public void shouldThrowErrorIfCompareDifferentTypesOfMeasurements(){
        Length length = new Length(1, LengthType.CENTIMETER);
        Volume volume = new Volume(2, VolumeType.GALLON);
        length.compare(volume);
    }
}
