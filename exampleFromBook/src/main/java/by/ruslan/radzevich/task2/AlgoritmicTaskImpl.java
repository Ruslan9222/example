package by.ruslan.radzevich.task2;

import by.ruslan.radzevich.utils.ScannerInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgoritmicTaskImpl implements AlgoritmicTask {

    private final ScannerInterface scannerInterface;

    public AlgoritmicTaskImpl(ScannerInterface scannerInterface) {
        this.scannerInterface = scannerInterface;
    }

    @Override
    public List<Integer> evenNumbers() {
        List<Integer> numbers = scannerInterface.getIntegersList();

        return numbers.stream()
                .filter(el -> el % 2 == 0)
                .toList();
    }

    @Override
    public void splitEvenAndOdd() {
        List<Integer> numbers = scannerInterface.getIntegersList();

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

    @Override
    public void maxAndMinNumbers() {
        List<Integer> numbers = scannerInterface.getIntegersList();

//        int max = Collections.max(numbers);
//        int min = Collections.min(numbers);

        int max = 0;
        int min = 0;
        for (int num : numbers) {
            if (num > max)
                max = num;
            if (num < min)
                min = num;
        }
        System.out.println("Max number " + max);
        System.out.println("Min number " + min);
    }

    @Override
    public void checkForDivisibility3Or9() {
        List<Integer> numbers = scannerInterface.getIntegersList();

        List<Integer> numberForDivisibility = new ArrayList<>();
        List<Integer> numberForNotDivisibility = new ArrayList<>();
        for (int number : numbers) {
            if (number != 0 && number % 3 == 0 || number % 9 == 0) {
                numberForDivisibility.add(number);
            } else {
                numberForNotDivisibility.add(number);
            }
        }
        System.out.println(numberForDivisibility + " is divisible by both 3 or 9");
        System.out.println(numberForNotDivisibility + " No divisibility");
    }

    @Override
    public Map<String, List<Integer>> checkForDivisibility5And7(List<Integer> numbers) {
        List<Integer> numberForDivisibility = new ArrayList<>();
        List<Integer> numberForNotDivisibility = new ArrayList<>();

        for (int number : numbers) {
            if (number != 0 && number % 5 == 0 && number % 7 == 0) {
                numberForDivisibility.add(number);
            } else numberForNotDivisibility.add(number);
        }
        Map<String, List<Integer>> result = new HashMap<>();
        result.put("divisible", numberForDivisibility);
        result.put("NoDivisible", numberForNotDivisibility);
        return result;
    }

    @Override
    public List<Integer> primeNumbers(List<Integer> numbers) {
        List<Integer> primes = new ArrayList<>();
        for (int number : numbers) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
        return primes;
    }

    @Override
    public void ascendingAndDescendingSort() {
        int count = scannerInterface.getInteger();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(scannerInterface.getInteger());
        }

        List<Integer> ascendingSort = new ArrayList<>(numbers);
        List<Integer> descendingSort = new ArrayList<>(numbers);

        Collections.sort(ascendingSort);
        descendingSort.sort(Collections.reverseOrder());

        Map<String, List<Integer>> result = new HashMap<>();
        result.put("ascendingSort", ascendingSort);
        result.put("descendingSort", descendingSort);
        System.out.println("Ascending sort " + result.get("ascendingSort"));
        System.out.println("Descending sort " + result.get("descendingSort"));
    }

    @Override
    public Map<String, List<Integer>> ascendingAndDescendingSort2(List<Integer> numbers) {

        List<Integer> ascendingSort = new ArrayList<>(numbers);
        List<Integer> descendingSort = new ArrayList<>(numbers);

        Collections.sort(ascendingSort);
        descendingSort.sort(Collections.reverseOrder());

        Map<String, List<Integer>> result = new HashMap<>();
        result.put("ascendingSort", ascendingSort);
        result.put("descendingSort", descendingSort);
        System.out.println("Ascending sort " + result.get("ascendingSort"));
        System.out.println("Descending sort " + result.get("descendingSort"));

        return result;
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

}


