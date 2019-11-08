package numberlist.objectlist;

/**
 * This class represents Money.
 *
 * @author Wai Kwan Chow
 * @version 1.0 2/3/2017
 */
public class Money implements Copiable, Comparable<Money> {

    private long dollars;
    private byte cents;

    /**
     * Default constructor
     */
    public Money() {
    }

    /**
     * Full constructor.
     *
     * @param dollars the dollar
     * @param cents the cents
     */
    public Money(long dollars, byte cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    /**
     * This method get the amount of dollars
     *
     * @return the dollars
     */
    public long getDollars() {
        return dollars;
    }

    /**
     * This method get the amount of cents
     *
     * @return the cents
     */
    public byte getCents() {
        return cents;
    }

    /**
     * Add the dollars and cents that we have and had together
     *
     * @param other the other Money 
     * @return the new total amount of money that we have now
     */
    public Money add(Money other) {
        long value = dollars * 100 + cents;
        long money = other.dollars * 100 + other.cents;
        long total = value + money;
        long newDollars = total / 100;
        long newCents = total - newDollars * 100;
        return new Money(newDollars, (byte) newCents);
    }

    /**
     * Subtract the dollars and cents that we have and had
     *
     * @param other the other Money
     * @return the new total amount of money that we have now
     */
    public Money subtract(Money other) {
        long value = dollars * 100 + cents;
        long money = other.dollars * 100 + other.cents;
        long total = value - money;
        long newDollars = total / 100;
        long newCents = total - newDollars * 100;
        return new Money(newDollars, (byte) newCents);
    }

    /**
     * This method set up the println statement
     *
     * @return the statement
     */
    @Override
    public String toString() {
        return "$" + dollars + "." + cents;
    }

    /**
     * This method creates a deep copy of money
     *
     * @return new Money
     */
    @Override
    public Money deepCopy() {
        return new Money(dollars, cents);
    }

    /**
     * This method compares two money amount
     *
     * @param money the money
     * @return -1 or 0 or 1
     */
    @Override
    public int compareTo(Money money) {
        long difference = 0;
        if (this.dollars != money.dollars) {
            difference = dollars - money.dollars;
        } else {
            difference = cents - money.cents;
        }

        return difference > 0 ? 1 : difference < 0 ? -1 : 0;
    }

}
