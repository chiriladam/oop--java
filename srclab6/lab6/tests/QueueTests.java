package lab6.tests;

import lab6.queue.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTests {

    @Test
    public void testArrayQueue() {
        Queue<Integer> q = new SimpleArrayQueue<>();
        q.enqueue(1); q.enqueue(2);
        assertEquals(1, q.dequeue());
        assertEquals(2, q.dequeue());
    }

    @Test
    public void testLinkedQueue() {
        Queue<String> q = new LinkedQueue<>();
        q.enqueue("A"); q.enqueue("B");
        assertEquals("A", q.dequeue());
        assertEquals("B", q.dequeue());
    }

    @Test
    public void testFixedQueue() {
        Queue<Integer> q = new FixedSizeQueue<>(2);
        q.enqueue(10); q.enqueue(20);
        q.enqueue(30); // ignored because full
        assertEquals(10, q.dequeue());
        assertEquals(20, q.dequeue());
        assertNull(q.dequeue());
    }
}
