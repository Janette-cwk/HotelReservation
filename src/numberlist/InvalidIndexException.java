package numberlist;

/**
 * This class represents an Invalid Index Exception.
 *
 * @author Wai Kwan Chow
 */
public class InvalidIndexException extends Exception {

    private int low;
    private int high;
    private int currentIndex;

    /**
     * Full constructor
     *
     * @param message the message of invalid index error
     * @param low the lowest index
     * @param high the highest index
     * @param currentIndex the current index
     */
    public InvalidIndexException(String message, int low, int high,
            int currentIndex) {
        super(message);
        this.low = low;
        this.high = high;
        this.currentIndex = currentIndex;
    }

    /**
     * This method gets the lowest index
     *
     * @return the lowest index
     */
    public int getLow() {
        return low;
    }

    /**
     * This method gets the highest index
     *
     * @return the highest index
     */
    public int getHigh() {
        return high;
    }

    /**
     * This method gets the current index
     *
     * @return the current index
     */
    public int getCurrentIndex() {
        return currentIndex;
    }

}
