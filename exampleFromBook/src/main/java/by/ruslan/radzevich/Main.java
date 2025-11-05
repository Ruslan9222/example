package by.ruslan.radzevich;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

public class Main {

    private Semaphore semaphore = new Semaphore(5);
    private Phaser phaser = new Phaser();
    private CountDownLatch countDownLatch = new CountDownLatch(5);
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    private Exchanger exchanger = new Exchanger<>();
    private BigDecimal bigDecimal = new BigDecimal("0");
    public BigDecimal getBigDecimal(){
        return bigDecimal;
    }
    public void setBigDecimal(BigDecimal bigDecimal){
       this.bigDecimal = bigDecimal;
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.setBigDecimal(new BigDecimal("123.45"));
        System.out.println(main.getBigDecimal());


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


