package Addition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AdditionTest {

    @Test

    public void iAddTheTwoConsequtiveHighestNumberAndReturnTheNumbersInAnArray() {
        Addition calculator = new Addition();
//        Given
        int[] number = {13,7,1,8,2};


        int[] expected = {7, 13};

    //        act
    assertArrayEquals(expected, calculator.getNumbers(number));

}

}
