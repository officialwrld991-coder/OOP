package flip;

public class Flip {
    public static int[] flippingNumbers(int[] numbers) {
        int count = 0;
        int index = 1;
        for (index = 1; index < numbers.length; index+=2) {
            int sum = numbers[index] + numbers[count];
            if (sum % 2 != 0 ) {
                int temp = numbers[index];
                numbers[index] = numbers[count];
                numbers[count] = temp;
            } count+=2;
        }
        return numbers;
    }
}
