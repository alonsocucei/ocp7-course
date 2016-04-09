package topic_11_1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * - Concurrent collections in java.util.concurrent package are:
 * ConcurrentHashMap, ConcurrentLinkedDeque, ConcurrentLinkedQueue,
 * ConcurrentSkipListMap, ConcurrentSkipListSet
 * - A ConcurrentMap enhances a Map by adding the atomic putIfAbsent, remove, and replace methods
 */
public class TestConcurrentCollections {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> cq = new ConcurrentLinkedQueue<>();
        ArrayList<Integer> al = new ArrayList<>();
        
        Provider qp = new Provider(cq);
        Provider ap = new Provider(al);
        
        Thread t1 = new Thread(qp);
        Thread t2 = new Thread(qp);
        Thread t3 = new Thread(ap);
        Thread t4 = new Thread(ap);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            System.out.printf("Concurrent Collection size: %d\n", cq.size());
            System.out.printf("Normal Collection size: %d\n", al.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Provider implements Runnable {
    private Collection<Integer> collection;
    
    public Provider(Collection<Integer> collection) {
        this.collection = collection;
    }
    
    public void run() {
        for (int i = 0; i < 100_000; i ++) {
            collection.add(i);
        }
    }
}

/**
 * To check:
 * - What concurrent collections are sorted?
 */