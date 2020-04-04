package gr.parisk85.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {

    @Test
    public void mergeShouldSortUnsortedElements() {
        Integer[] actual = Sort.merge(38, 27, 43, 3, 9, 82, 10);
        assertArrayEquals(new Integer[]{3, 9, 10, 27, 38, 43, 82}, actual);
    }
}