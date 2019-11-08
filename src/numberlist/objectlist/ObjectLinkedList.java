package numberlist.objectlist;

/**
 * This class represents an object linked list.
 *
 * @author Wai Kwan Chow
 * @version 1.0 2/5/2017
 */
public class ObjectLinkedList extends ObjectList implements Copiable {

    private Node firstNode;

    /**
     * This method adds the object at a particular index
     *
     * @param index the index
     * @param obj the object
     */
    @Override
    public void add(int index, Object obj) {
        if (index > count) {
            return;
        }
        Node newNode = new Node(obj);
        if (index == 0) {
            newNode.setNext(firstNode);
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
        count++;
    }

    /**
     *
     * This method removes the object at a particular index
     *
     * @param index the index
     */
    @Override
    public void removeAt(int index) {
        if (index > count) {
            return;
        } else {
            if (index == 0) {
                firstNode = firstNode.getNext();
            } else {
                Node currentNode = firstNode;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.getNext();
                }
                currentNode.setNext(currentNode.getNext().getNext());
            }
            count--;
        }
    }

    /**
     * This method remove the object
     *
     * @param obj the object
     */
    @Override
    public void remove(Object obj) {
        if (firstNode == null) {
            return;
        } else {
            removeAt(find(obj));
        }
    }

    /**
     * This method pulls out the value at a particular index
     *
     * @param index the index
     * @return the value of currentNode
     */
    @Override
    public Object get(int index
    ) {
        Node currentNode = firstNode;
        if (index > count) {
            return null;
        }
        if (index == 0) {
            currentNode = firstNode;
        } else {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
        }
        return currentNode.getValue();
    }

    /**
     * This method find a value in the list
     *
     * @param obj the object
     * @return the index or -1
     */
    @Override
    public int find(Object obj
    ) {
        int index = 0;
        if (firstNode == null) {
            return -1;
        }
        if(firstNode.getNext()== null){
            if (firstNode.getValue().equals(obj)) {
                return 0;
            }
        }
        Node currentNode = firstNode;
        while (currentNode.getNext() != null) {
            if (currentNode.getValue().equals(obj)) {
                return index;
            }
            index++;
            currentNode = currentNode.getNext();
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
        for (int i = 0; i < size() - 1; i++) {
            output += get(i) + ", ";
        }
        output += get(size() - 1) + "]";
        return output;
    }

    /**
     * This method make a copy of the list
     *
     * @return the copy
     */
    @Override
    public ObjectLinkedList deepCopy() {
        ObjectLinkedList listCopy = new ObjectLinkedList();
        for (int i = 0; i < size(); i++) {
            if(get(i) instanceof Copiable){
                listCopy.add(i,((Copiable)get(i)).deepCopy());
            }
        }
        return listCopy;
    }
}
