package gr.parisk85.algorithms.structures;

public class Queue<T> {
    private T[] array;

    public static <T> Queue of(T... array) {
        return new Queue(array);
    }

    private Queue(T... array) {
        this.array = array;
    }

    public T first() {
        return array[0];
    }

    public T last() {
        return array[array.length - 1];
    }

    public void enqueue(T element) {}

    public T dequeue() {
        return array[array.length - 1];
    }
}
