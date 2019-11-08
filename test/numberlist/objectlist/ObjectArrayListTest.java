package numberlist.objectlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wai Kwan Chow
 */
public class ObjectArrayListTest {
    Money m1, m2, m3, m4, m5;
    ObjectArrayList list1;
    
    @Before
    public void setUp() {
        m1 = new Money(10, (byte)50);
        m2 = new Money(15, (byte)25);
        m3 = new Money(20, (byte)15);
        m4 = new Money(25, (byte)10);
        m5 = new Money(30, (byte)20);
        list1 = new ObjectArrayList();
    }

    /**
     * Test of add method, of class ObjectArrayList.
     */
    @Test
    public void testAdd() {
        list1.add(0, m1);
        list1.add(1, m2);
        list1.add(2, m3);
        list1.add(3, m4);
        list1.add(2, m5);
        assertEquals(5, list1.size());
        assertEquals(m5, list1.get(2));
        assertEquals(m3, list1.get(3));
    }

    /**
     * Test of removeAt method, of class ObjectArrayList.
     */
    @Test
    public void testRemoveAt() {
        testAdd();
        list1.removeAt(0);
        assertEquals(m2 , list1.get(0));
        assertEquals(m5, list1.get(1));
        assertEquals(4, list1.size());
        
        
    }

    /**
     * Test of remove method, of class ObjectArrayList.
     */
    @Test
    public void testRemove() {
        testAdd();
        list1.remove(m2);
        assertEquals(m5, list1.get(1));
        assertEquals(4, list1.size());
    }

    /**
     * Test of get method, of class ObjectArrayList.
     */
    @Test
    public void testGet() {
        testAdd();
        assertEquals(m5, list1.get(2));
        assertEquals(m3, list1.get(3));
    }

    /**
     * Test of find method, of class ObjectArrayList.
     */
    @Test
    public void testFind() {
        testAdd();
        assertEquals(0, list1.find(m1));
    }
    
}
