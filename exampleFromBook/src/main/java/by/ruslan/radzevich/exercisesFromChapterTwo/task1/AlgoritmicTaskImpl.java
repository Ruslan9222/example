package by.ruslan.radzevich.exercisesFromChapterTwo.task1;

import by.ruslan.radzevich.utils.ScannerInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Override
    public void maxAndMinNumbersForLength() {
        char[] chars = scannerInterface.getChar();

        String tokens = new String(chars).trim();
        Matcher matcher = Pattern.compile("-?\\d+").matcher(tokens);
        List<String> tokenList = new ArrayList<>();
        while (matcher.find()) {
            tokenList.add(matcher.group());
        }

        List<String> ascendingSort = new ArrayList<>(tokenList);
        List<String> descendingSort = new ArrayList<>(tokenList);

        ascendingSort.sort(Comparator.comparingInt(el -> el.length()));
        descendingSort.sort(Comparator.comparingInt(String::length).reversed());

        Map<String, List<String>> result = new HashMap<>();
        result.put("ascendingSort ", ascendingSort);
        result.put("descendingSort ", descendingSort);
        System.out.println(result.get("ascendingSort ") + " " + result.get("descendingSort "));

    }
}
