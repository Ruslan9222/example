package by.ruslan.radzevich.exercisesFromChapterOne.task1;

import java.util.Scanner;

public class Runner {

    private final ScannerExample scannerExample;

    public Runner(ScannerExample scannerExample) {
        this.scannerExample = scannerExample;
    }

    public static void main(String[] args) {
        Scanner sharedScanner = new Scanner(System.in);
        ScannerInterface scannerInterface = new ScannerInterfaceImpl(sharedScanner);
        ScannerExample scanner = new ScannerExampleImpl(scannerInterface);
        Runner runner = new Runner(scanner);
        runner.run();


    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
            Choose an option:
            1 - Reverse name
            2 - Print name with thread
            3 - Generate random numbers
            4 - Compare passwords
            5 - Sum and product
            0 - Exit
            """);

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> scannerExample.reverseName();
                case 2 -> scannerExample.name();
                case 3 -> scannerExample.randomNumbers();
                case 4 -> scannerExample.passwordMath();
                case 5 -> scannerExample.sum();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
