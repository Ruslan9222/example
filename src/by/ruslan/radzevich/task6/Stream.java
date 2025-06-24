package by.ruslan.radzevich.task6;

import java.util.List;
import java.util.OptionalDouble;

public class Stream {
    public static void main(String[] args) {

        List.of("dog", "cat", "hamster")
                .stream()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.length() <= 3;
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .sorted()
                .forEach(s -> {
                    System.out.println("forEach: " + s);
                });



        /**
         * Реализовать код метода с помощью StreamAPI. Метод должен вернуть сумму всех элементов в списке.
         */
        List<Integer> list = List.of(1, 3, 6, 9, 11, 42, 27);
//        int result = sum(list);

        System.out.println(sum(List.of(1, 3, 6, 9, 11, 42, 27)));
    }

//    private static int sum(List<Integer> list) {
//        // Описать код решения
//        return list.stream()
//                .mapToInt(value -> value)
//                .sum();
//    }
//    private static int sum1(List<Integer> list) {
//        // Описать код решения
//        return list.stream()
//                .reduce(0, Integer::sum);
//    }
//    private static long sum(List<Integer> list) {
//        // Описать код решения
//        return list.stream()
//                .filter(integer -> integer%3==0)
//                .count();
//    }
    private static List<Integer> sum(List<Integer> list) {
        // Описать код решения
       Double average = list.stream()
                .mapToInt(value -> value)
                .average()
                .orElseThrow();

        return list.stream()
                .filter(integer -> integer>average)
                .toList();
    }
}
