package topic_10_1;

/**
 * - Thread contains overloaded constructors:
 *   Thread(Runnable), Thread(Runnable, name) and Thread(name)
 * - When a Thread is created, it moves to the new state.
 * - When start method is called, Thread moves from new to runnable state.
 * - A thread contains two attributes to recognize it between others: id and name.
 * - Once a Thread is started, it runs until is completed.
 */
public class TestMultipleThreadsOneRunnable {

    public static void main(String[] args) {
        PrintNumbers pn = new PrintNumbers();
        Thread t1 = new Thread(pn);
        Thread t2 = new Thread(pn);
        Thread t3 = new Thread(pn);
        System.out.printf("name: %s\n", Thread.currentThread().getName());
        
        t1.start();
        t2.start();
        t3.start();
    }
}

class PrintNumbers implements Runnable {

    public void run() {
        for (int i = 1; i <= 10; i ++) {
            System.out.printf("name: %s - %d\n", Thread.currentThread().getName(), i);
        }
    }
}
/**
 * To check: 
 * - Is this possible the same with a class extending Thread?
 * - When a Thread is considered alive?
 * - What Thread states can be seen in this example?
 * - How can Threads name be changed?
 * - What happens if run() method is called directly?
 * - When the program finishes?
 */
