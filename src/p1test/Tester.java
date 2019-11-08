package p1test;

import numberlist.objectlist.Complex;
import numberlist.objectlist.Money;
import numberlist.objectlist.ObjectArrayList;
import numberlist.objectlist.ObjectLinkedList;
import numberlist.primitivelist.IntegerArrayList;
import numberlist.primitivelist.RealArrayList;

/**
 *
 * @author Linda
 */
public class Tester {
    
    public static void main(String[] args) {
        try {
            testMoney();
        } catch (Exception ex) {
            System.out.println("MONEY TEST THREW EXCEPTION");
        }
        try {
            testMoney2();
        } catch (Exception ex) {
            System.out.println("MONEY TEST 2 THREW EXCEPTION");
        }
        try {
            testComplex();
        } catch (Exception ex) {
            System.out.println("COMPLEX TEST THREW EXCEPTION");
        }
        try {
            testObjectArrayList();
        } catch (Exception ex) {
            System.out.println("OBJECT ARRAY LIST TEST THREW EXCEPTION");
        }
        try {
            testObjectLinkedList();
        } catch (Exception ex) {
            System.out.println("OBJECT LINKED LIST THREW EXCEPTION");
        }
        try {
            testIntegerArrayList();
        } catch (Exception ex) {
            System.out.println("INTEGER ARRAY LIST THREW EXCEPTION");
        }
        try {
            testRealArrayList();
        } catch (Exception ex) {
            System.out.println("REAL ARRAY LIST THREW EXCEPTION");
        }
     }
    
    public static void testMoney() throws Exception {
        Money m1 = new Money(12L, (byte)50);
        Money m2 = new Money(14L, (byte)75);
        System.out.println("MONEY TEST WITH BOTH NEGATIVE");
        System.out.println(m1);
        System.out.println("getDollars: " + (m1.getDollars() == 12));
        System.out.println("getCents: " + (m1.getCents() == 50));
        Money m3 = m1.add(m2);
        System.out.println("addDollars: " + (m3.getDollars() == 27));
        System.out.println("addCents: " + (m3.getCents() == 25));
        Money m4 = m1.subtract(m2);
        System.out.println("subtractDollars: " + (m4.getDollars() == -2));
        System.out.println("subtractCents: " + (m4.getCents() == -25));
        Money m5 = new Money(12L, (byte)50);
        System.out.println("compareEquals: " + (m1.compareTo(m5) == 0));
        System.out.println("compareLess: " + (m1.compareTo(m2) < 0));
        System.out.println("compareGreater: " + (m2.compareTo(m1) > 0));
        Money m6 = (Money)m1.deepCopy();
        System.out.println("compareDeepCopy: " + (m1.compareTo(m6) == 0));
        System.out.println("equalsDeepCopy: " + (m1 != m6));
    }
    
    public static void testMoney2() throws Exception {
        Money m1 = new Money(12L, (byte)50);
        Money m2 = new Money(14L, (byte)75);
        System.out.println("MONEY TEST WITH DOLLARS NEGATIVE");
        System.out.println(m1);
        System.out.println("getDollars: " + (m1.getDollars() == 12));
        System.out.println("getCents: " + (m1.getCents() == 50));
        Money m3 = m1.add(m2);
        System.out.println("addDollars: " + (m3.getDollars() == 27));
        System.out.println("addCents: " + (m3.getCents() == 25));
        Money m4 = m1.subtract(m2);
        System.out.println("subtractDollars: " + (m4.getDollars() == -2));
        System.out.println("subtractCents: " + (m4.getCents() == 25));
        Money m5 = new Money(12L, (byte)50);
        System.out.println("compareEquals: " + (m1.compareTo(m5) == 0));
        System.out.println("compareLess: " + (m1.compareTo(m2) < 0));
        System.out.println("compareGreater: " + (m2.compareTo(m1) > 0));
        Money m6 = (Money)m1.deepCopy();
        System.out.println("compareDeepCopy: " + (m1.compareTo(m6) == 0));
        System.out.println("equalsDeepCopy: " + (m1 != m6));
    }
    
    public static void testComplex() throws Exception {
        Complex c1 = new Complex(12.5, 5.0);
        Complex c2 = new Complex(14.0, 7.5);
        System.out.println("COMPLEX TEST");
        System.out.println(c1);
        System.out.println("getReal: " + (c1.getReal() == 12.5));
        System.out.println("getImaginary: " + (c1.getImaginary() == 5.0));
        Complex c3 = c1.add(c2);
        System.out.println("addReal: " + (c3.getReal() == 26.5));
        System.out.println("addImaginary: " + (c3.getImaginary() == 12.5));
        Complex c4 = c1.subtract(c2);
        System.out.println("subtractReal: " + (c4.getReal() == -1.5));
        System.out.println("subtractImaginary: " + (c4.getImaginary() == -2.5));
        Complex c5 = new Complex(12.5, 5.0);
        System.out.println("compareEquals: " + (c1.compareTo(c5) == 0));
        System.out.println("compareLess: " + (c1.compareTo(c2) < 0));
        System.out.println("compareGreater: " + (c2.compareTo(c1) > 0));
        Complex c6 = (Complex)c1.deepCopy();
        System.out.println("compareDeepCopy: " + (c1.compareTo(c6) == 0));
        System.out.println("equalsDeepCopy: " + (c1 != c6));
    }
    
    public static void testObjectArrayList() throws Exception {
        ObjectArrayList l1 = new ObjectArrayList();
        System.out.println("OBJECT ARRAY LIST TEST");
        System.out.println("emptySize: " + (l1.size() == 0));
        l1.add(0, new Complex(1, 1));
        System.out.println("addGoodIndex: " + (l1.size() == 1));
        l1.add(2, new Complex(1, 1));
        System.out.println("addBadIndex: " + (l1.size() == 1));
        Complex c2 = new Complex(2, 2);
        l1.add(0, c2);
        System.out.println("findCorrectly: " + (l1.find(c2) == 0));
        ObjectArrayList l2 = (ObjectArrayList)l1.deepCopy();
        System.out.println("originalSize: " + (l1.size() == 2));
        System.out.println("deepCopySize: " + (l2.size() == 2));
        System.out.println("compareEquals: " + (((Complex)(l1.get(0))).compareTo(c2) == 0));
        System.out.println("compareDeepCopy: " + ((((Complex)l1.get(0)).compareTo((Complex)l2.get(0))) == 0));
        System.out.println("deepCopyObject: " + (((Complex)l1.get(0)) != ((Complex)l2.get(0))));
        l1.removeAt(1);
        System.out.println("removeAtSize: " + (l1.size() == 1));
        l1.remove(c2);
        System.out.println("removeSize: " + (l1.size() == 0));
        System.out.println(l2);    
        ObjectArrayList l3 = new ObjectArrayList();
        for (int i = 0; i < 100; i++) {
            l3.add(i, new Complex(i,i));
        }
        System.out.println("growing: " + (l3.size() == 100));
    }
    
    public static void testObjectLinkedList() throws Exception {
        ObjectLinkedList l1 = new ObjectLinkedList();
        System.out.println("OBJECT LINKED LIST TEST");
        System.out.println("emptySize: " + (l1.size() == 0));
        l1.add(0, new Complex(1, 1));
         System.out.println("addGoodIndex: " + (l1.size() == 1));
        l1.add(2, new Complex(1, 1));
        System.out.println("addBadIndex: " + (l1.size() == 1));
        Complex c2 = new Complex(2, 2);
        l1.add(0, c2);
        System.out.println("findCorrectly: " + (l1.find(c2) == 0));
        System.out.println("originalSize: " + (l1.size() == 2));
        ObjectLinkedList l2 = (ObjectLinkedList)l1.deepCopy();
        System.out.println("deepCopySize: " + (l2.size() == 2));
        System.out.println("compareEquals: " + ( ( (Complex)(l1.get(0)) ).compareTo(c2) == 0));
        System.out.println("compareDeepCopy: " + ((((Complex)l1.get(0)).compareTo((Complex)l2.get(0))) == 0));
        System.out.println("deepCopyObject: " + (((Complex)l1.get(0)) != ((Complex)l2.get(0))));
        l1.removeAt(1);
        System.out.println("removeAtSize: " + (l1.size() == 1));
        l1.remove(c2);
        System.out.println("removeSize: " + (l1.size() == 0));
        System.out.println(l2);
    }
    
    public static void testIntegerArrayList() throws Exception {
        IntegerArrayList l1 = new IntegerArrayList();
        System.out.println("INTEGER ARRAY LIST TEST");
        System.out.println("emptySize: " + (l1.size() == 0));
        l1.add(1);
        System.out.println("add: " + (l1.size() == 1));
        System.out.println("get: " + (l1.get(0) == 1));
        l1.add(0, 2);
        System.out.println("addAt: " + (l1.size() == 2));
        System.out.println("find: " + (l1.find(2) == 0));
        System.out.println("find: " + (l1.find(1) == 1));
        l1.add(0, 1);
        System.out.println("findLast: " + (l1.findLast(1) == 2));
        System.out.println(l1);
        System.out.println("size: " + (l1.size() == 3));
        l1.removeAt(1);
        System.out.println("removeAt: " + (l1.size() == 2));
        l1.add(3);
        l1.add(4);
        System.out.println("add2More: " + (l1.size() == 4));
        l1.remove(12);
        System.out.println("removeBadValue: " + (l1.size() == 4));
        l1.removeAt(12);
        System.out.println("removeBadIndex: " + (l1.size() == 4));
        l1.remove(4);
        System.out.println("removeGoodValue: " + (l1.size() == 3));
        l1.removeAll(1);
        System.out.println("removeAll: " + (l1.size() == 1));
        IntegerArrayList l2 = new IntegerArrayList();
        for (int i = 0; i < 100; i++) {
            l2.add(i, i);
        }
        System.out.println("growing: " + (l2.size() == 100));
    }
    
    public static void testRealArrayList() throws Exception {
        RealArrayList l1 = new RealArrayList();
        System.out.println("REAL ARRAY LIST TEST");
        System.out.println("emptySize: " + (l1.size() == 0));
        l1.add(1.1);
        System.out.println("add: " + (l1.size() == 1));
        System.out.println("get: " + (l1.get(0) == 1.1));
        l1.add(0, 2.2);
        System.out.println("addAt: " + (l1.size() == 2));
        System.out.println("find: " + (l1.find(2.2) == 0));
        System.out.println("find: " + (l1.find(1.1) == 1));
        l1.add(0, 1.1);
        System.out.println("findLast: " + (l1.findLast(1.1) == 2));
        System.out.println(l1);
        System.out.println("size: " + (l1.size() == 3));
        l1.removeAt(1);
        System.out.println("removeAt: " + (l1.size() == 2));
        l1.add(3.3);
        l1.add(4.4);
        System.out.println("add2More: " + (l1.size() == 4));
        l1.remove(12);
        System.out.println("removeBadValue: " + (l1.size() == 4));
        l1.removeAt(12);
        System.out.println("removeBadIndex: " + (l1.size() == 4));
        l1.remove(4.4);
        System.out.println("removeGoodValue: " + (l1.size() == 3));
        l1.removeAll(1.1);
        System.out.println("removeAll: " + (l1.size() == 1));
        RealArrayList l2 = new RealArrayList();
        for (int i = 0; i < 100; i++) {
            l2.add(i, i);
        }
        System.out.println("growing: " + (l2.size() == 100));
    }
    
}
