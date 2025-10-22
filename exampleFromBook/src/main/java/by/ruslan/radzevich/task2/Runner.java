package by.ruslan.radzevich.task2;

import by.ruslan.radzevich.utils.ScannerInterface;
import by.ruslan.radzevich.utils.ScannerInterfaceImpl;

import java.util.List;
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
        AlgoritmicTask algoritmicTask = new AlgoritmicTask(scannerInterface);
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
                    4 - Compare passwords
                    5 - Sum and product
                    0 - Exit
                    """);
            int choice = scannerInterface.getInteger();

            switch (choice) {
                case 1 -> {
                    List<Integer> integers = algoritmicTask.evenNumbers();
                    System.out.println("evenNumbers = " + integers);
                }
                case 2 -> algoritmicTask.splitEvenAndOdd();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                case 3 -> algoritmicTask.maxAndMinNumbers();
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}