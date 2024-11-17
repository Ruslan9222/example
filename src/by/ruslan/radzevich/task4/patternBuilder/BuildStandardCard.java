package by.ruslan.radzevich.task4.patternBuilder;

public class BuildStandardCard extends CreditCardBuilder {

    @Override
    public void buildOwnerName() {
        getCreditCard().setOwnerName("Maxim");

    }

    @Override
    public void buildNumber() {
        getCreditCard().setNumber(1234_4321);

    }

    @Override
    public void buildClassCard() {
        getCreditCard().setClassCard(ClassCard.STANDARD);

    }
}
