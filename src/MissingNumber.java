import java.util.ArrayList;
import java.util.List;

public class MissingNumber {
    public static int[] getMissingNumberWithIndex(int[] number) {
        int first = number[0];
       int [] result = new int [number.length];
       int resultIndex = 0;
        for (int count = 0; count < number.length; count++) {
            if (first == number[count]) {
                first++;
            } else  {
                result[resultIndex] = first;
                resultIndex++;
                result[resultIndex] = count;
                resultIndex++;
                first++;
            }


        } return result;
    }
}
