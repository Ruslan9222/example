package by.ruslan.radzevich;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor


public class Animal {
    private String name;
    private int age;
    private String gender;
    private int weight;
    private String firstName;

    public Animal(String name, int age, String gender, int weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }
 future_for_future_relase
    public void setName(String name) {
        this.name = name;
    public int getWeight() {
        return weight;master
    }
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
