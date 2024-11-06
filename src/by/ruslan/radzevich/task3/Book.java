package by.ruslan.radzevich.task3;


import lombok.Getter;


@Getter
public final class Book {
    private final String theTitleOfTheBook;
    private final int yearOfRelease;


    public Book(String theTitleOfTheBook, int yearOfRelease) {
        this.theTitleOfTheBook = theTitleOfTheBook;
        this.yearOfRelease = yearOfRelease;
    }


    @Override
    public String toString() {
        return "Book{" +
                "theTitleOfTheBook='" + theTitleOfTheBook + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
