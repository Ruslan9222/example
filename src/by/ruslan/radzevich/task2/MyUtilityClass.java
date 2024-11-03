package by.ruslan.radzevich.task2;


public final class MyUtilityClass {

    private MyUtilityClass() {
    }

    public static long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static String returnStringToLowerCase (String testString) {
        return testString.toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(returnStringToLowerCase("TESTSTRING"));
    }
}
