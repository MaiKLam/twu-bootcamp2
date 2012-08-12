import com.twu.whatever.LengthType;
import com.twu.whatever.Length;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LengthTests {

    @Test
    public void shouldGet0IfLengthsEqual(){
        Length lengthInFeet = new Length(1, LengthType.FEET);
        Length lengthInInches = new Length(12, LengthType.INCH);

        int result = lengthInFeet.compare(lengthInInches);

        assertThat(result, is(0));
    }

    @Test
    public void shouldGet1IfLength1GreaterThanLength2(){
        Length lengthInCm = new Length(5, LengthType.CENTIMETER);
        Length lengthInInches = new Length(1, LengthType.INCH);

        int result = lengthInCm.compare(lengthInInches);

        assertThat(result, is(1));

    }

    @Test
    public void shouldGetMinus1IfLength1LessThanLength2(){
        Length lengthInCm = new Length(1, LengthType.CENTIMETER);
        Length lengthInMm = new Length(15, LengthType.MILLIMETER);

        int result = lengthInCm.compare(lengthInMm);

        assertThat(result, is(-1));
    }

    @Test
    public void shouldBeAbleToAddTwoLengths(){
        Length length1 = new Length(2, LengthType.INCH);
        Length length2 = new Length(2, LengthType.INCH);

        Length result = length1.add(length2);

        assertThat(result, is(new Length(4, LengthType.INCH)));
    }

    @Test
    public void shouldBeAbleToAddTwoLengthsOfDifferentTypes(){
        Length length1 = new Length(2, LengthType.INCH);
        Length length2 = new Length(2.5, LengthType.CENTIMETER);

        Length result = length1.add(length2, LengthType.INCH);

        assertThat(result, is(new Length(3, LengthType.INCH)));
    }


}
