package synthesizer;
import java.util.Iterator;

/** Interface for BoundedQueue.
 * @author Ricardo */
public interface BoundedQueue<T> extends Iterable<T> {
    /** return size of the buffer. */
    int capacity();

    /** return number of items currently in the buffer. */
    int fillCount();

    /** add a item x to the end.
     * @param x the item want to add. */
    void enqueue(T x);

    /** delete and return a item from the front. */
    T dequeue();

    /** return (but do not delete) item from the front. */
    T peek();

    /** is the buffer empty.
     * @return true if empty.*/
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    /** is the buffer full.
     * @return true if full. */
    default boolean isFull() {
        return fillCount() == capacity();
    }
}
