package topic_11_2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * - ReadWriteLock interface is implemented by ReentrantReadWriteLock. 
 * - The class contains 1 lock for reading and 1 for writing.
 * - A thread cannot have both locks at same time.
 * - Two or more threads can lock the read lock
 */
public class TestReentrantReadWriteLock {

    public static void main(String[] args) {
        ReadWriteLock rwl = new ReentrantReadWriteLock();
        ConcurrentString cs = new ConcurrentString(rwl);

        Thread t1 = new Thread(cs);
        Thread t2 = new Thread(cs);
        Thread t3 = new Thread(cs);
        Thread t4 = new Thread(cs);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class ConcurrentString implements Runnable {

    private StringBuilder text = new StringBuilder();
    private ReadWriteLock rwl;

    public ConcurrentString(ReadWriteLock rwl) {
        this.rwl = rwl;
    }

    public void run() {
        ThreadLocalRandom tlr = ThreadLocalRandom.current();

        while (true) {
            try {
                if (tlr.nextBoolean()) {
                    System.out.printf("Trying to acquire read lock by %s\n", Thread.currentThread().getName());
                    read();
                } else {
                    System.out.printf("Trying to acquire write lock by %s\n", Thread.currentThread().getName());
                    write((char) tlr.nextInt(65, 92));
                }
                
                Thread.sleep(tlr.nextInt(50, 5000));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public String read() {
        try {
            rwl.readLock().lock();
            System.out.printf("Read lock acquired by %s\n", Thread.currentThread().getName());
            simulate(Thread.currentThread(), "reading.", 500).join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            rwl.readLock().unlock();
            System.out.printf("Read lock released by %s\n", Thread.currentThread().getName());
        }
        
        return text.toString();
    }

    public void write(char letter) {
        try {
            rwl.writeLock().lock();
            System.out.printf("Write lock acquired by %s\n", Thread.currentThread().getName());
            text.append(letter);
            simulate(Thread.currentThread(), "writing.", 5000).join();
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            rwl.writeLock().unlock();
            System.out.printf("Write lock released by %s\n", Thread.currentThread().getName());
        }
    }
    
    private Thread simulate(final Thread currentThread, final String description, final int timeRange) {
        Thread t = new Thread(new Runnable(){
            public void run() {
                try {
                    System.out.printf("%s %s\n", currentThread.getName(), description);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(50, timeRange));
                    System.out.printf("%s after %s\n", currentThread.getName(), description);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        t.start();
        return t;
    }
}

/**
 * To check: 
 * - What happens if sleep() is called instead simulate() method?
 */
