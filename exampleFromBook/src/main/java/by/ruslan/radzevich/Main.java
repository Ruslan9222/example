package by.ruslan.radzevich;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
            Map<SomeKey, String> test = new HashMap<>();

            SomeKey key1 = new SomeKey("firstKey");
            SomeKey key2 = new SomeKey("secondKey");

            test.put(key1, "firstValue");
            test.put(key2, "secondValue");

            System.out.println(test.get(key1)); // что будет тут?

            SomeKey key3 = new SomeKey("secondKey");

            System.out.println(test.get(key3)); // а тут?

            key2.value = "";

            System.out.println(test.get(key2)); // а здесь?
        }
    }

    class SomeKey {
        public String value;

        SomeKey(String val) {
            this.value = val;
        }

        public int hashCode() {
            return 1;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SomeKey) {
                return value.equals(((SomeKey) obj).value);
            }
            return false;
        }
    }


