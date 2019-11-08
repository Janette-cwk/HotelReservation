package numberlist.objectlist;

/**
 * This class represents the uncopiable exception.
 *
 * @author Wai Kwan Chow
 */
public class UncopiableException extends Exception {

    /**
     * This method throws the uncopiable exception
     *
     * @param message the message of uncopiable error
     */
    public UncopiableException(String message) {
        super(message);
    }
}
