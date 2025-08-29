package by.ruslan.radzevich.task15;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

    @Override
    public String voice() {
        return "Гав";
    }

    @Override
    public String getName() {
        return "Шарик";
    }
}
