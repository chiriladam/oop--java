package lab6.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple queue implemented using a Java ArrayList.
 */
public class SimpleArrayQueue<T> implements Queue<T> {
    private List<T> data = new ArrayList<>();

    @Override
    public void enqueue(T value) {
        data.add(value);
    }

    @Override
    public T dequeue() {
        if (data.isEmpty()) return null;
        return data.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
