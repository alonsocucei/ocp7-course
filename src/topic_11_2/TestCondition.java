package topic_11_2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * - Condition provides the equivalent to wait(), notify() and notifyAll()
 * methods.
 */
public class TestCondition {

    private static LinkedList<Character> chars = new LinkedList<>();
    private static Lock lock = new ReentrantLock();
    private static Condition bufferNotEmpty = lock.newCondition();

    public static void main(String[] args) {
        Producer producer = new Producer(chars, lock, bufferNotEmpty);
        Thread producerThread = new Thread(producer);
        Consumer consumer = new Consumer(chars, lock, bufferNotEmpty);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {

    private LinkedList<Character> buffer;
    private Lock lock;
    private Condition condition;
    
    public Producer(LinkedList<Character> buffer, Lock lock, Condition condition) {
        this.buffer = buffer;
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        while (true) {
            char randomChar = (char) (Math.random() * ('z' - 'a') + 'a');

            try {
                lock.lock();
                condition.signal();
                buffer.offer(randomChar);
                System.out.printf("Producing element: %s\n", randomChar);
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private LinkedList<Character> buffer;
    private Lock lock;
    private Condition condition;
    
    public Consumer(LinkedList<Character> buffer, Lock lock, Condition condition) {
        this.buffer = buffer;
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        while (true) {
            while (buffer.isEmpty()) {

                try {
                    lock.lock();
                    System.out.println("Waiting for elements");
                    condition.await();
                    System.out.println("Notified for elements");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                char consumedChar = buffer.poll();
                System.out.printf("Consuming element: %s\n", consumedChar);
            }

            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * To check:
 * - What happens if signal() or await() methods are called before calling lock()?
 * - What's the advantage of using Condition instead Object methods?
 */
