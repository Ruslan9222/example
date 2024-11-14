package by.ruslan.radzevich.task4;

import by.ruslan.radzevich.task4.patternSingletone.SingletonExample;

public class Main {
    public static void main(String[] args) {

        SingletonExample singletonExample = SingletonExample.getInstance();
        singletonExample.getMessage();

    }
}
