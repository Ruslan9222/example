package by.ruslan.radzevich.task1;

import lombok.Getter;

@Getter
public class Phone {
    private String model;
    private int number;
    private int weight;

    public Phone(String model, int number, int weight) {
        this.model = model;
        this.number = number;
        this.weight = weight;
    }



    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", number=" + number +
                ", weight=" + weight +
                '}';
    }

    public void receiveCall(String name) {
        System.out.println("Call" + " " + name + " " + getNumber());
    }

    public void receiveCall(String name, int number) {
        System.out.println("Call" + " " + number + " " + name);
    }
}
