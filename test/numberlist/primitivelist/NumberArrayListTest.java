package numberlist.primitivelist;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Wai Kwan Chow
 */
public class NumberArrayListTest {
    NumberArrayList n1;
    
    @Before
    public void setUp() {
        n1 = new NumberArrayList();
    }

    /**
     * Test of add method, of class NumberArrayList.
     */
    @Test
    public void testAdd() {
        n1.add(0, 11);
        n1.add(1, 12);
        n1.add(2, 13);
        n1.add(3, 14);
        n1.add(4, 15);
        n1.add(5, 17);
        n1.add(6, 18);
        n1.add(7, 19);
        n1.add(3, 16);
        assertEquals(16 , n1.get(3));
        assertEquals(14 , n1.get(4));
        assertEquals(15, n1.get(5));
        assertEquals(19, n1.get(8));
        assertEquals(9, n1.size());
        
    }

    /**
     * Test of removeAt method, of class NumberArrayList.
     */
    @Test
    public void testRemoveAt() {
        testAdd();
        //n1.removeAt(3);
        //assertEquals(8, n1.size());
        //assertEquals(15, n1.get(4));
        //assertEquals(14, n1.get(3));
        //assertEquals(17, n1.get(5));
        n1.removeAt(10);
        assertEquals(9, n1.size());
    }

    /**
     * Test of remove method, of class NumberArrayList.
     */
    @Test
    public void testRemove() {
        testAdd();
        n1.remove(12);
        assertEquals(8, n1.size());
        assertEquals(13, n1.get(1));
        assertEquals(16, n1.get(2));
        assertEquals(14, n1.get(3));
    }

    /**
     * Test of get method, of class NumberArrayList.
     */
    @Test
    public void testGet() {
        testAdd();
        assertEquals(n1.get(0), 11);
    }

    /**
     * Test of find method, of class NumberArrayList.
     */
    @Test
    public void testFind() {
        testAdd();
        assertEquals(n1.find(11), 0);
        assertEquals(n1.find(16), 3);
    }

    /**
     * Test of size method, of class NumberArrayList.
     */
    @Test
    public void testSize() {
        testAdd();
        assertEquals(9, n1.size());
        
    }
    
}
