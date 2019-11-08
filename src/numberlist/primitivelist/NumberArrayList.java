package numberlist.primitivelist;

/**
 * This class represents a Number Array List.
 *
 * @author Wai Kwan Chow
 * @version 1.0 2/3/2017
 */
class NumberArrayList {

    private long[] list;
    private int count;

    public NumberArrayList() {
        list = new long[10];
    }

    /**
     * Add a value to a particular index
     *
     * @param index the index
     * @param value the value
     */
    public void add(int index, long value) {
        if (index > count) {
            return;
        }
        if (count < list.length) {
            for (int i = 0; i < list.length; i++) {
                if (i == index) {
                    long temp1 = list[i];
                    list[i] = value;
                    for (int j = index + 1; j < list.length; j++) {
                        long temp2 = list[j];
                        list[j] = temp1;
                        temp1 = temp2;

                    }
                }
            }
            count++;
        } else {
            long[] newList = new long[list.length * 2];
            for (int i = 0; i < list.length; i++) {
                newList[i] = list[i];
                if (i == index) {
                    newList[i] = value;
                    for (int j = i; j < list.length; j++) {
                        newList[j + 1] = list[j];
                    }
                }
            }
            count++;
        }
    }

    /**
     * Remove a value at a specific index
     *
     * @param index the index
     */
    public void removeAt(int index) {
        if (index > count) {
            return;
        }
        for (int i = index; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        count--;
    }

    /**
     * Remove the first instance of the value
     *
     * @param value the value
     */
    public void remove(long value) {
        for (int i = 0; i < count; i++) {
            if (list[i] == value) {
                this.removeAt(i);
            }
        }
    }

    /**
     * Pulling out a value from the array
     *
     * @param index the index
     * @return the value of the specific index
     */
    public long get(int index) {
        if (index > count) {
            return Long.MIN_VALUE;
        } else {
            return list[index];
        }
    }

    /**
     * Find the index of the first instance of the value in the array
     *
     * @param value the value
     * @return the index of the value
     */
    public int find(long value) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This represents the size of the array
     *
     * @return the count
     */
    public int size() {
        return count;
    }

    /**
     * This method set up the println statement
     *
     * @return the statement
     */
    @Override
    public String toString() {
        String output = "[ ";
        for (int i = 0; i < count - 1; i++) {
            output += list[i] + ", ";
        }
        output += list[count - 1] + "]";
        return output;
    }

    /**
     * This method sets the value in a specific index
     *
     * @param the index of the list and the value that I want to set
     */
    public void set(int index, long value) {
        if (index >= 0 && index < size()) {
            list[index] = value;
        }
    }

}
