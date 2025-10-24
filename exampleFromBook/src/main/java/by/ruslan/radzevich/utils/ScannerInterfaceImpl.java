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
        while (true) {
            System.out.print("Введите целое число: ");
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } else {
                System.out.println("Ошибка: введите корректное целое число.");
                scanner.nextLine();
            }
        }
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

    @Override
    public char[] getChar() {
        System.out.println("Enter the char");
        String s = scanner.nextLine();
        return s.toCharArray();
    }
}
