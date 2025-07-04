package by.ruslan.radzevich.task10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String[] args) {

//        Дан список строк. Вывести все строки длиной больше 5 символов.

        List<String> strings = List.of("apple", "banana", "pear", "pineapple", "kiwi");
        List<String> list = strings.stream()
                .filter(el -> el.length() > 5)
                .toList();
        System.out.println(list);


        //    Дан список чисел. Возвести каждое число в квадрат и вывести результат.

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> list1 = numbers.stream()
                .map(el -> el * el)
                .toList();
        System.out.println(list1);

//        Найти первую строку, начинающуюся с буквы «A».

        List<String> strings1 = List.of("Apple", "banana", "Avocado", "cherry");
        Optional<String> a = strings1.stream()
                .filter(el -> el.startsWith("A"))
                .findFirst();
        System.out.println(a);

        // Превратить List<List<String>> приходящий на вход в строку, где каждая подстрока разделена запятой и пробелом (S4, S5, S6...).

        List<List<String>> listOflists = List.of(List.of("S4", "S5", "S6"),
                List.of("S4", "S5", "S6"),
                List.of("S7", "S8", "S9"));
        String collect = listOflists.stream()
                .flatMap(el -> el.stream())
                .collect(Collectors.joining(", "));
        System.out.println(collect);

//        Вывести уникальные числа из списка с повторами.

        List<Integer> numbers3 = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> list2 = numbers3.stream()
                .distinct()
                .toList();
        System.out.println(list2);

//        Вывести сумму чисел из списка.
        List<Integer> numbers1 = List.of(1, 2, 2, 3, 4, 4, 5);
        Integer reduce = numbers1.stream()
                .reduce(0, (el, el1) -> el + el1);

        System.out.println(reduce);

        List<Integer> numbers2 = List.of(1, 2, 2, 3, 4, 4, 5);
        int sum = numbers2.stream()
                .mapToInt(el -> el)
                .sum();

        System.out.println(sum);

//        Сгруппировать слова по длине c с преобразованием в map.

        List<String> words = List.of("apple", "banana", "pear", "fig", "plum");
        Map<Integer, List<String>> collect1 = words.stream()
                .collect(Collectors.groupingBy(el -> el.length()));
        System.out.println(collect1);

//        Из списка пользователей создать Map\<id, имя>.

        record User(int id, String name) {}

        List<User> users = List.of(
                new User(1, "Alice"),
                new User(2, "Bob"),
                new User(3, "Charlie")
        );
        Map<Integer, String> collect2 = users.stream()
                .collect(Collectors.toMap(el -> el.id, el2 -> el2.name()));
        System.out.println(collect2);

//        Задача 7  — Пропустить и взять
//        Пропустить первые 3 строки и взять следующие 5.

        List<String> strings2 = List.of("a", "b", "c", "d", "e", "f", "g");
        List<String> collect3 = strings2.stream()
                .skip(3)
                .limit(8)
                .toList();
        System.out.println(collect3);

//        Задача 8  — Группировка с подсчетом и фильтрацией
//        Есть список заказов `Order` с полями `customerId` (int) и `amount` (double).
//        Нужно сгруппировать суммы заказов по клиентам, но учитывать только заказы с суммой больше 100. Вернуть Map\<customerId, totalAmount>.

        record Order(int customerId, double amount) {}

        List<Order> orders = List.of(
                new Order(1, 120),
                new Order(2, 50),
                new Order(1, 80),
                new Order(3, 200),
                new Order(2, 150)
        );
        Map<Integer, Double> collect4 = orders.stream()
                .filter(el -> el.amount > 100)
                .collect(Collectors.toMap(el -> el.customerId, el2 -> el2.amount));
        System.out.println(collect4);

    }


}
