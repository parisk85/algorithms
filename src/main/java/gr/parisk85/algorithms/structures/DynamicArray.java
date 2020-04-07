package gr.parisk85.algorithms.structures;

import java.lang.reflect.Array;

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
        if (size == capacity) {
            increaseCapacity();
        }
        array[size++] = element;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(String.format("%s, ", array[i]));
        }
        return result.append("]").toString();
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
