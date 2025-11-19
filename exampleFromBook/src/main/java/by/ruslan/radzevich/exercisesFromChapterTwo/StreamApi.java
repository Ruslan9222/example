package by.ruslan.radzevich.exercisesFromChapterTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class StreamApi {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>(List.of("asflak asff", " afaf, asfla;, asffa"));
        System.out.println(count(stringList));


        String[] words = {"asflak asff", " afaf, asfla;, asffa"};
        System.out.println(Arrays.stream(words)
                .flatMap(s -> Stream.of(s.split("\\s+")))
                .count());

    }

    public static long count(List<String> stringList) {
        return stringList.stream()
                .flatMap(s -> Stream.of(s.split("\\s+")))
                .count();
    }
}
