/**
 * A class of the form LuckyNumber.
 * @author Steven Glasford
 * @version 2-26-2019
 */
public class LuckyNumber {
    String name = null;
    int luckyNumber;

    /**
     * Constructor of the piece of shit.
     * @param name  A name to be inserted
     */
    LuckyNumber(String name) {
        //get the name from the constructor
        this.name = name;
        //randomly get a number between 0 and 9 inclusively
        luckyNumber = (int) (Math.random() * 10);
    }

    /**
     * Get the name out of the class.
     * @return the name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the luckyNumber out of the class.
     * @return The Lucky Number
     */
    public int getLuckyNumber(){
        return luckyNumber;
    }

    /**
     * Convert the information in the class to a string.
     * @return the string of information contained in the luckyNumber class.
     */
    public String toString(){
        return getName() + "\t\t" + getLuckyNumber();
    }

    /**
     * Determine if the number contained in the LuckyNumber class is a prime.
     * @return  Whether the number is a prime number.
     */
    public boolean isPrime() {
            return ((luckyNumber == 2) ||
                (luckyNumber == 3) ||
                (luckyNumber == 5) ||
                (luckyNumber == 7));
    }

    /**
     * Determine if the number is a prime.
     * @return Whether or not the number is even
     */
    public boolean isEven() {
        return ((luckyNumber % 2) == 0);
    }
}
