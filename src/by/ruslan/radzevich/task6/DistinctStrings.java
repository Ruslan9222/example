package by.ruslan.radzevich.task6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DistinctStrings {
    /**
     * Дан массив строк: String[] array = {"Aston", "Deeeeeeev"};
     * <p>
     * Написать метод, который принимает массив строк на вход и выводит в консоль те же строки, но избавленные от повторяющихся букв.
     * <p>
     * Пример вывода: Aston Dev
     */
    public static void main(String[] args) {
        String[] array = {"Aston", "Deeeeeeev"};
        printStringsWithoutDuplicateLetters(array);
    }

    private static void printStringsWithoutDuplicateLetters(String[] array) {
        Arrays.stream(array)
                .map(el->Arrays.stream(el.split(""))
                        .distinct()
                        .collect(Collectors.joining()))
//                .map(DistinctStrings::getCollect)
                .forEach(s -> System.out.print(s + " "));


    }

    private static String getCollect(String s) {
        return Arrays.stream(s.split(""))
                .distinct()
                .collect(Collectors.joining());
    }
}
