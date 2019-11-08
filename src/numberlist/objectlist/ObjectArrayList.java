package numberlist.objectlist;

/**
 * This class represents an Object Array List
 *
 * @author Wai Kwan Chow
 * @version 1.0 2/3/2017
 */
public class ObjectArrayList extends ObjectList implements Copiable {

    private Object[] list;

    public ObjectArrayList() {
        list = new Object[10];
    }

    /**
     * Add a value to a particular index
     *
     * @param index the index
     * @param obj the object
     */
    @Override
    public void add(int index, Object obj) {
        if (index > count) {
            return;
        }
        if (count < list.length) {
            for (int i = 0; i < list.length; i++) {
                if (i == index) {
                    Object temp1 = list[i];
                    list[i] = obj;
                    for (int j = index + 1; j < list.length; j++) {
                        Object temp2 = list[j];
                        list[j] = temp1;
                        temp1 = temp2;
                    }
                }
            }
            count++;
        } else {
            Object[] newList = new Object[list.length * 2];
            for (int i = 0; i < list.length; i++) {
                newList[i] = list[i];
                if (i == index) {
                    newList[i] = obj;
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
    @Override
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
     * @param obj the object
     */
    @Override
    public void remove(Object obj) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == obj) {
                for (int j = i; j < list.length - 1; j++) {
                    list[j] = list[j + 1];
                }
            }
        }
        count--;
    }

    /**
     * Pulling out a value from the array
     *
     * @param index the index
     * @return the value of the specific index
     */
    @Override
    public Object get(int index) {
        if (index > count) {
            return null;
        } else {
            return list[index];
        }
    }

    /**
     * Find the index of the first instance of the value in the array
     *
     * @param obj the object
     * @return the index of the value
     */
    @Override
    public int find(Object obj) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == obj) {
                return i;
            }
        }
        return -1;
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
     * This method creates the deep copy of the object array list
     *
     * @return the copy of the list
     */
    @Override
    public ObjectArrayList deepCopy() {
        ObjectArrayList listCopy = new ObjectArrayList();
        for (int i = 0; i < size(); i++) {
            if (get(i) instanceof Copiable) {
                listCopy.add(i, ((Copiable) get(i)).deepCopy());
            }
        }
        return listCopy;
    }
    
    /**
     * This method sets the value in a specific index
     *
     * @param the index of the list and the value that I want to set
     */
    public void set(int index, Object value){
        if(index >= 0 && index < size()){
            list[index] = value;
        }
    }
}
