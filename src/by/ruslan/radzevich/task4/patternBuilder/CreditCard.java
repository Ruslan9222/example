package by.ruslan.radzevich.task4.patternBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreditCard {
    private String OwnerName;
    private Integer number;
    private ClassCard classCard;

}
