package by.ruslan.radzevich.task1;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone("Iphone", 5555555, 255);
        Phone phone1 = new Phone("Iphone", 2222222, 269);
        Phone phone2 = new Phone("Iphone", 3333333, 785);


        System.out.println(phone);
        phone.setNumber(12365477);
        System.out.println(phone);
        System.out.println(phone1);
        System.out.println(phone2);

        phone1.receiveCall("Pasha");
        phone2.receiveCall("Masha");
        phone.receiveCall("Misha");

        phone.receiveCall("Nikita", 2222222);


    }


}
