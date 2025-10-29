package by.ruslan.radzevich.task6;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collection {
    public static void main(String[] args) {






        //Отфильтровать города, которые начинаются на букву "М".
//
//Преобразовать названия в верхний регистр.
//
//Отсортировать их по длине в порядке убывания.
//
//Собрать в список.
        List<String> cities = List.of("Москва", "Минск", "Берлин", "Париж", "Мадрид");
        System.out.println(cities.stream()
                .filter(el -> el.startsWith("М"))
                .map(el -> el.toUpperCase())
                .sorted((el1, el2) -> Integer.compare(el1.length(), el2.length()))// по длине строки
                .sorted((el1,el2)->el2.compareTo(el1)) // это вывод записей в алфавитном порядке
                .sorted(Comparator.comparing(String::length).reversed())
                .toList());


        //    сделать список только с началом фруктор на А


        List<String> words = List.of("Apple", "Banana", "Avocado", "Cherry", "Apricot");
        System.out.println(words.stream()
                .filter(a1 -> a1.startsWith("A"))
                .toList());
//        System.out.println(result(List.of("Apple", "Banana", "Avocado", "Cherry", "Apricot")));

        List<Person> people = List.of(new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));

        System.out.println(people.stream()
//                .sorted((age1, age2) -> Integer.compare(age2.age, age1.age))
                .sorted((el1, el2) -> el1.name().compareTo(el2.name()))
                        .sorted(Comparator.comparing(el->el.name))
                .toList());


//        сделать мап ключ количество букв, значение - все слова
//        Сгруппировать слова из списка по их длине

        List<String> animals = List.of("cat", "dog", "lion", "tiger", "elephant");
        Map<Integer, List<String>> grooping = animals.stream()
                .collect(Collectors.groupingBy(el -> el.length()));

        System.out.println(grooping);


    }

    public static List<String> result(List<String> strings) {
        return strings.stream()
                .filter(a1 -> a1.startsWith("A"))
                .toList();
    }

    record Person(String name, int age) {
    }


}
