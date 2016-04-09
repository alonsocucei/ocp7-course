package topic_10_4;

import java.util.LinkedList;

/**
 * - Thread interaction is done using wait(), notify() and notifyAll() methods.
 * - These methods must be invoked in a synchronized context.
 */
public class TestProducerConsumer {

    private static LinkedList<Character> chars = new LinkedList<>();

    public static void main(String[] args) {
        Producer producer = new Producer(chars);
        Thread producerThread = new Thread(producer);
        Consumer consumer = new Consumer(chars);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {

    private LinkedList<Character> buffer;

    public Producer(LinkedList<Character> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            char randomChar = (char) (Math.random() * ('z' - 'a') + 'a');

            synchronized (buffer) {
                buffer.notify();
                buffer.offer(randomChar);
                System.out.printf("Producing element: %s\n", randomChar);
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

    public Consumer(LinkedList<Character> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    try {
                        System.out.println("Waiting for elements");
                        buffer.wait();
                        System.out.println("Notified for elements");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
 * - How can NullPointerException be avoided?
 * - Why synchronized blocks didn't solve the problem?
 * - What Exception is thrown when calling wait(), notify() of notifyAll() 
 * method outside a synchronized block?
 * - What checked Exception is thrown by the wait() method?
 * - What other overloaded wait() methods exist
 * - How the condition to call wait() method must be?
 */
