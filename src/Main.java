import by.ruslan.radzevich.Animal;
import by.ruslan.radzevich.SwitchCase;


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