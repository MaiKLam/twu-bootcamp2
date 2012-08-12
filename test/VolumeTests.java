import com.twu.whatever.Volume;
import com.twu.whatever.VolumeType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VolumeTests {

    @Test
    public void shouldGet0IfVolumesEqual(){
        Volume volumeInLiter=new Volume(3.78, VolumeType.LITER);
        Volume volumeInGallon=new Volume(1, VolumeType.GALLON);

        int result=volumeInGallon.compare(volumeInLiter);

        assertThat(result,is(0));
    }

    @Test
    public void shouldGetMinus1IfVolume1IsLesserThanVolume2(){
        Volume volumeInLiter=new Volume(1, VolumeType.LITER);
        Volume volumeInGallon=new Volume(1, VolumeType.GALLON);

        int result=volumeInLiter.compare(volumeInGallon);

        assertThat(result,is(-1));
    }

    @Test
    public void shouldGet1IfVolume1IsGreaterThanVolume2(){
        Volume volumeInLiter=new Volume(5.78, VolumeType.LITER);
        Volume volumeInGallon=new Volume(1, VolumeType.GALLON);

        int result=volumeInLiter.compare(volumeInGallon);

        assertThat(result,is(1));
    }

    @Test
    public void shouldAdd2Volumes(){
        Volume volume1=new Volume(5, VolumeType.LITER);
        Volume volume2=new Volume(1, VolumeType.LITER);

        Volume volumeResult =volume1.add(volume2);

        assertThat(volumeResult,is(new Volume(6,VolumeType.LITER)));
    }

    @Test
    public void shouldAdd2VolumesOfDifferentTypes(){
        Volume volume1=new Volume(1, VolumeType.GALLON);
        Volume volume2=new Volume(1, VolumeType.LITER);

        Volume volumeResult =volume2.add(volume1, VolumeType.LITER);

        assertThat(volumeResult,is(new Volume(4.78d,VolumeType.LITER)));
    }
}
