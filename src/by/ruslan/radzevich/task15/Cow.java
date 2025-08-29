package by.ruslan.radzevich.task15;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@Scope("prototype")
public class Cow implements Animal {

    private final String name;

    public Cow() {
        name = ThreadLocalRandom.current().nextBoolean() ? "Мурка" : "Гаврюша";
    }

    @Override
    public String voice() {
        return "Му";
    }

    @Override
    public String getName() {
        return name;
    }
}
