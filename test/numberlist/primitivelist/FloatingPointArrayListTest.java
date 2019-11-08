package numberlist.primitivelist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wai Kwan Chow
 */
public class FloatingPointArrayListTest {
    FloatingPointArrayList list1;
 
    @Before
    public void setUp() {
        list1 = new FloatingPointArrayList();
    }

    /**
     * Test of add method, of class FloatingPointArrayList.
     */
    @Test
    public void testAdd() {
        list1.add(0, 11.25);
        list1.add(1, 12.25);
        list1.add(2, 13.25);
        list1.add(3, 14.25);
        list1.add(4, 15.25);
        list1.add(5, 17.25);
        list1.add(6, 18.25);
        list1.add(7, 19.25);
        list1.add(3, 16.25);
        assertEquals(16.25 , list1.get(3), 0);
        assertEquals(14.25 , list1.get(4), 0);
        assertEquals(15.25, list1.get(5), 0);
        assertEquals(9, list1.size());
    }

    /**
     * Test of removeAt method, of class FloatingPointArrayList.
     */
    @Test
    public void testRemoveAt() {
        testAdd();
        list1.removeAt(3);
        assertEquals(8, list1.size());
        assertEquals(15.25, list1.get(4), 0);
        assertEquals(14.25, list1.get(3), 0);
        assertEquals(17.25, list1.get(5), 0);
    }

    /**
     * Test of remove method, of class FloatingPointArrayList.
     */
    @Test
    public void testRemove() {
         testAdd();
        list1.remove(12.25);
        assertEquals(8, list1.size());
        assertEquals(13.25, list1.get(1), 0);
        assertEquals(16.25, list1.get(2), 0);
        assertEquals(14.25, list1.get(3), 0);
    }

    /**
     * Test of get method, of class FloatingPointArrayList.
     */
    @Test
    public void testGet() {
        testAdd();
        assertEquals(list1.get(0), 11.25, 0);
    }

    /**
     * Test of find method, of class FloatingPointArrayList.
     */
    @Test
    public void testFind() {
         testAdd();
        assertEquals(list1.find(11.25), 0);
        assertEquals(list1.find(16.25), 3);
    }

    /**
     * Test of size method, of class FloatingPointArrayList.
     */
    @Test
    public void testSize() {
        testAdd();
        assertEquals(9, list1.size());
    }
 
}
