package by.ruslan.radzevich.task13;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Scheduler {

    private final Map<Integer, Runnable> scheduleMap = new HashMap<>();
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);


    public static void main(String[] args) {


    }

    private void runScheduler() {
        executor.schedule(() -> {
            System.out.println("scheduleMap = " + scheduleMap);
        },10, TimeUnit.MILLISECONDS);
        for (Map.Entry<Integer, Runnable> entry : scheduleMap.entrySet()) {
            int delay = entry.getKey();
            Runnable task = entry.getValue();


            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(delay);
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            });
            thread.setDaemon(true);
            thread.start();
        }
    }
}