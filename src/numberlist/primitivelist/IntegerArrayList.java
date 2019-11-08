package numberlist.primitivelist;

/**
 * This class represents an Integer Array List.
 *
 * @author Wai Kwan Chow
 * @version 1.0 2/3/2017
 */
public class IntegerArrayList extends NumberArrayList {

    /**
     * Add a value to a particular index
     *
     * @param value the value
     */
    public void add(long value) {
        this.add(size(), value);
    }

    /**
     * Remove all occurrence of the value in the array
     *
     * @param value the value
     */
    public void removeAll(long value) {
        int j = 0;
        while (j < super.size()) {
            super.find(value);
            super.remove(value);
            j++;
        }
    }

    /**
     * Find the last occurrence of the value in the array
     *
     * @param value the value
     * @return the index of the value if found, return -1 if not found
     */
    public int findLast(long value) {
        for (int i = this.size() - 1; i >= 0; i--) {
            if (this.get(i) == value) {
                return i;
            }
        }
        return -1;
    }

   
}
