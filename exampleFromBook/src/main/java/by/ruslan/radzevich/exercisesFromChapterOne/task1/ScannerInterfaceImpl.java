package by.ruslan.radzevich.exercisesFromChapterOne.task1;

import java.util.Scanner;

public class ScannerInterfaceImpl implements ScannerInterface {

    private final Scanner scanner;

    public ScannerInterfaceImpl(Scanner scanner){
        this.scanner = scanner;
    }

    @Override
    public Integer getInteger() {

        System.out.println("Enter the number");
        return scanner.nextInt();
    }

    @Override
    public String getString() {
        String name;
        System.out.println("Enter the name");
        name = scanner.nextLine();
        return name;
    }
}
