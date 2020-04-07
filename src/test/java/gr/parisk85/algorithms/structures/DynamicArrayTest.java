package gr.parisk85.algorithms.structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicArrayTest {

    @Test
    public void shouldInitializeEmptyArray() {
        DynamicArray<Integer> actual = DynamicArray.of();
        assertEquals("[]", actual.toString());
    }

    @Test
    public void shouldReturnZeroSizeForEmptyArray() {
        DynamicArray<Integer> actual = DynamicArray.of();
        assertEquals(0, actual.size());
    }

    @Test
    public void shouldReturnAppropriateSizeForNonEmtyArray() {
        DynamicArray<String> actual = DynamicArray.of("a", "b", "c");
        assertEquals(3, actual.size());
    }

    @Test
    public void shouldReturnExpectedArrayAfterAddingAnElement() {
        DynamicArray<Integer> actual = DynamicArray.of(1, 2);
        actual.add(3);
        assertEquals(3, actual.size());
    }

    @Test
    public void shouldReturnExpectedArrayAfterAddingMultipleElements() {
        DynamicArray<Integer> actual = DynamicArray.of(1, 2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        actual.add(6);
        actual.add(7);
        actual.add(8);
        assertEquals(8, actual.size());
    }
}
