package topic_11_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * - Lock interface provides the functionality of traditional synchronized blocks.
 * - ReentrantLock implements Lock interface.
 * - Use lock() method to immediately acquire the lock or block until is released.
 * - Use unlock() method to release the lock.
 * - Use tryLock() method in case you don't want your thread blocks until lock is
 * released.
 */
public class TestReentrantLock {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        RunnableLock rl = new RunnableLock(lock);
        Thread t1 = new Thread(rl);
        Thread t2 = new Thread(rl);
        
        t1.start();
        t2.start();
    }
}

class RunnableLock implements Runnable {
    private Lock lock;
    
    public RunnableLock(Lock lock) {
        this.lock = lock;
    }
    
    public void run() {
        try {
            System.out.printf("Thread: %s is trying to get lock\n", Thread.currentThread().getName());
            lock.lock();
            System.out.printf("Thread: %s has the lock\n", Thread.currentThread().getName());
        } finally {
            lock.unlock();
            System.out.printf("Thread: %s has released the lock\n", Thread.currentThread().getName());
        }
    }
}

/**
 * To check:
 * - What happens if lock() is called twice?
 * - What happens if unlock() method is called before lock()?
 * - How can lock awaiting be avoid?
 * - What's the difference between both tryLock() overloaded methods?
 */