package by.ruslan.radzevich.task4.patternBuilder;

public class BuildCreditCardRunner {
    public static void main(String[] args) {

        Director directorStandard = new Director(new BuildStandardCard());
        CreditCard creditCardStandard = directorStandard.creditCard();
        System.out.println(creditCardStandard);


        Director directorGold = new Director(new BuildGoldCard());
        CreditCard creditCardGold = directorGold.creditCard();
        System.out.println(creditCardGold);


    }
}
