package lab6.queue;

/**
 * Generic Queue interface.
 * Any queue implementation must implement these two methods.
 */
public interface Queue<T> {
    void enqueue(T value);
    T dequeue();
    boolean isEmpty();
}
