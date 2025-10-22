package by.ruslan.radzevich.task2;

import by.ruslan.radzevich.utils.ScannerInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlgoritmicTask {

    private final ScannerInterface scannerInterface;

    public AlgoritmicTask(ScannerInterface scannerInterface) {
        this.scannerInterface = scannerInterface;
    }

    public List<Integer> evenNumbers() {
        List<Integer> numbers = getIntegerList();

        return numbers.stream()
                .filter(el -> el % 2 == 0)
                .toList();
    }


    public void splitEvenAndOdd() {
        List<Integer> numbers = getIntegerList();

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

    public void maxAndMinNumbers() {
        List<Integer> numbers = getIntegerList();

        int max = Collections.max(numbers);
        int min = Collections.min(numbers);

//        int max = 0;
//        int min = 0;
//        for (int num : numbers) {
//            if (num > max) max = num;
//            if (num < min) min = num;
//        }
        System.out.println("Max number " + max);
        System.out.println("Min number " + min);
    }


    private List<Integer> getIntegerList() {
        int count = getNumber();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(scannerInterface.getInteger());
        }
        System.out.println(numbers);
        return numbers;
    }


    private int getNumber() {
        return scannerInterface.getInteger();
    }
}


