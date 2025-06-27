package by.ruslan.radzevich.task7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class leetCode2 {
//    Если массив целочисленных чисел отсортирован в неубывающем порядке, удалите дубликаты на месте таким образом,
//    чтобы каждый уникальный элемент отображался только один раз. Относительный порядок элементов должен быть
//    сохранен прежним. Затем возвращает количество уникальных элементов в .numsnums
//
//Рассмотрите количество уникальных элементов для того, чтобы быть принятым, вам нужно сделать следующие вещи:numsk
//
//Измените массив таким образом, чтобы первые элементы из него содержали уникальные элементы в том порядке,
// в котором они присутствовали изначально. Остальные элементы не важны, как и размер .numsknumsnumsnumsnums

    //Возвращать.k
    public static void main(String[] args) {

//        System.out.println(Arrays.toString(invertMassive(new int[]{1, 2, 3, 51, 54})));
//        int[] nums = {1, 1, 1, 2, 2, 3, 4, 5, 6, 6};
//        int k = removeDuplicates(nums);
//        System.out.println("Количество уникальных элементов: " + k);
//        System.out.print("Уникальные элементы: ");
//        for (int i = 0; i < k; i++) {
//            System.out.print(nums[i] + " ");
//        }
//        System.out.println(Arrays.toString(invertMassive3(new int[]{2, 5, 6, 2, 4, 5})));
        System.out.println(Arrays.toString(invertMassive2(new int[]{2, 5, 6, 2, 4, 5})));
    }

    public static int removeDuplicates(int[] nums) {
        int dublicate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[dublicate]) {
                dublicate++;
                nums[dublicate] = nums[i];
            }
        }

        return dublicate + 1;
    }

    public static boolean canFormArithmeticProgression(int[] arr) {
        Arrays.sort(arr); // Сортируем массив

        int difference = arr[1] - arr[0]; // Вычисляем разность между первыми двумя элементами

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != difference) {
                return false; // Если разность отличается, возвращаем false
            }
        }

        return true; // Если данное условие выполнено для каждого элемента, возвращаем true
    }

//написать массив в обратном порядке

    public static int[] invertMassive(int[] nums) {
        if (nums.length == 0) {
            throw new RuntimeException();
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums;
    }
    public static int[] invertMassive2(int[] nums) {
        if (nums.length == 0) {
            throw new RuntimeException();
        }
        int[] newArray = new int[nums.length];
        for (int i = nums.length - 1;i >= 0;  i--) {
            newArray[nums.length-1-i]= nums[i];
        }
        return newArray;
    }


    public static int[] invertMassive3(int[] nums) {
        if (nums.length == 0) {
            throw new RuntimeException("Массив пуст");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }

        return nums;
    }

    public static int[] invertAndSortWithStreams(int[] nums) {
        if (nums.length == 0) {
            throw new RuntimeException("Пустой массив");
        }

        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int[] invertWithStreams(int[] nums) {
        if (nums.length == 0) {
            throw new RuntimeException("Пустой массив");
        }

        return IntStream.range(0, nums.length)
                .map(i -> nums[nums.length - 1 - i])
                .toArray();
    }


}
