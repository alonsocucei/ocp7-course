package topic_10_4;

/**
 * - Thread DeadLock occurs when two threads are blocked with each waiting for
 * other's lock.
 */
public class TestDeadLock {

    public static void main(String[] args) {
        Object resource1 = new Object() {
            @Override
            public String toString() {
                return "resource 1";
            }
        };
        Object resource2 = new Object() {
            @Override
            public String toString() {
                return "resource 2";
            }
        };

        ThreadLock tl = new ThreadLock(resource1, resource2);
        Thread t1 = new Thread(tl, "Thread 1");
        Thread t2 = new Thread(tl, "Thread 2");

        t1.start();
        t2.start();
    }
}

class ThreadLock implements Runnable {

    private Object resource1;
    private Object resource2;

    public ThreadLock(Object resource1, Object resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    public void run() {
        while (true) {
            randomSleep();
            readResource(Math.random() < 0.5 ? resource1 : resource2);
        }
    }

    private void readResource(Object resource) {
        System.out.printf("About to lock: %s by thread: %s.\n", resource, Thread.currentThread().getName());

        synchronized (resource) {
            System.out.printf("%s locked by thread: %s.\n", resource, Thread.currentThread().getName());
            randomSleep();

            Object missingResource = resource == resource1 ? resource2 : resource1;

            System.out.printf("About to lock: %s by thread: %s.\n", missingResource, Thread.currentThread().getName());
            
            synchronized (missingResource) {
                System.out.printf("%s locked by thread: %s.\n", missingResource, Thread.currentThread().getName());
                randomSleep();
            }
            
            System.out.printf("%s released by thread: %s.\n", missingResource, Thread.currentThread().getName());
        }
        
        System.out.printf("%s released by thread: %s.\n", resource, Thread.currentThread().getName());
    }

    private void randomSleep() {
        try {
            int milliseconds = (int) (Math.random() * 1000);
            System.out.printf("About to sleep: %d milliseconds by thead: %s.\n", milliseconds, Thread.currentThread().getName());
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**%
 * To check:
 * - What's wrong with this code?
 * - How deadlock can be avoided?
 */
