package by.ruslan.radzevich.task12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyScheduler {

    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);

    public void schedule(Runnable task, long delayMillis) {
        // TODO: реализовать запуск task через delayMillis миллисекунд
        if (isShutdown.get()) {
            throw new RejectedExecutionException("Scheduler is shut down");
        }

        // Оборачиваем задачу в delayed wrapper
        executor.submit(() -> {
            try {
                Thread.sleep(delayMillis);
                task.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // корректная обработка прерывания
            }
        });
    }

    public void shutdown() {
        // TODO: корректно завершить работу
        isShutdown.set(true);
        executor.shutdown(); // завершает выполнение текущих задач
    }


    public static void main(String[] args) {
        MyScheduler scheduler = new MyScheduler();

        scheduler.schedule(() -> System.out.println("Task 1 executed at " + System.currentTimeMillis()), 1000);
        scheduler.schedule(() -> System.out.println("Task 2 executed at " + System.currentTimeMillis()), 2000);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown();
    }

}