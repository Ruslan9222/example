package by.ruslan.radzevich.cycle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Animal {
    private String name;
    private int age;
    private String gender;
    private int weight;


//    Enable Full Line suggestions






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && weight == animal.weight && Objects.equals(name, animal.name) && Objects.equals(gender, animal.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, weight);
    }
}
