package by.ruslan.radzevich.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerInterfaceImpl implements ScannerInterface {

    private final Scanner scanner;

    public ScannerInterfaceImpl(Scanner scanner) {
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

    @Override
    public List<Integer> getIntegersList() {
        System.out.println("Count elements");
        int count = scanner.nextInt();
        System.out.println("Add elements to a list");
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            input.add(scanner.nextInt());
        }
        System.out.println(input);
        return input;
    }


}
