package by.ruslan.radzevich.task6;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<SomeKey, String> test = new HashMap<>();
        SomeKey key1 = new SomeKey("firstKey");
        SomeKey key2 = new SomeKey("secondKey");

        test.put(key1, "firstValue");
        test.put(key2, "secondValue");

        System.out.println(test.get(key1)); //firstKey

        SomeKey key3 = new SomeKey("secondKey");
        System.out.println(test.get(key3)); //secondKey

        key2.value = "";
        System.out.println(test.get(key2)); //firstKey
    }
}

class SomeKey {
    public String value;


    SomeKey(String val) {
        this.value = val;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SomeKey) {
            return value.equals(((SomeKey) obj).value);
        }
        return false;
    }

    @Override
    public String toString() {
        return "SomeKey{" +
                "value='" + value + '\'' +
                '}';
    }

}