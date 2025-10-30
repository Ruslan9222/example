package by.ruslan.radzevich.exercisesFromChapterTwo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {


//    Задача 1 — Фильтрация списка
//    Дан список строк. Вывести все строки длиной больше 5 символов.
        List<String> strings = List.of("apple", "banana", "pear", "pineapple", "kiwi");
        List<String> result = strings.stream()
                .filter(el -> el.length() > 5)
                .toList();
        System.out.println(result);

//-----------
//    Задача 2 — Преобразование элементов
//    Дан список чисел. Возвести каждое число в квадрат и вывести результат.
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        numbers.stream()
                .map(el -> el * el)
                .forEach(System.out::println);


//-----------
//    Задача 3 — Поиск первого подходящего элемента
//    Найти первую строку, начинающуюся с буквы «A».
        List<String> strings3 = List.of("Apple", "banana", "Avocado", "cherry");
        String result1 = strings3.stream()
                .filter(el -> el.startsWith("A"))
                .findFirst()
                .orElse("1");
        System.out.println(result1);


//-----------
//    Задача 4  — Уникальные элементы
//    Вывести уникальные числа из списка с повторами.

        List<Integer> numbers3 = List.of(1, 2, 2, 3, 4, 4, 5);
        numbers3.stream()
                .distinct()
                .forEach(el -> System.out.print(el + " "));


//-----------
//    Задача 5  — Группировка по длине
//    Сгруппировать слова по длине.
        List<String> words = List.of("apple", "banana", "pear", "fig", "plum");
        List<String> result4 = words.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
        System.out.println(result4);

//-----------
//    Задача 6  — Преобразование в Map
//    Из списка пользователей создать Map\<id, имя>.

        record User(int id, String name) {
        }

        List<User> users = List.of(
                new User(1, "Alice"),
                new User(2, "Bob"),
                new User(3, "Charlie")
        );
        users.stream()
                .collect(Collectors.toMap(User::id, User::name))
                .forEach((el, el1) -> System.out.println(el + " " + el1));


//----------
//    Задача 7  — Пропустить и взять
//    Пропустить первые 3 строки и взять следующие 5.

        List<String> strings1 = List.of("a", "b", "c", "d", "e", "f", "g");
        String result7 = strings1.stream()
                .skip(3)
                .limit(8)
                .collect(Collectors.joining(" ,"));
        System.out.println(result7);


//-----------
//    Задача 8  — Группировка с подсчетом и фильтрацией
//    Есть список заказов `Order` с полями `customerId` (int) и `amount` (double).
//    Нужно сгруппировать суммы заказов по клиентам, но учитывать только заказы с суммой больше 100. Вернуть Map\<customerId, totalAmount>.

        record Order(int customerId, double amount) {
        }

        List<Order> orders = List.of(
                new Order(1, 120),
                new Order(2, 50),
                new Order(1, 80),
                new Order(3, 200),
                new Order(2, 150)
        );
        Map<Integer, Double> result6 = orders.stream()
                .filter(el -> el.amount() > 100)
                .collect(Collectors.groupingBy(el -> el.customerId(),
                        Collectors.summingDouble(el2 -> el2.amount())));
        System.out.println(result6);


//            -----------
//    Задача 9 — Сложное плоское преобразование с фильтрацией
//    Есть список `Person` с полем `List<String> phoneNumbers`.
//    Нужно получить список уникальных телефонных номеров, которые начинаются с «+7».

        record Person(String name, List<String> phoneNumbers) {
        }

        List<Person> people = List.of(
                new Person("Alice", List.of("+7123456789", "+123456789")),
                new Person("Bob", List.of("+7987654321", "+7123456789")),
                new Person("Charlie", List.of("+123123123"))
        );

        List<String> list = people.stream()
                .flatMap(el -> el.phoneNumbers.stream())
                .filter(el -> el.startsWith("+7"))
                .distinct()
                .toList();
        System.out.println(list);


//-----------
//    Задача 10  — Сортировка по нескольким полям и лимит
//    Есть список `Product` с `name` и `price`.
//    Отсортировать по убыванию цены, если цена совпадает — по алфавиту названия. Взять топ-3 самых дорогих.

        record Product(String name, double price) {
        }

        List<Product> products = List.of(
                new Product("Pen", 1.50),
                new Product("Notebook", 5.75),
                new Product("Book", 12.99),
                new Product("Pencil", 1.50),
                new Product("Eraser", 0.99)
        );
        products.stream()
                .sorted(Comparator.comparingDouble(Product::price)
                        .reversed()
                        .thenComparing(el -> el.name()))
                .limit(3)
                .forEach(System.out::println);

//-----------
//    Задача 11  — Сложная агрегация с Optional и reduce
//    Дан список чисел. Нужно найти произведение всех чисел больше 2. Если таких нет — вернуть 1.

        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
        Integer i = numbers1.stream()
                .filter(el -> el > 2)
                .reduce((integer, integer2) -> integer * integer2)
                .orElse(1);
        System.out.println(i);


    }


//    Задача 14
    /*Написать программу для подсчета количества конкретных слов в строке используя хэш мар*/

    public class Words {
        public static void main(String[] args) {
            String str = "This task task will be solved by by by Java developer developer ";
            System.out.println(findWordsWithGrouping(str));
        }

        private static Map<String, Long> findWordsWithGrouping(String str) {
            return Stream.of(str)
                    .flatMap(s -> Arrays.stream(s.split("\\s+")))
                    .collect(Collectors.groupingBy(word -> word,
                            Collectors.counting()));
        }

    }


}
