package numberlist.objectlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wai Kwan Chow
 */
public class ObjectLinkedListTest {
    
    ObjectLinkedList list1;
    
    @Before
    public void setUp() {
        list1 = new ObjectLinkedList();
        
    }

    /**
     * Test of add method, of class ObjectLinkedList.
     */
    @Test
    public void testAdd() {
        list1.add(0, "cat");
        list1.add(1, "dog");
        list1.add(2, "fish");
        list1.add(3, "rabbit");
        list1.add(2, "puppy");
        assertEquals(5, list1.size());
        assertEquals("puppy", list1.get(2));
        assertEquals("fish", list1.get(3));
    }

    /**
     * Test of removeAt method, of class ObjectLinkedList.
     */
    @Test
    public void testRemoveAt() {
        testAdd();
        list1.removeAt(0);
        assertEquals(4, list1.size());
    }

    /**
     * Test of remove method, of class ObjectLinkedList.
     */
    @Test
    public void testRemove() {
        testAdd();
        list1.remove("cat");
        assertEquals(4, list1.size());
    }

    /**
     * Test of get method, of class ObjectLinkedList.
     */
    @Test
    public void testGet() {
        testAdd();
        assertEquals("cat", list1.get(0));
    }

    /**
     * Test of find method, of class ObjectLinkedList.
     */
    @Test
    public void testFind() {
        testAdd();
        assertEquals(0, list1.find("cat"));
    }
    
}
