package topic_10_2;

/**
 * - The thread's priority value range is from 1 to 10.
 * - Default priority is 5.
 * - Thread scheduling priority behavior is not guaranteed, so don't rely on it.
 * - Use yield() method to put a thread back to the Runnable state.
 * - Use join() method to wait the current thread completes execution.
 */
public class TestPriorities {
    public static void main(String[] args) {
        PrintYieldNumbers pyn = new PrintYieldNumbers();
        Thread t1 = new Thread(pyn, "T1");
        Thread t2 = new Thread(pyn, "T2");
        Thread t3 = new Thread(pyn, "T3");
        Thread mainThread = Thread.currentThread();
        
        pyn.setPrimaryThread(mainThread);
        pyn.setDependentThread(t2);
        
        t1.start();
        t2.start();
        t3.start();
        
        for (int i = 1; i <= 10; i ++) {
            System.out.printf("name: %s - %d\n", Thread.currentThread().getName(), i);
            Thread.yield();
        }
    }
}

class PrintYieldNumbers implements Runnable {
    private Thread primaryThread;
    private Thread dependentThread;
    
    public void run() {
        if (Thread.currentThread() == dependentThread) {
            try {
                primaryThread.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        for (int i = 1; i <= 10; i ++) {
            System.out.printf("name: %s - %d\n", Thread.currentThread().getName(), i);
            Thread.yield();
        }
    }
    
    public void setPrimaryThread(Thread primaryThread) {
        this.primaryThread = primaryThread;
    }
    
    public void setDependentThread(Thread dependentThread) {
        this.dependentThread = dependentThread;
    }
}

/**
 * To check:
 * - What constants the Thread class has containing values for priority?
 * - What methods are used to set/get the priority?
 * - What's the difference between sleep() and yield() methods?
 * - How can a thread depend on other thread?
 * - What overloaded versions the join() has?
 */