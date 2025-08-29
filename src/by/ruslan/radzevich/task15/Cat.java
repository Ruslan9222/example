package by.ruslan.radzevich.task15;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {

    @Override
    public String voice() {
        return "Мяу";
    }

    @Override
    public String getName() {
        return "Матроскин";
    }
}
