package by.ruslan.radzevich.task4.patternBuilder;

import lombok.Getter;


@Getter
public abstract class CreditCardBuilder {

    private CreditCard creditCard;

    public void createCreditCard() {
        creditCard = new CreditCard();
    }

    public abstract void buildOwnerName();

    public abstract void buildNumber();

    public abstract void buildClassCard();


    @Override
    public String toString() {
        return "CreditCardBuilder{" +
                "creditCard=" + creditCard +
                '}';
    }
}