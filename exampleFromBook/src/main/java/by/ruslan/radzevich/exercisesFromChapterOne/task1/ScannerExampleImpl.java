package by.ruslan.radzevich.exercisesFromChapterOne.task1;

import by.ruslan.radzevich.utils.ScannerInterface;

import java.time.LocalDateTime;
import java.util.Random;


public class ScannerExampleImpl implements ScannerExample, Runnable {

    private final ScannerInterface scannerInterface;

    public ScannerExampleImpl(ScannerInterface scannerInterface) {
        this.scannerInterface = scannerInterface;
    }

    private String name;

    @Override
    public void name() {
        this.name = scannerInterface.getString();
        LocalDateTime start = LocalDateTime.now();
        System.out.println("Input received at: " + start);

        Thread thread = new Thread(this);
        thread.start();

        LocalDateTime end = LocalDateTime.now();
        System.out.println("Main thread continues at: " + end);
    }

    @Override
    public void reverseName() {
        String name = scannerInterface.getString();

        String reverseName = new StringBuilder(name)
                .reverse().toString();
        System.out.println("Name = " + reverseName);
    }

    @Override
    public void randomNumbers() {
        Integer number = scannerInterface.getInteger();
        Random random = new Random();
        System.out.println(number);
        for (int i = 0; i < number; i++) {
            int randomInt = random.nextInt(100);
            System.out.println(" " + randomInt);
        }

    }

    @Override
    public void passwordMath() {
        String passTwo = scannerInterface.getString();
        String passOne = scannerInterface.getString();
        System.out.println(passOne.equals(passTwo));

    }

    @Override
    public void sum() {
        Integer number = scannerInterface.getInteger();
        int sumNumber = number + number;
        int productOfNumbers = number * number;
        System.out.println("sum " + sumNumber);
        System.out.println("productOfNumbers " + productOfNumbers);

    }

    @Override
    public void run() {
        System.out.println("Thread started at: " + LocalDateTime.now());

        if (name == null || name.isBlank()) {
            System.out.println("No name provided.");
            return;
        }

        try {
            Thread.sleep(1000); // имитация обработки
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String upper = name.toUpperCase();
        long vowelCount = name.chars()
                .filter(c -> "aeiouAEIOUаеёиоуыэюяАЕЁИОУЫЭЮЯ".indexOf(c) >= 0)
                .count();

        System.out.println("Processed name: " + upper);
        System.out.println("Length: " + name.length());
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Thread finished at: " + LocalDateTime.now());

    }
}