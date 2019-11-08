package numberlist.objectlist;

/**
 * This class represents a copy
 *
 * @author Wai Kwan Chow
 * @version 1.0 2/3/2017
 */
public interface Copiable {
    
    /**
     * Create a deep copy
     */
    public Copiable deepCopy();
}
