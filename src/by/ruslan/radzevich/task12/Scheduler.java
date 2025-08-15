package by.ruslan.radzevich.task12;



import java.util.HashMap;
import java.util.Map;

public class Scheduler {
    private final Map<Integer, Runnable> scheduledMap = new HashMap<>();

    public static void main(String[] args) {
        new Scheduler().runScheduler();
    }

    private void runScheduler() {
        // Заполняем задачи
        scheduledMap.put(1000, () -> System.out.println("Task 1 after 1s"));
        scheduledMap.put(3000, () -> System.out.println("Task 2 after 3s"));
        scheduledMap.put(2000, () -> System.out.println("Task 3 after 2s"));

        for (Map.Entry<Integer, Runnable> entry : scheduledMap.entrySet()) {
            int delay = entry.getKey();
            Runnable task = entry.getValue();

            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(delay);
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Task interrupted");
                }
            });

            thread.setDaemon(true); // Не блокирует завершение JVM
            thread.start();
        }

        System.out.println("Scheduler started");
    }
}