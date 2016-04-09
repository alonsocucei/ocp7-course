package topic_11_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * - An Executor is used to execute the run() method of a Runnable instance. 
 * - Executor approaches are: 
 * Not starting new threads.
 * Starting a thread per task.
 * Queuing tasks and processing them with only enough threads.
 * - Executors class is a factory for Executor implementations. 
 * - ExecutorService inherits from Executor and adds management capability.
 * - There are 3 types of ExecutorService: 
 *  cached thread pool, fixed thread pool and single thread pool.
 */
public class TestExecutors {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Runnable task1 = createRunnable("task 1", 3);
        Runnable task2 = createRunnable("task 2", 3);
        
        executor.execute(task1);
        executor.execute(task2);
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
                        System.out.printf("Action: %s still %d seconds to finish\n", n, i--);
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
 * - Print the thread name in the run method.
 * - Use all types of ExecutorService (fixed, cached and single).
 * - What happens is call to shutdown method is commented?
 */