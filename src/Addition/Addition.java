package Addition;

public class Addition {

    public int[] getNumbers(int [] number) {
        int[] newNumber = new int[2];
        int sum = 0;
        int index = 0;
        for (int count = 1; count < number.length; count++) {
            if (number[count] + number[index] > sum) {
                sum = number[count] + number[index];
                newNumber[0] = number[count];
                newNumber[1] = number[index];
            }
            index = index + 1;
        }
        return newNumber;
    }

}