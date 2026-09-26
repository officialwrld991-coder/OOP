import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingNumberTest {

    @Test

    public void testMissingNumberWithIndex () {
        int[] number = {1,2,4,5,6};

       int [] result = {3,2};

       int []  actual = MissingNumber.getMissingNumberWithIndex(number);

        assertArrayEquals(result, actual);
    }
}
