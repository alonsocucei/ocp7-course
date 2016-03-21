package topic_10_1;

/**
 * - Runnable is the base interface to start programming on Threads.
 * - Runnable declares the run() method.
 * - Thread is the class used to create a new Thread, it implements Runnable
 * interface with an empty run() method.
 * - To program threads there are 2 options:
 *   1.- To implement from Runnable interface.
 *   2.- To extend from Thread class.
 */
public class TestThreadAndRunnable {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        MyRunnable runnable = new MyRunnable();
        Thread runnableThread = new Thread(runnable);
        
        thread.start();
        runnableThread.start();
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread Concurrent code executes here");
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("MyRunnable Concurrent code executes here");
    }
}

/**
 * To check:
 * - What are the 2 ways to work with threads?
 * - When each one is preferred?
 * - What the run method does?
 * - What the start method does?
 * - What happens if calling run method instead start?
 * - What happens is start method is called again?
 */