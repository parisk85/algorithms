package gr.parisk85.algorithms.structures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicArray<T> {
    private T[] array;
    private int size;
    private int capacity;

    public static <T> DynamicArray<T> of(T... elements) {
        return new DynamicArray(elements);
    }

    private DynamicArray(T... elements) {
        size = elements.length;
        capacity = elements.length + 2;
        array = initializeArray(capacity,
                elements.length == 0 ? Object.class : elements[0].getClass(),
                elements);
    }

    public void add(T element) {
        add(element, size);
    }

    public void add(T element, int index) {
        if (size == capacity) {
            increaseCapacity();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, size));
    }

    private void increaseCapacity() {
        capacity *= capacity;
        array = initializeArray(capacity, array[0].getClass(), array);
    }

    private <T> T[] initializeArray(int capacity, Class<?> type, T... elements) {
        T[] temp = (T[]) Array.newInstance(type, capacity);
        for (int i = 0; i < elements.length; i++) {
            temp[i] = elements[i];
        }
        return temp;
    }
}
