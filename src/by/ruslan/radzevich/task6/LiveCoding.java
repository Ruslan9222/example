package by.ruslan.radzevich.task6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LiveCoding {
    public static void main(String[] args) {

//        самую часто встречающуюся букву во всех словах.
//📎 Подсказка:
//        Используй flatMap, split(""), Collectors.groupingBy + counting()
//        Потом найди максимум по значению
        String[] words = {"apple", "banana", "grape", "avocado"};

        Optional<Map.Entry<String, Long>> mostFrequent = Arrays.stream(words)
                .flatMap(word -> Arrays.stream(word.split("")))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        mostFrequent.ifPresent(entry ->
                System.out.println("Самая частая буква: " + entry.getKey() + " — " + entry.getValue() + " раз")
        );


    //        Верни список чисел (int), у которых строка начинается на "b", и отсортируй по убыванию.
    List<String> strings = List.of("a1", "b2", "c3", "a4", "b5");
    List<String> b = strings.stream()
            .filter(el -> el.startsWith("b"))
            .sorted((el1, el2) -> el2.compareTo(el1))
//                .forEach(el-> System.out.println("el = " + el));
            .toList();
        System.out.println("strings = "+b);


    record User(String name, String city, int age) {
    }

    List<User> users = List.of(
            new User("Alice", "London", 30),
            new User("Bob", "Paris", 25),
            new User("Charlie", "London", 35),
            new User("Diana", "Paris", 28),
            new User("Eve", "Berlin", 22)
    );

//        Map<String, List<User>>, где ключ — город, значение — список пользователей.
//        Map<String, List<String>> — в каждом городе список имён.
//                Map<String, Double> — средний возраст по каждому городу.
//                вот эти понравились
//        Map<String, List<User>> user1 = users.stream()
////                .filter(el2->!el2.city.equals("London"))
//                .sorted((el,el1)->el.name().compareTo(el1.name()))
//                .collect(Collectors.groupingBy(el->el.city()));
//        System.out.print(user1);
//        Map<String, List<String>> user2 = users.stream()
//                .collect(Collectors.groupingBy(el -> el.city(), Collectors
//                        .mapping(el2 -> el2.name(), Collectors.toList())));
//        System.out.println("user = " + user2);
//       Map<String, Double> user = users.stream()
//                .collect(Collectors.groupingBy(el->el.city(), Collectors
//                        .averagingDouble(el2-> el2.age())));
//        System.out.println(user);
}

record User(String name, String city, int age) {
}

List<User> users = List.of(
        new User("Alice", "London", 30),
        new User("Bob", "Paris", 25),
        new User("Charlie", "London", 35),
        new User("Diana", "Paris", 28),
        new User("Eve", "Berlin", 22)
);
}
