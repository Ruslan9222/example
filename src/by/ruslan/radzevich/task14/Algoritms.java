package by.ruslan.radzevich.task14;

import java.util.List;

public class Algoritms {

    private static int maxLengthOfSequenceOfOnesExceptZero(int[] arr) {
        // Максимальная длина допустимого окна
        int maxLen = 0;

        // Левый указатель окна
        int left = 0;

        // Количество нулей в текущем окне
        int zeroCount = 0;

        // Проходим по массиву правым указателем
        for (int right = 0; right < arr.length; right++) {
            // Если текущий элемент — 0, увеличиваем счётчик нулей
            if (arr[right] == 0) {
                zeroCount++;
            }

            // Если нулей больше одного — окно недопустимо, сдвигаем левую границу
            while (zeroCount > 1) {
                if (arr[left] == 0) {
                    zeroCount--; // Удаляем один 0 из окна
                }
                left++; // Сдвигаем левую границу
            }

            // Обновляем максимальную длину допустимого окна
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
    public class NestedListPrinter {
        public static void main(String[] args) {
            List<Object> input = List.of(
                    1,
                    List.of(2, 3),
                    List.of(List.of(4, 5), 6)
            );

            printNestedList(input);
        }

        // Рекурсивный метод для обхода вложенных списков
        public static void printNestedList(List<Object> list) {
            for (Object element : list) {
                if (element instanceof List<?>) {
                    // Рекурсивно обрабатываем вложенный список
                    printNestedList((List<Object>) element);
                } else {
                    // Печатаем элемент, если это не список
                    System.out.println(element);
                }
            }
        }
    }
}
