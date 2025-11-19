package by.ruslan.radzevich.task4;

import by.ruslan.radzevich.task4.patternSingletone.SingletonExample;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        SingletonExample singletonExample = SingletonExample.getInstance();
        singletonExample.getMessage();


        int b = (int) Stream.of(1,3,6,7)
                .filter(a-> a > 5)
                .peek(a-> System.out.println(a))
                .toList().stream()
                .peek(a-> System.out.println(a))
                .count();
        System.out.println(b);
    }
}
