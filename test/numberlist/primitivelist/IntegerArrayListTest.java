package numberlist.primitivelist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wai Kwan Chow
 */
public class IntegerArrayListTest {

    IntegerArrayList list1;

    @Before
    public void setUp() {
        list1 = new IntegerArrayList();
    }

    /**
     * Test of add method, of class IntegerArrayList.
     */
    @Test
    public void testAdd() {
        list1.add(0, 11);
        list1.add(1, 12);
        list1.add(2, 13);
        list1.add(3, 14);
        list1.add(4, 11);
        list1.add(5, 12);
        list1.add(6, 13);
        list1.add(7, 18);
        assertEquals(8, list1.size());
    }

    /**
     * Test of removeAll method, of class IntegerArrayList.
     */
    @Test
    public void testRemoveAll() {
        testAdd();
        list1.removeAll(11);
        assertEquals(6, list1.size());
        
    }

    /**
     * Test of findLast method, of class IntegerArrayList.
     */
    @Test
    public void testFindLast() {
        assertEquals(7, list1.findLast(18));
    }

}
