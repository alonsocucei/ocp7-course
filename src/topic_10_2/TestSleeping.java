package topic_10_2;

/**
 * - There are 4 states for a Thread: New, Runnable, Running, Waiting/Blocked and Dead.
 * - sleep() method makes a thread to move to the Waiting/Blocked state, when
 * the thread wakes up it's moved to the Runnable state.
 * - When a thread is created its state is New.
 * - A thread moves to the Runnable state once the start() method is called.
 * - A thread moves to the Running state when the scheduler decides to give some
 * CPU time to the threat.
 * - A thread moves to the Dead state when it finishes to execute the run() method.
 */
public class TestSleeping {
    public static void main(String[] args) {
        try {
            System.out.println("Sleeping main thread for 3 seconds:");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        PrintSleepyNumbers psn = new PrintSleepyNumbers();
        Thread t1 = new Thread(psn);
        Thread t2 = new Thread(psn);
        Thread t3 = new Thread(psn);
        
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Main has reached the end.");
    }
}

class PrintSleepyNumbers implements Runnable {

    public void run() {
        for (int i = 1; i <= 10; i ++) {
            
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            System.out.printf("name: %s - %d\n", Thread.currentThread().getName(), i);
        }
    }
}

/**
 * To check:
 * - What overloaded versions the sleep() method has?
 * - What Exception is thrown by sleep()?
 * - What other static methods can change the state of a thread?
 * - When a thread is considered alive?
 */