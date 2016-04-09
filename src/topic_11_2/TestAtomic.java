package topic_11_2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * - Atomic variables are used to lock and update values.
 */
public class TestAtomic {
    public static void main(String[] args) throws InterruptedException {
        PrintNumber pn = new PrintNumber();
        Thread thread1 = new Thread(pn);
        Thread thread2 = new Thread(pn);
        Thread thread3 = new Thread(pn);
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.printf("%s: %d\n", "Count is", pn.getValue());
    }
}

class PrintNumber implements Runnable {
    private static final int limit = 10000;
    private int i = 0;
//    private AtomicInteger i = new AtomicInteger(0);
    
    public void run() {
        for (int i = 0; i < limit; i ++) {
            increment();
        }
    }
    
    public void increment() {
        i ++;
//        i.incrementAndGet();
    }
    
    public int getValue() {
        return i;
//        return i.get();
    }
}

/**
 * To check:
 * - What's the problem with the program?
 * - How can be fixed?
 * - What methods are used to increment/decrement/update an atomic variable?
 */