package by.ruslan.radzevich.cycle;

import java.util.Scanner;

public class SwitchCase {
    public static void switchCase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number");
        int number = scanner.nextInt();
       switch (number){
           case 1 -> System.out.println("1");
           case 2 -> System.out.println("2");
           case 3 -> System.out.println("3");
           case 4 -> System.out.println("4");
           case 5 -> System.out.println("5");
           default -> System.out.println("default");
       }

    }


}