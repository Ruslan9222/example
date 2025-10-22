package by.ruslan.radzevich.task2;

import by.ruslan.radzevich.utils.ScannerInterface;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmicTask {

    private final ScannerInterface scannerInterface;

    public AlgoritmicTask(ScannerInterface scannerInterface) {
        this.scannerInterface = scannerInterface;
    }

    public List<Integer> evenNumbers() {
        int number = getNumber();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            numbers.add(scannerInterface.getInteger());
        }
        System.out.println(numbers);

        return numbers.stream()
                .filter(el -> el % 2 == 0)
                .toList();
    }


    public void splitEvenAndOdd() {
        int count = getNumber();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(scannerInterface.getInteger());
        }
        System.out.println(numbers);

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int num : numbers)
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }

        System.out.println("Even numbers " + even);
        System.out.println("Odd numbers " + odd);

    }



    private int getNumber() {
        return scannerInterface.getInteger();
    }
}


