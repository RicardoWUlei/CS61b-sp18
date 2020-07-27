package synthesizer;
/** Abstract class for BoundedQueue.
 *  @author Ricardo */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    /** Number of items currently. */
    protected int fillCount;
    /** Capacity of this BoundedQueue. */
    protected int capacity;

    /** Return the capacity of the buffer. */
    public int capacity() {
        return capacity;
    }

    /** Return the number of items in the buffer. */
    public int fillCount() {
        return fillCount;
    }
}
