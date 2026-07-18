package flip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlipTest {
    @Test
    public void flipTwoNumbersThatTheirResultIsOdd () {

        int [] numbers = {2,5,3,8,2,1};

        int [] expected = {5,2,8,3,1,2};

        int [] actual = Flip.flippingNumbers(numbers);

        assertArrayEquals(expected, actual);
    }
}
