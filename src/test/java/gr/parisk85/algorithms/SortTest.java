package gr.parisk85.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {

    @Test
    public void mergeShouldSortUnsortedElements() {
        Integer[] actual = Sort.merge(38, 27, 43, 3, 9, 82, 10);
        assertArrayEquals(new Integer[]{3, 9, 10, 27, 38, 43, 82}, actual);
    }

    @Test
    public void mergeShouldReturnEmptyArrayWhenNoInput() {
        Integer[] actual = Sort.merge();
        assertArrayEquals(new Integer[]{}, actual);
    }

    @Test
    public void mergeShouldReturnOneElementArrayWhehnOneArg() {
        String[] actual = Sort.merge("one argument");
        assertArrayEquals(new String[]{"one argument"}, actual);
    }

    @Test
    void margeShouldSortTwoElementArray() {
        Long[] actual = Sort.merge(6L, 5L);
        assertArrayEquals(new Long[]{5L, 6L}, actual);
    }

    @Test
    void margeShouldSortArrayWithDuplicates() {
        Long[] actual = Sort.merge(6L, 5L, 4L, 5L, 7L);
        assertArrayEquals(new Long[]{4L, 5L, 5L, 6L, 7L}, actual);
    }

    @Test
    public void quickShouldSortUnsortedIntegerElements() {
        Integer[] actual = Sort.quick(10, 80, 30, 90, 40, 50, 70);
        assertArrayEquals(new Integer[]{10, 30, 40, 50, 70, 80, 90}, actual);
    }

    @Test
    public void quickShouldSortUnsortedStringElements() {
        String[] actual = Sort.quick("g", "G", "b", "c", "E", "a", "B", "C", "A", "D");
        assertArrayEquals(new String[]{"A", "B", "C", "D", "E", "G", "a", "b", "c", "g"}, actual);
    }

    @Test
    public void quickShouldSortUnsortedStringElementsWithDuplicates() {
        String[] actual = Sort.quick("g", "G", "b", "c", "E", "a", "B", "B", "C", "c", "A", "D");
        assertArrayEquals(new String[]{"A", "B", "B", "C", "D", "E", "G", "a", "b", "c", "c", "g"}, actual);
    }

    @Test
    public void quickShouldSortUnsortedIntegerElementsWithDuplicates() {
        Integer[] actual = Sort.quick(10, 80, 30, 90, 40, 50, 70, 80);
        assertArrayEquals(new Integer[]{10, 30, 40, 50, 70, 80, 80, 90}, actual);
    }

    @Test
    public void quickShouldReturnEmptyArray() {
        Integer[] actual = Sort.quick();
        assertArrayEquals(new Integer[]{}, actual);
    }
}
