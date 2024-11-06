package by.ruslan.radzevich.task3;

import lombok.Getter;

import java.util.List;


@Getter
public final class Student {
    private final String name;
    private final List<Book> books;

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
