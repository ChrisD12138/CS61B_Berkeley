package bearmaps;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayHeapMinPQTest {
    ArrayHeapMinPQ<Integer> test = new ArrayHeapMinPQ<>();

    @Test
    public void addTest() {
        test.add(9,9);
        int returnitem = test.getSmallest();
        assertEquals(9,returnitem);
    }

    @Test
    public void removesmallesttest(){
        test.add(4,4);
        test.add(2,2);
        test.add(3,3);
        test.add(1,1);
        int returnitem = test.removeSmallest();
        assertEquals(1,returnitem);
    }

    @Test
    public void containstest(){
        test.add(4,4);
        test.add(2,2);
        test.add(3,3);
        test.add(1,1);
        assertTrue(test.contains(3));
        assertFalse(test.contains(9));
    }
    @Test
    public void changeprioritytest(){
        test.add(4,4);
        test.add(2,2);
        test.add(3,3);
        test.add(1,1);
        test.changePriority(4,0);
        int smallest = test.getSmallest();
        assertEquals(4,smallest);
    }

    @Test
    public void sizetest(){
        test.add(4,4);
        test.add(2,2);
        test.add(3,3);
        test.add(1,1);
        assertEquals(4,test.size());
    }

}
