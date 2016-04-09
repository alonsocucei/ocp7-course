package topic_11_1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * - Blocking Queues are collections used to exchange data between two threads.
 * - Blocking Queues implementations are: ArrayBlockingQueue,
 * LinkedBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, DelayQueue,
 * LinkedTransferQueue and SynchronousQueue.
 * - ArrayBlockingQueue, LinkedBlockingDeque, and LinkedBlockingQueue are bounded queues.
 * - SynchronousQueue works like a bounded(1) queue.
 * - DelayQueue implements the Delayed interface.
 * - LinkedTransferQueue is the most efficient blocking queue.
 */
public class TestBlockingQueues {

    private static BlockingQueue<Character> chars = new ArrayBlockingQueue<>(10);

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

    private BlockingQueue<Character> buffer;

    public Producer(BlockingQueue<Character> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            char randomChar = (char) (Math.random() * ('z' - 'a') + 'a');


            try {
                System.out.printf("Befor producing...: %s\n", randomChar);
                buffer.put(randomChar);
                System.out.printf("Producing element: %s\n", randomChar);
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Character> buffer;

    public Consumer(BlockingQueue<Character> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Before consuming...");
                char consumedChar = buffer.take();
                System.out.printf("Element consumed: %s\n", consumedChar);
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * To check:
 * - What happens if add() method is used instead of put()?
 * - What happens if poll() method is used instead of take()?
 * - What methods may block the queue indefinitely?
 * - What methods return null?
 * - What methods throw an Exception if the queue is empty or full?
 */
