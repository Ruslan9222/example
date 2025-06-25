package by.ruslan.radzevich.task7;

import java.util.Arrays;
import java.util.TreeMap;

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

        System.out.println(Arrays.toString(invertMassive(new int[]{1, 2, 3, 51, 54})));
//        int[] nums = {1, 1, 1, 2, 2, 3, 4, 5, 6, 6};
//        int k = removeDuplicates(nums);
//        System.out.println("Количество уникальных элементов: " + k);
//        System.out.print("Уникальные элементы: ");
//        for (int i = 0; i < k; i++) {
//            System.out.print(nums[i] + " ");
//        }
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

//написать массив в обратном порядке

    public static int[] invertMassive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0){
           throw new RuntimeException();
        }
        for (int i = 0; i < nums.length/2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums;
    }


}
