package topic_4_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * - Collections is a static class with utility methods.
 * - Arrays is a static class with utility methods.
 * - Both classes contains methods to sort and search elements.
 */
public class TestSortingCollections {
    public static void main(String[] args) {
        Integer a[] = {3, 1, 0, 4, 15, 9, 6};
        List<Integer> numbers = new ArrayList<>();

        for (int n: a) {
            numbers.add(n);
        }
        
        System.out.println(numbers);
        System.out.println(Arrays.toString(a));
    }
}

/**
 * To check:
 * - Sort the array using method sort in Arrays class.
 * - Sort in descending order the list using method sort in Collections class.
 * - What happens when trying to sort a Collection or Array of Objects which
 * class doesn't implement Comparable interface.
 */