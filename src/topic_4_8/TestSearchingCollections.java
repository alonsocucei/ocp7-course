package topic_4_8;

import java.util.Arrays;

/**
 * - Binary search is used in Collections and Arrays classes.
 * - Before searching the collection/array must be sorted, otherwise the result
 * will be unexpected.
 * - If element is found the index is returned otherwise a negative number indicating
 * insertion point is returned.
 */
public class TestSearchingCollections {
    public static void main(String[] args) {
        Integer a[] = {3, 1, 0, 4, 4, 4, 15, 9, 6};
        DescendingOrder descendingComparator = new DescendingOrder();
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, descendingComparator);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a, 4, descendingComparator));
        System.out.println(Arrays.binarySearch(a, 15, descendingComparator));
        System.out.println(Arrays.binarySearch(new Object[]{"a", "b", 3, 4.2}, 4.2));
    }
}


/**
 * To check:
 * - What happens if there are elements duplicated? Which one is returned?
 * - What happens when searching on an array or collection containing different
 * types of objects?
 * - What happens when trying to search a Collection sending a Comparator which
 * compares elements in a different way than the one used to sort it?
 */