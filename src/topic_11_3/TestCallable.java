package topic_11_3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/**
 * - Callable interface works like a Runnable but it can return a result and
 * it can throw an Exception.
 */
public class TestCallable {
    public static void main(String[] args) {
        Callable callable = new MyCallable();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(callable);
        executor.shutdown();
        
        try {
            System.out.printf("future: %d\n", future.get());
            
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyCallable implements Callable<Integer> {
    public Integer call() {
        int random = ThreadLocalRandom.current().nextInt(0, 30);
        int sum = 0;
        
        for (int i = 0; i < random; i ++) {
            sum += i;
        }
        
        return sum;
    }
}

/**
 * To check:
 * - Print the name of the thread executing the call() method.
 * - What is the difference between methods shutDown() and shutDownNow()?
 */