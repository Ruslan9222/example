package by.ruslan.radzevich.exercisesFromChapterTwo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiExample {

    public static void main(String[] args) {


        record Employee(String name, String department, double salary) {
        }

        //   Выведите имена сотрудников из отдела "IT", у которых зарплата выше 1300.
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 1200),
                new Employee("Bob", "HR", 900),
                new Employee("Charlie", "IT", 1500),
                new Employee("Diana", "Finance", 1100)
        );
//        employees.stream()
//                .filter(el -> el.salary > 1300)
////            .map(Employee::name)
//                .forEach(System.out::println);

        class Product {
            String name;
            String category;
            double price;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Product(String name, String category, double price) {
                this.name = name;
                this.category = category;
                this.price = price;
            }
        }


        //Найдите название самого раннего события.
        record Event(String title, LocalDate date) {
        }

        List<Event> events = List.of(
                new Event("Conference", LocalDate.of(2023, 5, 20)),
                new Event("Workshop", LocalDate.of(2023, 3, 15)),
                new Event("Webinar", LocalDate.of(2023, 4, 10))
        );
        events.stream()
                .sorted(Comparator.comparing(el -> el.date))
//                .sorted((el1, el2)->el1.date.compareTo(el2.date))
                .limit(1)
                .forEach(System.out::println);


        //Подсчитайте общее количество слов во всех строках.
        List<String> sentences = List.of(
                "Java is powerful",
                "Stream API is elegant",
                "Practice makes perfect"
        );
        sentences.stream()
                .flatMap(s -> List.of(s.split("\\s+")).stream())
                .count();

        //Преобразуйте матрицу в один плоский список, отсортированный по убыванию.
        List<List<Integer>> matrix = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );
        matrix.stream()
                .flatMap(el -> el.stream())
                .sorted((el1, el2) -> el2.compareTo(el1))
                .toList();


//    Найти всех сотрудников из отдела "IT", чей возраст больше 30 лет,
//    отсортировать их по убыванию зарплаты и вернуть список их имён.
        record Employee1(String name, int age, double salary, String department) {
        }

        List<Employee1> employees1 = List.of(
                new Employee1("Alice", 35, 120000, "IT"),
                new Employee1("Bob", 28, 95000, "HR"),
                new Employee1("Charlie", 40, 135000, "IT"),
                new Employee1("Diana", 32, 110000, "Finance")
        );

        employees1.stream()
                .filter(el -> el.age > 30)
                .sorted(Comparator.comparing(Employee1::salary).reversed())
                .toList();


//        Дан список объектов Product с полями name, price, category.
//        Сгруппировать продукты по категории и для каждой категории найти среднюю цену.

        class Product1 {
            private String name;
            private double price;
            private String category;

            public Product1(String name, double price, String category) {
                this.name = name;
                this.price = price;
                this.category = category;
            }

//            public String getName() {
//                return name;
//            }
//
//            public double getPrice() {
//                return price;
//            }
//
//            public String getCategory() {
//                return category;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public void setPrice(double price) {
//                this.price = price;
//            }
//
//            public void setCategory(String category) {
//                this.category = category;
//            }

        }

        List<Product1> products = List.of(
                new Product1("Laptop", 1500, "Electronics"),
                new Product1("Banana", 1.2, "Food"),
                new Product1("TV", 800, "Electronics"),
                new Product1("Apple", 1.5, "Food")
        );

        Map<String, Double> collect = products.stream()
                .collect(Collectors.groupingBy(el -> el.category,
                        Collectors.averagingDouble(el -> el.price)));
        System.out.println(collect);

//Разбить все предложения на слова, привести к нижнему регистру,
// удалить знаки препинания и посчитать количество уникальных слов.
        List<String> sentences1 = List.of(
                "Java is a powerful language.",
                "Streams simplify data processing!",
                "Functional programming is elegant."
        );
        long count = sentences1.stream()
                .flatMap(el -> Stream.of(el.split("\\s+")))
                .map(el -> el.toLowerCase(Locale.forLanguageTag(el)))
                .distinct()
                .count();
        System.out.println(count);

//        Дан список чисел. Нужно найти произведение всех чисел больше 2. Если таких нет — вернуть 1.

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        Integer reduce = numbers.stream()
                .filter(el -> el > 2)
                .reduce(1, (el1, el2) -> el1 * el2);

        //Дан список объектов Order с полями orderId, clientId, amount.
        //Для каждого клиента собрать список его заказов (ID заказов) и общую сумму всех заказов.}

        class Order1 {
            private String orderId;
            private String clientId;
            private double amount;


            public Order1(String orderId, String clientId, double amount) {
                this.clientId = clientId;
                this.orderId = orderId;
                this.amount = amount;

            }

            public String getOrderId() {
                return orderId;
            }

            public String getClientId() {
                return clientId;
            }

            public double getAmount() {
                return amount;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }
        }

        class ClientSummary {
            private String clientId;
            private List<String> orderIds;
            private double totalAmount;

            public ClientSummary(String clientId, List<String> orderIds, double totalAmount) {
                this.clientId = clientId;
                this.orderIds = orderIds;
                this.totalAmount = totalAmount;
            }

            @Override
            public String toString() {
                return "ClientSummary{" +
                        "clientId='" + clientId + '\'' +
                        ", orderIds=" + orderIds +
                        ", totalAmount=" + totalAmount +
                        '}';
            }
        }

        List<Order1> orderList = List.of(
                new Order1("O1", "C1", 250.0),
                new Order1("O2", "C2", 400.0),
                new Order1("O3", "C1", 150.0),
                new Order1("O4", "C3", 300.0)
        );

        Map<String, ClientSummary> result = orderList.stream()
                .collect(Collectors.groupingBy(
                        Order1::getClientId,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                orders -> new ClientSummary(
                                        orders.get(0).getClientId(),
                                        orders.stream().map(Order1::getOrderId).toList(),
                                        orders.stream().mapToDouble(Order1::getAmount).sum()
                                )
                        )
                ));

        result.forEach((client, summary) -> System.out.println(summary));

//Дан список объектов LogEntry с полями timestamp, message.
//Выбрать последние 10 записей по времени (timestamp), отсортированные от самых новых к самым старым.
        class LogEntry {
            private LocalDateTime timestamp;
            private String message;

            public LogEntry(LocalDateTime timestamp, String message) {
                this.timestamp = timestamp;
                this.message = message;
            }
        }

        List<LogEntry> logs = List.of(
                new LogEntry(LocalDateTime.now().minusMinutes(5), "User logged in"),
                new LogEntry(LocalDateTime.now().minusMinutes(2), "User updated profile"),
                new LogEntry(LocalDateTime.now().minusMinutes(10), "User logged out")
        );
logs.stream()
        .sorted((el1,el2)->el2.timestamp.compareTo(el1.timestamp))
        .limit(10)
        .toList();
    }
}




