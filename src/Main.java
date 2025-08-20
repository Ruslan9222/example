import by.ruslan.radzevich.task1.Animal;
import by.ruslan.radzevich.task1.SwitchCase;

import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {

//        SwitchCase.switchCase();
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i);
//        }
//
//        Animal animal = new Animal();
//        System.err.println(animal);
//
//
//        String objects = "aaaaa";
//        objects.hashCode();
//
//
//
        int b = (int) Stream.of(1,3,6,7)
                .filter(a-> a >5)
                .peek(System.out::println)
                .toList().stream()
                .peek(System.out::println)
                .count();
        System.out.println(b);
    }
}