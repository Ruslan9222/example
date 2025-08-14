package by.ruslan.radzevich.task12;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class OrderService {
    record Order(String userId, String product, int quantity) {
    }

    // TODO: Реализуй метод, который группирует заказы по userId и product, суммируя quantity
    public static Map<String, Map<String, Integer>> groupOrders(List<Order> orders) {
        // Твоя реализация здесь
        return orders.stream()
                .collect(Collectors.groupingBy(Order::userId,
                        Collectors.groupingBy(Order::product,
                                Collectors.summingInt(Order::quantity))));
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("покупатель1", "банан", 2),
                new Order("покупатель1", "яблоко", 3),
                new Order("покупатель2", "банан", 2),
                new Order("покупатель2", "яблоко", 5),
                new Order("покупатель1", "банан", 3)
        );

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
            synchronized (b) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (a) {
                    System.out.println("T2 done");
                }
            }
        });

        t1.start();
        t2.start();
    }

}

