package gr.parisk85.algorithms;

import java.util.Optional;

public class Search {

    /*
     * Time complexity O(n)
     * Works for unsorted arrays
     */
    public static <T> Optional<T> linear(T element, T... array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return Optional.of(array[i]);
            }
        }
        return Optional.empty();
    }

    /*
     * Time complexity O(log(n))
     * Array must be sorted
     * returns index of element
     */
    public static <T extends Comparable> Optional<Integer> binary(T element, T... array) {
        return binary(element, 0, array.length - 1, array);
    }

    private static <T extends Comparable> Optional<Integer> binary(T element, int startIndex, int endIndex, T... array) {
        if (endIndex - startIndex >= 0) {
            int middle = (endIndex + startIndex) / 2;
            if (array[middle] == element) {
                return Optional.of(middle);
            }
            if (array[middle].compareTo(element) > 0) {
                return binary(element, startIndex, middle - 1, array);
            }
            if (array[middle].compareTo(element) < 0) {
                return binary(element, middle + 1, endIndex, array);
            }
        }
        return Optional.empty();
    }
}
