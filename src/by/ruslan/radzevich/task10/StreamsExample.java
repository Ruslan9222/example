package by.ruslan.radzevich.task10;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String[] args) {


        List<String> role = List.of("insurance_speсialist_ic",
                "insurance_speсialist_cc",
                "insurance_claim_speсialist_ic",
                "insurance_claim_speсialist_cc",
                "insurance_manager");
         role.stream()
                .map(String::toUpperCase)
                 .forEach(System.out::println);



//        Дан список строк. Вывести все строки длиной больше 5 символов.

        List<String> strings = List.of("apple", "banana", "pear", "pineapple", "kiwi");
        List<String> list = strings.stream()
                .filter(el -> el.length() > 5)
                .toList();
        System.out.println(list);


        //    Дан список чисел. Возвести каждое число в квадрат и вывести результат.

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> list1 = numbers.stream()
                .filter(el -> el % 2 != 0)
                .map(el -> el * el)
                .toList();
        System.out.println(list1);
//        Найти первую строку, начинающуюся с буквы «A».

        List<String> strings1 = List.of("Apple", "banana", "Avocado", "cherry");
        String a = strings1.stream()
                .filter(el -> el.startsWith("A"))
                .findFirst()
                .orElseThrow();
        System.out.println(a);


        // Превратить List<List<String>> приходящий на вход в строку, где каждая подстрока разделена запятой и пробелом (S4, S5, S6...).

        List<List<String>> listOflists = List.of(List.of("S4", "S5", "S6"),
                List.of("S4", "S5", "S6"),
                List.of("S7", "S8", "S9"));

        String collect = listOflists.stream()
                .flatMap(el -> el.stream())
                .collect(Collectors.joining(" ,"));
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

        Map<Integer, List<String>> map = words.stream()
                .collect(Collectors.groupingBy(el -> el.length()));
        System.out.println(map);


//        Из списка пользователей создать Map\<id, имя>.

        record User(int id, String name) {
        }

        List<User> users = List.of(
                new User(1, "Alice"),
                new User(2, "Bob"),
                new User(3, "Charlie")
        );
        Map<Integer, String> map1 = users.stream()
                .collect(Collectors.toMap(el1 -> el1.id, el2 -> el2.name));
        System.out.println(map1);

//        Задача 7  — Пропустить и взять
//        Пропустить первые 3 строки и взять следующие 5.

        List<String> strings2 = List.of("a", "b", "c", "d", "e", "f", "g");
        List<String> stringList = strings2.stream()
                .skip(3)
                .limit(8)
                .toList();
        System.out.println(stringList);

//        Задача 8  — Группировка с подсчетом и фильтрацией
//        Есть список заказов `Order` с полями `customerId` (int) и `amount` (double).
//        Нужно сгруппировать суммы заказов по клиентам, но учитывать только заказы с суммой больше 100. Вернуть Map\<customerId, totalAmount>.

        record Order(int customerId, double amount) {
        }

        List<Order> orders = List.of(
                new Order(1, 120),
                new Order(2, 50),
                new Order(1, 80),
                new Order(3, 200),
                new Order(2, 150)
        );

        Map<Integer, Double> collect1 = orders.stream()
                .filter(el -> el.amount > 100)
                .collect(Collectors.groupingBy(el1 -> el1.customerId,
                        Collectors.summingDouble(el2 -> el2.amount)));
        System.out.println(collect1);


//        Задача 9 — Сложное плоское преобразование с фильтрацией
//
//        Есть список `Person` с полем `List<String> phoneNumbers`.
//        Нужно получить список уникальных телефонных номеров, которые начинаются с «+7».

        record Person(String name, List<String> phoneNumbers) {
        }

        List<Person> people = List.of(
                new Person("Alice", List.of("+7123456789", "+123456789")),
                new Person("Bob", List.of("+7987654321", "+7123456789")),
                new Person("Charlie", List.of("+123123123"))
        );
        Set<String> list3 = people.stream()
                .flatMap(el -> el.phoneNumbers.stream())
                .filter(el -> el.startsWith("+7"))
                .collect(Collectors.toSet());
        System.out.println(list3);


//        Задача 10  — Сортировка по нескольким полям и лимит
//
//        Есть список `Product` с `name` и `price`.
//        Отсортировать по убыванию цены, если цена совпадает — по алфавиту названия. Взять топ-3 самых дорогих.

        record Product(String name, double price) {
        }

        List<Product> products = List.of(
                new Product("Pen", 1.50),
                new Product("Notebook", 5.75),
                new Product("Book", 12.99),
                new Product("Pencil", 1.50),
                new Product("Eraser", 0.99)
        );

        List<Product> list4 = products.stream()
                .sorted(Comparator.comparingDouble(Product::price).reversed()
                        .thenComparing(Product::name))
                .limit(3)
                .toList();
        System.out.println(list4);


//        Задача 11  — Сложная агрегация с Optional и reduce
//
//        Дан список чисел. Нужно найти произведение всех чисел больше 2. Если таких нет — вернуть 1.

        List<Integer> numbers4 = List.of(1, 2, 3, 4, 5);
        Integer reduce1 = numbers4.stream()
                .filter(el -> el > 2)
                .reduce((el1, el2) -> el1 * el2)
                .orElse(1);

        System.out.println(reduce1);
//
//        Реализовать код метода с помощью StreamAPI. Метод должен вернуть сумму всех
//        элементов в списке. И потом найти все значения котрые больше среднего значения*/

    }

    List<Integer> list5 = List.of(1, 3, 6, 9, 11, 42, 27);

    private static List<Integer> list(List<Integer> list) {
        Double average = list.stream()
                .mapToInt(el -> el)
                .average()
                .orElseThrow();

        return list.stream()
                .filter(el -> el > average)
                .toList();


    }

    public static boolean isPalindrome(String s) {
        if (s == null) return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // 1. Выполнить сортировку списка абитуриентов в алфавитном порядке по убыванию
//students.sort(Comparator.comparing(Student::getLastName).reversed());
//
//    // 2. В случайном порядке проставить признак поступления
//    Random random = new Random();
//students.forEach(student -> student.setAdmission(random.nextBoolean()));
}
