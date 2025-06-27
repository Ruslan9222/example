package by.ruslan.radzevich.task8;

import java.util.Arrays;

/**
 * Дан массив из N элементов, содержащий уникальные последовательные числа от 1 до N,
 * <p>
 * где одно число пропущено и заменено на null.
 * <p>
 * Написать метод, который определит пропущенное число для массива любого размера.
 * <p>
 * Пример:
 * <p>
 * Вход: {3, 9, 2, 4, 1, null, 6, 5, 8, 10} (длина = 10)
 * <p>
 * Выход: 7
 */
public class FindMissingNumber {
    public static void main(String[] args) {
        System.out.println(findMissingNumber(new Integer[]{3, 9, 2, 4, 1, null, 6, 5, 8, 10}));
    }

    public static Integer findMissingNumber(Integer[] array) {
        int n = array.length;
        // Ожидаемая сумма от 1 до N
        int expectedSum = n * (n + 1) / 2;

        // Фактическая сумма без null
        int actualSum = 0;
        for (Integer num : array) {
            if (num != null) {
                actualSum += num;
            }
        }

        return expectedSum - actualSum;
    }
}