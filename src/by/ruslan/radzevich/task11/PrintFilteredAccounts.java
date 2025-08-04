package by.ruslan.radzevich.task11;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class PrintFilteredAccounts {
    public static void main(String[] args) {
        System.out.println(factorial(20));
    }


    public static void printFilteredAccounts(List<Account> accounts) {
        List<Account> nonEmptyAccounts = filter(accounts, account -> account.balance() > 0);

        List<Account> accountsWithTooMuchMoney = filter(accounts, account -> account.balance() > 1000000
                && !account.locked());

        // Please, do not change the code below
        nonEmptyAccounts.forEach(a -> System.out.print(a.number() + " "));
        accountsWithTooMuchMoney.forEach(a -> System.out.print(a.number() + " "));
    }


    public static <T> List<T> filter(List<T> elems, Predicate<T> predicate) {
        return elems.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] values = scanner.nextLine().split("\\s+");
            Account acc = new Account(
                    values[0],
                    Long.parseLong(values[1]),
                    Boolean.parseBoolean(values[2])
            );
            accounts.add(acc);
        }

        printFilteredAccounts(accounts);
    }


    record Account(String number, long balance, boolean locked) {

    }

    public static int sum(int[] x) {
        int y = 0;
        for (int i = 0; i < x.length; i++) {
            y = y + x[i];
        }
        return y;
    }

    public static int sum(int[] x, int index) {
        if (index == x.length) {
            return 0;
        }
        return x[index] + sum(x, index + 1);
    }

    public static int maxNumber(int[] x) {
        int max = x[0];
        for (int i = 0; i < x.length; i++) {
            if (max < x[i]) {
                max = x[i];
            }
        }
        return max;
    }

    public static int maxRec(int[] x, int index) {
        if (index == x.length - 1) {
            return x[index];
        }
        int max = maxRec(x, index + 1);
        return Math.max(x[index], max);

    }

    public static int factorial(int x) {
        int y = 1;
        for (int i = 2; i <= x; i++) {
            y = y * i;
        }
        return y;
    }
}