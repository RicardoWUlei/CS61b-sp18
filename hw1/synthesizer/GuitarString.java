package synthesizer;

/** Guitar String.
 *  @author Ricardo */
public class GuitarString {
    /** Sampling Rate. */
    private static final int SR = 44100;
    /** energy decay factor. */
    private static final double DECAY = .996;

    /** Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /** Create a guitar string of the given frequency.
     *  @param frequency  */
    public GuitarString(double frequency) {
        int capacity = (int) Math.round(SR / frequency);
        buffer = (BoundedQueue<Double>) new ArrayRingBuffer<Double>(capacity);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.enqueue(0.0);
        }
    }


    /** Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.dequeue();
            double r = Math.random() - 0.5;
            buffer.enqueue(r);
        }
    }

    /** Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. */
    public void tic() {
        double f1 = buffer.dequeue();
        double f2 = buffer.peek();
        buffer.enqueue(0.5 * DECAY * (f1 + f2));
    }

    /** Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}
