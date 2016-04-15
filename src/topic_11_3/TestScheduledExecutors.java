package topic_11_3;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * - An ScheduledThreadPoolExecutor enables tasks to be executed after a delay
 * or at repeating intervals.
 * - Methods to use are: schedule(), scheduleAtFixedRate(), scheduleWithFixedDelay().
 */
public class TestScheduledExecutors {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(4);
        Runnable task1 = createRunnable("task 1", 3);
        Runnable task2 = createRunnable("task 2", 3);

        executor.schedule(task1, 0, TimeUnit.SECONDS);
//        executor.scheduleWithFixedDelay(task1, 0, 1, TimeUnit.SECONDS);
        executor.schedule(task2, 2, TimeUnit.SECONDS);
        executor.shutdown();
    }

    public static Runnable createRunnable(final String name, final int duration) {
        return new Runnable() {
            public void run() {
                int i = duration;
                String n = name;

                while (i > 0) {
                    try {
                        Thread.sleep(1000);
                        System.out.printf("Thread: %s Action: %s still %d seconds to finish\n", Thread.currentThread().getName(), n, i--);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.printf("Task: %s, has finished.\n", n);
            }
        };
    }
}

/**
 * To check:
 * - Modify the program to use the missing methods.
 */
