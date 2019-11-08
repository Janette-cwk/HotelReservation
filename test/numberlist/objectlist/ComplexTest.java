package numberlist.objectlist;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wai Kwan Chow
 */
public class ComplexTest {

    Complex c1, c2, c3, c4;

    @Before
    public void setUp() {
        c1 = new Complex(-5, -1);
        c2 = new Complex(0.5, 5);
        c3 = new Complex(12.5, 5.0);
        c4 = new Complex(14.0, 7.5);
    }

    /**
     * Test of add method, of class Complex.
     */
    @Test
    public void testAdd() {
        Complex total = c1.add(c2);
        assertEquals(-4.5, total.getReal(), 0);
        assertEquals(4, total.getImaginary(), 0);
    }

    /**
     * Test of subtract method, of class Complex.
     */
    @Test
    public void testSubtract() {
        //Complex total = c1.subtract(c2);
        //assertEquals(5.5, total.getReal(), 0);
        //assertEquals(6, total.getImaginary(),0);
        Complex result = c3.subtract(c4);
        assertEquals(-1.5, result.getReal(), 0);
        assertEquals(-2.5, result.getImaginary(), 0);
    }

    /**
     * Test of compareTo method, of class Complex.
     */
    @Test
    public void testCompareTo() {
        int difference = c1.compareTo(c2);
        assertEquals(-1, difference);
    }
}
