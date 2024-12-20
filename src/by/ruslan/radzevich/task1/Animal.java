package by.ruslan.radzevich.task1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


}
