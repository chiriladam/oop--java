package lab6.queue;

/**
 * Queue implemented using a linked-node structure.
 */
public class LinkedQueue<T> implements Queue<T> {

    private static class Node<T> {
        T val;
        Node<T> next;
        Node(T v) { val = v; }
    }

    private Node<T> head, tail;

    @Override
    public void enqueue(T value) {
        Node<T> node = new Node<>(value);

        if (tail != null)
            tail.next = node;

        tail = node;

        if (head == null)
            head = node;
    }

    @Override
    public T dequeue() {
        if (head == null) return null;

        T value = head.val;
        head = head.next;
        if (head == null) tail = null;

        return value;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
