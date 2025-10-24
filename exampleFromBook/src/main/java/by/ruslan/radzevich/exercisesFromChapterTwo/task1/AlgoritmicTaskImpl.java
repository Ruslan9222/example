package by.ruslan.radzevich.exercisesFromChapterTwo.task1;

import by.ruslan.radzevich.utils.ScannerInterface;

public class AlgoritmicTaskImpl implements AlgoritmicTask {

    private final ScannerInterface scannerInterface;

    public AlgoritmicTaskImpl(ScannerInterface scannerInterface) {
        this.scannerInterface = scannerInterface;

    }


    @Override
    public void findAndPrintShortestAndLongest(char[] chars) {
        String[] tokens = new String(chars).trim().split("\\s+");

        String shortest = null;
        String longest = null;

        for (String token : tokens) {
            if (!token.matches("-?\\d+")) continue;

            if (shortest == null || token.length() < shortest.length()) {
                shortest = token;
            }
            if (longest == null || token.length() > longest.length()) {
                longest = token;
            }
        }

        if (shortest != null) {
            System.out.println("Самое короткое: " + shortest + ", длина: " + shortest.length());
            System.out.println("Самое длинное: " + longest + ", длина: " + longest.length());
        } else {
            System.out.println("Не найдено ни одного числа для анализа.");
        }
    }
}
