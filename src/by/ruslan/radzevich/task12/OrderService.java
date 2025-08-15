package by.ruslan.radzevich.task12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class OrderService {
    record Order(String userId, String product, int quantity) {
    }

    // TODO: Реализуй метод, который группирует заказы по userId и product, суммируя quantity
    public static Map<String, Map<String, Integer>> groupOrders(List<Order> orders) {
        // Твоя реализация здесь
        return orders.stream().collect(Collectors.groupingBy(Order::userId
                , Collectors.groupingBy(Order::product,
                        Collectors.summingInt(Order::quantity))));
    }

    public static void main(String[] args) {

        System.out.println(rich);
        List<Order> orders = List.of(
                new Order("покупатель1", "банан", 2),
                new Order("покупатель1", "яблоко", 3),
                new Order("покупатель2", "банан", 2),
                new Order("покупатель2", "яблоко", 5),
                new Order("покупатель1", "банан", 3)
        );

        List<Integer> numbers = Arrays.asList(1, 3, 7, 1, 2, 6, 3, 4, 5, 2);
        List<Integer> list = IntStream.range(1, numbers.size() - 1)
                .filter(el -> numbers.get(el) > numbers.get(el - 1) && numbers.get(el) < numbers.get(el + 1))
                .mapToObj(numbers::get)
                .toList();
        System.out.println(list);


        System.out.println(isPalindrome("B a b"));

        String s = "hello";
        String s2 = s.replace("l", "L");
//        System.out.println(s2);

//        System.out.println(groupOrders(orders));
        final Object a = new Object();
        final Object b = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (a) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b) {
                    System.out.println("T1 done");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (a) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b) {
                    System.out.println("T2 done");
                }
            }
        });

        t1.start();
        t2.start();
    }


    public static boolean isPalindrome(String s) {
        String init = s.replaceAll("[^a-zA-z0-9]", "").toLowerCase();
        String result = new StringBuilder(init).reverse().toString();

        return result.equals(init);
    }

    public static boolean isPalindromeCycle(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right++;
            }
            if (Character.toLowerCase(s.charAt(right)) != Character.toLowerCase(s.charAt(left))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    record Employee(String name, int age, double salary) {
    }

   static List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, 50000),
            new Employee("Bob", 25, 60000),
            new Employee("Charlie", 35, 55000),
            new Employee("Diana", 30, 70000)
    );
   static List<Employee> rich = employees.stream()
            .sorted(
                    Comparator.comparing(Employee::age)
                    .thenComparing(Employee::salary)
                    .reversed())
            .toList();
}

