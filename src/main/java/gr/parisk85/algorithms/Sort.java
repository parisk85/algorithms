package gr.parisk85.algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort {

    public static <T extends Comparable> T[] merge(T... array) {
        if (array.length <= 1) {
            return array;
        }

        int middle = (array.length - 1) / 2;
        T[] left = merge(Arrays.copyOfRange(array, 0, middle + 1));
        T[] right = merge(Arrays.copyOfRange(array, middle + 1, array.length));

        return mergeArrays(left, right);
    }

    private static <T extends Comparable> T[] mergeArrays(T[] left, T[] right) {
        int leftIndex = 0, rightIndex = 0, n = left.length + right.length;
        @SuppressWarnings("unchecked")
        T[] merged = (T[]) Array.newInstance(left[0].getClass(), n);
        int mergedIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            merged[mergedIndex++] = left[leftIndex].compareTo(right[rightIndex]) <= 0 ?
                    left[leftIndex++] : right[rightIndex++];
        }
        while (leftIndex < left.length) {
            merged[mergedIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            merged[mergedIndex++] = right[rightIndex++];
        }
        return merged;
    }
}
