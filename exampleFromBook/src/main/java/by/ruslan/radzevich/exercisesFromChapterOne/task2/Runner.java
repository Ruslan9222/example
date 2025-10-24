package by.ruslan.radzevich.exercisesFromChapterOne.task2;

import by.ruslan.radzevich.utils.ScannerInterface;
import by.ruslan.radzevich.utils.ScannerInterfaceImpl;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Runner {

    private final AlgoritmicTask algoritmicTask;
    private final ScannerInterface scannerInterface;

    public Runner(AlgoritmicTask algoritmicTask, ScannerInterface scannerInterface) {
        this.algoritmicTask = algoritmicTask;
        this.scannerInterface = scannerInterface;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScannerInterface scannerInterface = new ScannerInterfaceImpl(scanner);
        AlgoritmicTask algoritmicTask = new AlgoritmicTaskImpl(scannerInterface);
        Runner runner = new Runner(algoritmicTask, scannerInterface);
        runner.run();


    }

    public void run() {

        while (true) {
            System.out.println("""
                    Choose an option:
                    1 - Even Numbers
                    2 - Split Even And Odd
                    3 - Max And Min Numbers
                    4 - Check For Divisibility 3 or 9
                    5 - Check For Divisibility 5 and 7
                    6 - Prime Numbers
                    7 - Ascending And Descending Sort
                    8 - Ascending And Descending Sort 2
                    0 - Exit
                    """);
            int choice = scannerInterface.getInteger();

            switch (choice) {
                case 1 -> {
                    List<Integer> integers = algoritmicTask.evenNumbers();
                    System.out.println("evenNumbers = " + integers);
                }
                case 2 -> algoritmicTask.splitEvenAndOdd();
                case 3 -> algoritmicTask.maxAndMinNumbers();
                case 4 -> algoritmicTask.checkForDivisibility3Or9();
                case 5 -> {
                    List<Integer> input = scannerInterface.getIntegersList();
                    Map<String, List<Integer>> result = algoritmicTask.checkForDivisibility5And7(input);
                    System.out.println("Is divisible by both 5 and 7 " + result.get("divisible"));
                    System.out.println("No divisibility " + result.get("NoDivisible"));
                }
                case 6 -> {
                    List<Integer> input = scannerInterface.getIntegersList();
                    List<Integer> integers = algoritmicTask.primeNumbers(input);
                    System.out.println("Prime numbers " + integers);
                }
                case 7 -> algoritmicTask.ascendingAndDescendingSort();

                case 8 -> {
                    List<Integer> input = scannerInterface.getIntegersList();
                    Map<String, List<Integer>> result = algoritmicTask.ascendingAndDescendingSort2(input);
                    System.out.println("Ascending sort " + result.get("ascendingSort"));
                    System.out.println("Descending sort " + result.get("descendingSort"));

                }
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

}