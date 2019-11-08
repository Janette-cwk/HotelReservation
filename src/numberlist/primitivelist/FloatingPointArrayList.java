package numberlist.primitivelist;

/**
 * This class represents a Floating Point Array List
 *
 * @author Wai Kwan Chow
 * @version 1.0 2/3/2017
 */
class FloatingPointArrayList {

    private NumberArrayList list;

    public FloatingPointArrayList() {
        list = new NumberArrayList();
    }

    /**
     * Add a value to a particular index
     *
     * @param index the index
     * @param value the value
     */
    public void add(int index, double value) {
        list.add(index, Double.doubleToRawLongBits(value));
    }

    /**
     * Remove a value at a specific index
     *
     * @param index the index
     */
    public void removeAt(int index) {
        list.removeAt(index);
    }

    /**
     * Remove the first instance of the value
     *
     * @param value the value
     */
    public void remove(double value) {
        list.remove(Double.doubleToRawLongBits(value));
    }

    /**
     * Pulling out a value from the array
     *
     * @param index the index
     * @return the value of the specific index
     */
    public double get(int index) {
        return Double.longBitsToDouble(list.get(index));
    }

    /**
     * Find the index of the first instance of the value in the array
     *
     * @param value the value
     * @return the index of the value
     */
    public int find(double value) {
        return list.find(Double.doubleToRawLongBits(value));
    }

    /**
     * This represents the size of the array
     *
     * @return the count
     */
    public int size() {
        return list.size();
    }

    /**
     * This method set up the println statement
     *
     * @return the statement
     */
    @Override
    public String toString() {
        String output = "[ ";
        for (int i = 0; i < list.size() - 1; i++) {
            output += (Double.longBitsToDouble(list.get(i))) + ", ";
        }
        output += (Double.longBitsToDouble(list.get(list.size() - 1))) + "]";
        return output;
    }

}
