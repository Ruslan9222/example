package by.ruslan.radzevich.task2;


public final class MyImmutableClass {
    private final String name;
    private final int age;

    public MyImmutableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "MyImmutableClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public static void main(String[] args) {
        MyImmutableClass myImmutableClass = new MyImmutableClass("Руслан", 35);
        System.out.println(myImmutableClass);
    }
}
