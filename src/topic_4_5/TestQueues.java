package topic_4_5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * - Queue extends Collection
 * - Known as FIFO
 */
public class TestQueues {
    public static void main(String[] args) {
        Deque<String> names = new ArrayDeque<>();
        //add 3 names
        
        //add to front
        names.addFirst("Alonso");
        names.offerFirst("Agua");
        names.push("Name");
        names.offerFirst(null);
        
        //add to end
        names.addLast("end last");
        names.offerLast("end offer");
        names.add("end add");
        
        //remove at front
        names.pollFirst();
        names.removeFirst();
        names.pop();
        names.poll();
        names.remove();
        
        //remove at end
        names.removeLast();
        names.pollLast();
        
        //get at front
        names.getFirst();
        names.peekFirst();
        names.element();
        names.peek();
        
        //get at end
        names.getLast();
        names.peekLast();
        
        names.add("A");
        names.push("A");
        names.offer("Marco");
        names.offerLast("Julio"); //restricted to capacity
        
        //check if queue is empty
        System.out.println("is empty:"+ names.isEmpty());
        
        //check if "Alonso" is in the queue
        names.contains("Alonso");
        
        //print the number of elements contained in the queue
        System.out.println("size is: " + names.size());
        
        //print the complete queue
        System.out.println(names);
    }
}

/**
 * To check:
 * - Does a queue allows null values?
 * - Does a queue allows duplicate values?
 * - Is a queue is ordered or unordered?
 * - Is a queue sorted?
 * - What classes implement Queue?
 * - What interfaces extend Queue?
 * - What's the difference between a Queue and a Deque?
 */