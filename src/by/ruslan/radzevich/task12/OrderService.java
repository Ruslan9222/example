package by.ruslan.radzevich.task12;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        System.out.println(groupOrders(orders));
    }
}

