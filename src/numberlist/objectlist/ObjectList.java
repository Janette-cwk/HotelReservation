package numberlist.objectlist;

/**
 * This class represents an Object List.
 *
 * @author Wai Kwan Chow
 * @version 1.0 2/3/2017
 */
abstract class ObjectList {

    int count;

    abstract void add(int index, Object obj);

    abstract void removeAt(int index);

    abstract void remove(Object obj);

    abstract Object get(int index);

    abstract int find(Object obj);

    /**
     * This method represents the size of the list
     *
     * @return the count
     */
    public int size() {
        return count;
    }
}
