package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertEquals(10,arb.capacity());
        assertEquals(0,arb.fillCount());
        arb.enqueue(1);
        arb.enqueue(2);
        arb.print();
        assertEquals(2,arb.fillCount());
        arb.dequeue();
        assertEquals(1,arb.fillCount());
        int temp = arb.peek();
        assertEquals(2,temp);

    }
}
