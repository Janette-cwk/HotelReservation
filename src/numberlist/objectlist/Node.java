package numberlist.objectlist;

/**
 * This class represents a node.
 *
 * @author Wai Kwan Chow
 * @version 1.0 2/3/2017
 */
public class Node {

    private Object obj;
    private Node nextNode;

    /**
     * Constructor
     *
     * @param obj the object
     */
    public Node(Object obj) {
        this.obj = obj;
    }

    /**
     * This method get the value of the object
     *
     * @return the object
     */
    public Object getValue() {
        return obj;
    }

    /**
     * This method get the next Node
     *
     * @return the nextNode
     */
    public Node getNext() {
        return nextNode;
    }

    /**
     * This method set the value of the object
     *
     * @param obj the object
     */
    public void setValue(Object obj) {
        this.obj = obj;
    }

    /**
     * This method set the next Node
     *
     * @param nextNode the next Node
     */
    public void setNext(Node nextNode) {
        this.nextNode = nextNode;
    }

}
