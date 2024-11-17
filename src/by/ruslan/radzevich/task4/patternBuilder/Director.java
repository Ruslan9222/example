package by.ruslan.radzevich.task4.patternBuilder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Director {

    private final CreditCardBuilder creditCardBuilder;

    public CreditCard creditCard() {
        creditCardBuilder.createCreditCard();
        creditCardBuilder.buildOwnerName();
        creditCardBuilder.buildNumber();
        creditCardBuilder.buildClassCard();

        return creditCardBuilder.getCreditCard();

    }
}
