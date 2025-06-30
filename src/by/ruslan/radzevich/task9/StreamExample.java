package by.ruslan.radzevich.task9;


import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        Stream<Integer> mainStream = Stream.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer>list = mainStream.filter(el->el%2==0).toList();
        System.out.println(list);


        List<Integer>list1 = mainStream.filter(el->el%2!=0).toList();
        System.out.println(list1);


    }
}
