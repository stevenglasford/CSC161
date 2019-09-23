 /**
 *
 * @author Steven Glasford
 * 
 * The interface file for the program, methods can be found in the Scores class
 */

public interface Bag<E> {
    /**
     * 
     * @return return the current size of the bag
     */
    public int getCurrentSize();
    /**
     * 
     * @return whether or not the bag is empty
     */
    public boolean isEmpty();
    /**
     * 
     * @param thing a generic object that you want to add to the bag 
     */
    public void add (Object thing);
    /**
     * 
     * @param thing the object that you want to remove from the bag
     * @return whether or not the item was removed from the bag
     */
    public boolean remove (Object thing);
    /**
     * 
     * @return the object that was removed
     */
    public E remove( );
    /**
     * Used to destroy a bag
     */
    public void clear( );
    /**
     * 
     * @param thing the item that is being searched for in the bag
     * @return the number of times the object was found in the bag
     */
    public int getFrequencyOf(Object thing);
    /**
     * 
     * @param thing a generic object that you are searching for in the bag
     * @return true if the item is in the bag, false if not
     */
    public boolean contains(Object thing);
    /**
     * 
     * @return The contents of the bag as a string
     */
    public String toString( );
    /**
     * 
     * @param o a generic object 
     * @return whether the objects are equal
     */
    public boolean equals(Object o);
}
