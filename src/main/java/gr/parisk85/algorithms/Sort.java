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
        T[] merged = (T[]) Array.newInstance(getTypeFromNonEmptyArray(left, right), n);
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

    private static <T extends Comparable> Class<? extends Comparable> getTypeFromNonEmptyArray(T[] a, T[] b) {
        assert a.length + b.length > 0;
        return a.length != 0 ? a[0].getClass() : b[0].getClass();
    }

    public static <T extends Comparable> T[] quick(T... array) {
        return quick(0, array.length - 1, array);
    }

    private static <T extends Comparable> T[] quick(int startIndex, int endIndex, T... array) {
        if (startIndex < endIndex) {
            T pivot = array[endIndex];
            int i = 0;
            for (int j = 0; j < endIndex; j++) {
                if (pivot.compareTo(array[j]) >= 0) {
                    swap(array, i++, j);
                }
            }
            swap(array, i, endIndex);
            quick(startIndex, i - 1, array);
            quick(i + 1, endIndex, array);
        }
        return array;
    }

    private static <T> T[] swap(T[] array, int indexA, int indexB) {
        T temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
        return array;
    }
}
