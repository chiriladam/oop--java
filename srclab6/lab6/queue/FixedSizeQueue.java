package lab6.queue;

/**
 * Queue implemented using a circular buffer with fixed size.
 */
public class FixedSizeQueue<T> implements Queue<T> {

    private Object[] arr;
    private int front = 0, rear = 0, size = 0;

    public FixedSizeQueue(int capacity) {
        arr = new Object[capacity];
    }

    @Override
    public void enqueue(T value) {
        if (size == arr.length) return; // queue full
        arr[rear] = value;
        rear = (rear + 1) % arr.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) return null;

        T value = (T) arr[front];
        front = (front + 1) % arr.length;
        size--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
