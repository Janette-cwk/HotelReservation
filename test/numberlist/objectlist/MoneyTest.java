package numberlist.objectlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wai Kwan Chow
 */
public class MoneyTest {
    Money money1, money2;
    
    @Before
    public void setUp() {
        money1 = new Money(12,(byte)50);
        money2 = new Money(-12, (byte)-50);
    }
    
    /**
     * Test of add method, of class Money.
     */
    @Test
    public void testAdd() {
        Money total = money1.add(money2);
        assertEquals(0, total.getDollars());
        assertEquals(0, total.getCents());
    }

    /**
     * Test of subtract method, of class Money.
     */
    @Test
    public void testSubtract() {
        Money total = money1.subtract(money2);
        assertEquals(25, total.getDollars());
        assertEquals(0, total.getCents());
    }

    /**
     * Test of compareTo method, of class Money.
     */
    @Test
    public void testCompareTo() {
        int difference = money1.compareTo(money2);
        assertEquals(1, difference);
    }

    
    
    
}
