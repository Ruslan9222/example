package by.ruslan.radzevich.task8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Написать метод, который принимает массив целых чисел nums и число target.
 * <p>
 * Метод должен вернуть массив из двух индексов элементов nums, сумма которых равна target.
 * <p>
 * Порядок индексов не важен, гарантируется, что решение существует и единственное.
 * <p>
 * Примеры:
 * <p>
 * Input: nums = {2,7,11,15}, target = 9 Output: [0,1]
 * <p>
 * Input: nums = {3,2,4}, target = 6 Output: [1,2]
 * <p>
 * Input: nums = {3,3}, target = 6 Output: [0,1]
 */
public class FindSumElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int element = target - nums[i];

            if (map.containsKey(element)) {
                return new int[]{map.get(element), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
    public static boolean isPalindrome(String text) {
        if (text == null) return false;

        String normalized = text.replaceAll("[^\\p{L}\\p{N}]", "")
                .toLowerCase();

        int left = 0, right = normalized.length() - 1;
        while (left < right) {
            if (normalized.charAt(left++) != normalized.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    List<Integer> numbers = List.of(10, 20, 30, 40);

    List<String> result = numbers.stream()
            .filter(n -> n > 20)
            .map(n -> n + "USD")
            .collect(Collectors.toList());


    List<String> strings = List.of("1", "2", "3");

    List<Integer> integers = strings.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());


}