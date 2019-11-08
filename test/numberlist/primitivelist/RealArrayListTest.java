package numberlist.primitivelist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wai Kwan Chow
 */
public class RealArrayListTest {

    RealArrayList list1;

    @Before
    public void setUp() {
        list1 = new RealArrayList();
    }

    /**
     * Test of add method, of class RealArrayList.
     */
    @Test
    public void testAdd() {
        list1.add(0, 12.25);
        list1.add(1, 13.25);
        list1.add(2, 14.25);
        list1.add(3, 13.25);
        list1.add(4, 15.25);
        assertEquals(5, list1.size());
    }

    /**
     * Test of removeAll method, of class RealArrayList.
     */
    @Test
    public void testRemoveAll() {
        testAdd();
        list1.removeAll(13.25);
        assertEquals(3, list1.size());
    }

    /**
     * Test of findLast method, of class RealArrayList.
     */
    @Test
    public void testFindLast() {
        testAdd();
        assertEquals(4, list1.findLast(15.25));
    }

}
