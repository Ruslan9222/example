package by.ruslan.radzevich.task6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MapExample1 {
        public static void main(String[] args) {
            Map<SomeKey1, String> test = new HashMap<>();
            SomeKey1 key1 = new SomeKey1("firstKey");
            SomeKey1 key2 = new SomeKey1("secondKey");
            test.put(key1, "firstValue");
            test.put(key2, "secondValue");
            System.out.println(test.get(key1));
            SomeKey1 key3 = new SomeKey1("secondKey");
            System.out.println(test.get(key3));
            key2.value = "";
            System.out.println(test.get(key2));
        }
    }

    class SomeKey1 {
        public String value;

        SomeKey1(String val) {
            this.value = val;
        }

        public int hashCode() {
            return Objects.hash(this);
        }

        public boolean equals(Object obj) {
            if (obj instanceof SomeKey1 someKey) {
                return value.equals(someKey.value);
            }
            return false;
        }

    }

