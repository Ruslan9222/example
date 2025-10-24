package by.ruslan.radzevich.exercisesFromChapterTwo.task1;


import by.ruslan.radzevich.utils.ScannerInterface;
import by.ruslan.radzevich.utils.ScannerInterfaceImpl;

import java.util.Scanner;


public class Runner {
    private final ScannerInterface scannerInterface;
    private final AlgoritmicTask algoritmicTask;

    public Runner(ScannerInterface scannerInterface, AlgoritmicTask algoritmicTask) {
        this.scannerInterface = scannerInterface;
        this.algoritmicTask = algoritmicTask;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ScannerInterface scannerInterface = new ScannerInterfaceImpl(scanner);
        AlgoritmicTask algoritmicTask = new AlgoritmicTaskImpl(scannerInterface);
        Runner runner = new Runner(scannerInterface, algoritmicTask);
        runner.run();


    }

    void run() {
        while (true) {
            System.out.println("""
                    Choose an option:
                    1 - Even Numbers
                    
                    0 - Exit
                    """);
            int chose = scannerInterface.getInteger();
            switch (chose) {
                case 1 ->{
                    char[] input = scannerInterface.getChar();
                    algoritmicTask.findAndPrintShortestAndLongest(input);
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