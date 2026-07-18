package rotateArray;

public class RotateArray {
    public static int[][] inverseArray(int[][] array) {
       int [][] movedArray = new int[array[0].length][array.length];

       for (int index = 0; index < array[0].length; index++) {
           for (int count = 0; count < array.length; count++) {
               movedArray[count][array[0].length -1-index] =  array[index][count];

           }

       }
       return movedArray;
    }
}
