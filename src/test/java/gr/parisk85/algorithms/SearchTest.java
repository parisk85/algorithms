package gr.parisk85.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {

    @Test
    public void linearShouldReturnExpectedElement() {
        Optional<String> actual = Search.linear("expected", "this", "is", "the", "expected", "element");
        assertEquals(Optional.of("expected"), actual);
    }

    @Test
    public void linearShouldReturnExpectedFirstElement() {
        Optional<String> actual = Search.linear("this", "this", "is", "the", "expected", "element");
        assertEquals(Optional.of("this"), actual);
    }

    @Test
    public void linearShouldReturnExpectedLastElement() {
        Optional<String> actual = Search.linear("element", "this", "is", "the", "expected", "element");
        assertEquals(Optional.of("element"), actual);
    }

    @Test
    public void linearShouldReturnEmptyIfElementNotFound() {
        Optional<Integer> actual = Search.linear(100, 1, 2, 3, 4, 5);
        assertEquals(Optional.empty(), actual);
    }

    @Test
    public void linearShouldReturnEmptyOnEmptyInput() {
        Optional<String> actual = Search.linear("only me");
        assertEquals(Optional.empty(), actual);
    }

    @Test
    public void binaryShouldReturnExpectedElement() {
        Optional<Integer> actual = Search.binary(23, 2, 5, 8, 12, 16, 23, 38, 56, 72, 91);
        assertEquals(Optional.of(5), actual);
    }

    @Test
    public void binaryShouldReturnExpectedStringElement() {
        Optional<Integer> actual = Search.binary("y", "a", "b", "k", "l", "s", "x", "y", "z");
        assertEquals(Optional.of(6), actual);
    }

    @Test
    public void binaryShouldReturnExpectedFirstElement() {
        Optional<Integer> actual = Search.binary(2, 2, 5, 8, 12, 16, 23, 38, 56, 72, 91);
        assertEquals(Optional.of(0), actual);
    }

    @Test
    public void binaryShouldReturnExpectedLastElement() {
        Optional<Integer> actual = Search.binary(91, 2, 5, 8, 12, 16, 23, 38, 56, 72, 91);
        assertEquals(Optional.of(9), actual);
    }

    @Test
    public void binaryShouldReturnEmptyIfElementNotFoundAndLesserThanMin() {
        Optional<Integer> actual = Search.binary(-4, 2, 5, 8, 12, 16, 23, 38, 56, 72, 91);
        assertEquals(Optional.empty(), actual);
    }

    @Test
    public void binaryShouldReturnEmptyIfElementNotFoundAndInBetween() {
        Optional<Integer> actual = Search.binary(25, 2, 5, 8, 12, 16, 23, 38, 56, 72, 91);
        assertEquals(Optional.empty(), actual);
    }


    @Test
    public void binaryShouldReturnEmptyIfElementNotFoundAndGreaterThanMax() {
        Optional<Integer> actual = Search.binary(100, 2, 5, 8, 12, 16, 23, 38, 56, 72, 91);
        assertEquals(Optional.empty(), actual);
    }

    @Test
    public void binaryShouldReturnEmptyOnEmptyInput() {
        Optional<Integer> actual = Search.binary(100);
        assertEquals(Optional.empty(), actual);
    }
}
