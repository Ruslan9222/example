package by.ruslan.radzevich.task6;
   import java.util.HashMap;
   import java.util.Map;
public class LiveCode {

//
//    public class Solution {
//
//        public static void main(String[] args) {
//            Integer a = 0;
//            int b = 0;
//            AtomicInteger c = new AtomicInteger(0);
//            String d = "0";
//
//            increment(a);
//            increment(b);
//            increment(c);
//            increment(d);
//
//            System.out.println(a);
//            System.out.println(b);
//            System.out.println(c);
//            // что будет выведено здесь?
//            System.out.println(d);
//            // а здесь?
//            System.out.println(d + d);
//        }
//
//        public static void increment(Integer a) {
//            ++a;
//        }
//
//        public static void increment(int b) {
//            ++b;
//        }
//
//        public static void increment(AtomicInteger c) {
//            c.incrementAndGet();
//        }
//
//        public static void increment(String d) {
//            d = String.valueOf(
//                    Integer.parseInt(d) + 1
//            );
//        }
//    }


    ////////////////////

    public class Task2 {

        public void main(String[] args) {
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

    ///////////////////////////

//// Что произойдёт, если запустить этот код?
//    public class Main {
//        public static void main(String[] args) {
//            var b = new B();
//            b.show();
//        }
//    }
//
//    class B {
//        B b = new B();
//
//        public int show(){
//            return (true ? null : 0);
//        }
//    }
//
//    //////////////////////////
//
//
//// Что будет выведено?
//    Integer i1 = 128;
//    Integer i2 = 128;
//System.out.println(i1.equals(i2)); true
//
//    Integer i1 = 128;
//    Integer i2 = i1;
//System.out.println(i1.equals(i2)); true
//
//    Integer i1 = 128;
//    Integer i2 = i1;
//System.out.println(i1 == i2); true
//
//    Integer i1 = 128;
//    Integer i2 = i1;
//    i1 = 127;
//System.out.println(i1 == i2);  false
//
//    Integer i1 = 128;
//System.out.println(i1.equals(128)); true
//
//    Integer i1 = 128;
//System.out.println(i1 == 128); true
//
//    Integer i1 = 128;
//System.out.println(i1.hashCode() == 128.hashCode()); ошибка
//    Integer i1 = 128;
//    Integer i2 = 128;
//System.out.println(i1.hashCode() == i2.hashCode()); true
//
//    Integer i1 = 128;
//    Integer i2 = 128;
//System.out.println(i1.hashCode().equals(i2.hashCode())); true
//
//    Integer i1 = 128;
//    Integer i2 = 128;
//System.out.println(i1 == i2); false
//
//    Integer i1 = 127;
//    Integer i2 = 127;
//System.out.println(i1 == i2); true
//
////////////////////
//// SQL
//    //////////////////
//
//// Есть таблица
//    CREATE TABLE employee
//            (
//                    id serial,
//                    name varchar,
//                    phone varchar
//            );
//
//// Каким одним индеком можно ускорить оба запроса?
//    SELECT * FROM employee WHERE id = ?;
//    SELECT * FROM employee WHERE name = ?;
//
//
//    ///////////////
//
//// Есть таблицы
//    FISH (ID, NAME)
//    CATCH (ID, FISH_ID, DT, QUANTITY)
//
//    Необходимо вывести все наименования рыб, суммарный улов по которым на дату d менее n.

//    select f.name, count (c.quantity) as count_quantity
//    from fish f
//    join catch c on c.fish_id = f.id
//    where dt = 'd'
//    group by f.name
//    having count(c.quantity)<n;
//
//
//
///////////////
//// Spring
///////////////
//
//// Что произойдёт с транзакцией в данном примере? Что будет с записью в табличке Person?
//    @Service
//    @RequiredArgsConstructor
//    public class SomeService {
//
//        private final PersonRepository personRepository;
//
//        @Transactional
//        public void doBusiness() throws Exception {
//            Person person = personRepository.getOne(id);
//            person.setName("123");
//
//            throw new IOException();
//
//            person.setAge(21);
//        }
//    }
//
//
//    ///////////
//
//    public class StopThreadTest {
//
//        private static Boolean stopRequested;
//
//        public static void main(String[] args) throws Exception {
//
//            Thread backgroundThread = new Thread(() -> {
//                int i = 0;
//
//                while (!stopRequested) {
//                    i++;
//                }
//            });
//
//            backgroundThread.start();
//
//            TimeUnit.SECONDS.sleep(1);
//
//            stopRequested = true;
//        }
//    }
}
