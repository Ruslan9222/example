package by.ruslan.radzevich.task6;

public class Example {
    public static void main(String[] args) {
        fun(4);
    }

    public static void fun(int x) {
        if (x > 0) {
            fun(--x);
            System.out.print(x+" ");
            fun(--x);
        }
    }

}

