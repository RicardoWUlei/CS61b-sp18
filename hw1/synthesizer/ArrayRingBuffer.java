package synthesizer;
import java.util.Iterator;
import java.util.Objects;

/** Array based Ring buffer that implements BoundedQueue.
 *  @author Ricardo */
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /** Index for the next dequeue or peek. */
    private int first;
    /** Index for the next enqueue. */
    private int last;
    /** Array for storing the buffer data. */
    private T[] rb;

    /** Create a new ArrayRingBuffer with the given capacity.
     * @param capacity */
    public ArrayRingBuffer(int capacity) {
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     * @param x */
    public void enqueue(T x) {
        if (!isFull()) {
            rb[last] = x;
            last = (last + 1) % capacity;
            fillCount += 1;
        } else {
            throw new RuntimeException("Ring buffer overflow");
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (!isEmpty()) {
            T result = rb[first];
            first = (first + 1) % capacity;
            fillCount -= 1;
            return result;
        } else {
            throw new RuntimeException("Ring buffer underflow");
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (!isEmpty()) {
            return rb[first];
        } else {
            throw new RuntimeException("Ring buffer underflow");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new BufferIterator();
    }

    private class BufferIterator implements Iterator<T> {
        private int ptr;
        public BufferIterator() {
            ptr = 0;
        }

        @Override
        public boolean hasNext() {
            return (ptr != capacity);
        }

        @Override
        public T next() {
            T re = rb[ptr + first];
            ptr += 1;
            return re;
        }
    }

}
