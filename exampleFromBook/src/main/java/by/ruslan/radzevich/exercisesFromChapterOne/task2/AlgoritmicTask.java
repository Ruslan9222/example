package by.ruslan.radzevich.exercisesFromChapterOne.task2;

import java.util.List;
import java.util.Map;

public interface AlgoritmicTask {

    List<Integer> evenNumbers();

    void splitEvenAndOdd();

    void maxAndMinNumbers();

    void checkForDivisibility3Or9();

    Map<String, List<Integer>> checkForDivisibility5And7(List<Integer> numbers);

    List<Integer> primeNumbers(List<Integer> numbers);

    void ascendingAndDescendingSort();
    Map<String, List<Integer>> ascendingAndDescendingSort2(List<Integer> numbers);
}
