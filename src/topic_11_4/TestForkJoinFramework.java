package topic_11_4;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * - Use ForkJoinTask or a subclass to use in ForkJoinPool.
 * - Important methods are: compute(), fork() and join().
 * - A key feature of the Fork-Join Framework is work stealing.
 */
public class TestForkJoinFramework {
    public static void main(String[] args) {
        Instant start = Instant.now();
        int[] data = new int[1024 * 1024 * 256]; //1 GB
        
        for (int i = 0; i < data.length; i ++) {
            data[i] = ThreadLocalRandom.current().nextInt();
        }
        
        ForkJoinPool pool = new ForkJoinPool(4);
        FindMaxTask finder = new FindMaxTask(data, 0, data.length - 1, data.length / 32);
        System.out.printf("Max value found: %s\n", pool.invoke(finder));

        Instant end = Instant.now();
        Instant elapsedTime = end.minus(start.toEpochMilli(), ChronoUnit.MILLIS);
        System.out.printf("Time elapsed: %s\n", elapsedTime.toEpochMilli());
    }
}

class FindMaxTask extends RecursiveTask<Integer>{
    private final int threshold;
    private final int[] numbers;
    private final int start;
    private final int end;
    
    public FindMaxTask(int[] numbers, int start, int end, int threshold) {
        this.numbers = numbers;
        this.threshold = threshold;
        this.start = start;
        this.end = end;
    }
    
    protected Integer compute() {
        if (end - start <= threshold) { //number of elements to process is small enough
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i ++) {
                int current = numbers[i];
                
                if (current > max) {
                    max = current;
                }
            }
            
            return max;
        } else {
            int middleIndex = (end - start) / 2 + start;
            
            FindMaxTask leftNumbers = new FindMaxTask(numbers, start, middleIndex, threshold);
            leftNumbers.fork();
            
            FindMaxTask rightNumbers = new FindMaxTask(numbers, middleIndex + 1, end, threshold);
            return Math.max(rightNumbers.compute(), leftNumbers.join());
        }
    }
}

/**
 * To check:
 * - What's the difference between RecursiveTask and RecursiveAction?
 * - When will it take more time to process a task in parallel than sequential?
 */