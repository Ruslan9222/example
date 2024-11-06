package by.ruslan.radzevich.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>() {
        };
        studentList.add(new Student("Руслан", List.of(new Book("Java from EPAM", 2020),
                new Book("HeadFirstJava", 2022))));
        studentList.add(new Student("Полина", List.of(new Book("Spring в деиствий", 2022),
                new Book("Грокаем алгоритмы", 2024))));

        System.out.println(studentList);

        Optional<Integer> yearOptional = studentList.stream()
                .flatMap(student -> student.getBooks().stream())
                .map(Book::getYearOfRelease)
                .findAny();


        yearOptional.ifPresentOrElse(
                year -> System.out.println("Год выпуска книги: " + year),
                () -> System.out.println("Книга с таким годом выпуска отсутствует")
        );

    }
}
