package by.ruslan.radzevich.task4.patternBuilder;

public class BuildGoldCard extends CreditCardBuilder {

    @Override
    public void buildOwnerName() {
        getCreditCard().setOwnerName("Ruslan");
    }

    @Override
    public void buildNumber() {
        getCreditCard().setNumber(6666_9999);

    }

    @Override
    public void buildClassCard() {
        getCreditCard().setClassCard(ClassCard.GOLD);

    }
}
