package oopCode;

import java.util.Scanner;

public class Zone {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your State: ");
        String state = input.nextLine();

        GeoPoliticalZone presentZone = GeoPoliticalZone.checkZone(state);

        if(presentZone == null){
            System.out.println("State not found!!");
        }
        else{
            System.out.print(state + " belongs to " + presentZone);
        }

    }


}
