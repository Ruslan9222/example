import by.ruslan.radzevich.task1.Animal;
import by.ruslan.radzevich.task1.SwitchCase;


public class Main {
    public static void main(String[] args) {

        SwitchCase.switchCase();
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

        Animal animal = new Animal();
        System.err.println(animal);


        String objects = "aaaaa";
        objects.hashCode();



    }
}