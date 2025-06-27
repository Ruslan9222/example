package by.ruslan.radzevich.task8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
}