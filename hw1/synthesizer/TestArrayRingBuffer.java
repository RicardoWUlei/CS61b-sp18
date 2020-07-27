package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer>(10);
        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }
        for (Integer i : arb) {
            System.out.println(i);
        }
//        Integer expected = 1;
//        arb.dequeue();
//        Integer actual = arb.dequeue();
//        assertEquals(expected, actual);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
