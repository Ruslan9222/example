package by.ruslan.radzevich.task7;

public class LeetCode1 {

//    Даны массив целых чисел и целое число , возвращают индексы двух чисел так, что их сумма равна целевому значению.numstarget
//
//Можно предположить, что каждый вход будет иметь ровно одно решение, и нельзя использовать один и тот же элемент дважды.
//
//Вы можете вернуть ответ в любом порядке.

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        int target = 8;

        int[] result = twoSum(nums, target);

        if (result != null) {
            System.out.println("Индексы: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Подходящей пары не найдено");
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }


        return null;
    }
}
