package topic_10_3;

/**
 * - Using shared data brings with synchronization problems like reading data
 * not updated or with a non valid state.
 * - The solution to this is to make operations atomic.
 * - synchronized keyword is used to make a method or code block executes like
 * an atomic operation.
 */
public class TestPrintingNotSynchronized {
    public static void main(String[] args) {
        PrintNotSynchronizedNumbers pnsn = new PrintNotSynchronizedNumbers(100);
        
        Thread t1 = new Thread(pnsn);
        Thread t2 = new Thread(pnsn);
        Thread t3 = new Thread(pnsn);
        
        t1.start();
        t2.start();
        t3.start();
    }
}

class PrintNotSynchronizedNumbers implements Runnable {
    private int i;
    private int limit;
    
    public PrintNotSynchronizedNumbers(int limit) {
        this.limit = limit;
    }
    
    public void run() {
        while (isInLimit()) {
            print();
            increment();
            randomSleep();
        }
    }
    
    private void randomSleep() {
        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private boolean isInLimit() {
        return i < limit;
    }
    
    private void increment() {
        i ++;
    }
    
    private void print() {
        System.out.printf("name: %s - %d\n", Thread.currentThread().getName(), i);
    }
}

/**
 * To check:
 * - How the program can be fixed?
 * - Where the synchronized keyword can be applied?
 * - On what object a member method is synchronized?
 * - On what object a static method is synchronized?
 * - What code block is equivalent to a synchronized method?
 * - What's the disadvantage of using synchronization?
 */