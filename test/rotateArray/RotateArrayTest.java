package rotateArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateArrayTest {

    @Test

    public void iRotateArrayAndMoveIndexByOne() {
        RotateArray rotateArray = new RotateArray();

        int [][] array = {{0,1}, {4,8}};

        int [][] expected = {{4,0},{8,1}};

        int [][] actual = RotateArray.inverseArray(array);

        assertArrayEquals(expected, actual);
    }
}
