package numberlist.objectlist;

/**
 * This class represents complex numbers
 *
 * @author Wai Kwan Chow
 * @version 1.0 2/3/2017
 */
public class Complex implements Copiable, Comparable<Complex> {

    private double real;
    private double imaginary;

    public Complex() {
    }

    /**
     * Full constructor
     *
     * @param real the real number
     * @param imaginary the imaginary number
     */
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * This method gets the real numbers
     *
     * @return the real numbers
     */
    public double getReal() {
        return real;
    }

    /**
     * This method gets the imaginary numbers
     *
     * @return the imaginary numbers
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Add the complex numbers that we have and had together
     *
     * @param other the other complex number
     * @return the new total amount of complex number that we have now
     */
    public Complex add(Complex other) {
        double newReal = other.real + real;
        double newImaginary = other.imaginary + imaginary;
        return new Complex(newReal, newImaginary);
    }

    /**
     * Subtract the complex numbers that we have and had
     *
     * @param other the other complex number
     * @return the new total amount of complex number that we have now
     */
    public Complex subtract(Complex other) {
        double newReal = real - other.real;
        double newImaginary = imaginary - other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    /**
     * This method set up the println statement
     *
     * @return the statement
     */
    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }

    /**
     * This method creates a deep copy of complex number
     *
     * @return new Complex number
     */
    @Override
    public Complex deepCopy() {
        return new Complex(real, imaginary);
    }

    /**
     * This method compares two complex number
     *
     * @param complex the complex number
     * @return -1 or 0 or 1
     */
    @Override
    public int compareTo(Complex complex) {
        double thisTotal = this.imaginary + this.real;
        double complexTotal = complex.imaginary + complex.real;
        double difference = thisTotal - complexTotal;
        return difference > 0 ? 1 : difference < 0 ? -1 : 0;
    }
}
