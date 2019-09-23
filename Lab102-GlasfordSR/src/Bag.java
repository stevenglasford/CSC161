/**
 *
 * @author Steven Glasford
 * 
 * The interface file for the program, methods can be found in the Scores class
 */

public interface Bag {
    public int getCurrentSize();
    public boolean isEmpty();
    public void add (int num);
    public void remove (int num);
    public void remove( );
    public void clear( );
    public int getFrequencyOf(int num);
    public boolean contains(int num);
    public String toString( );
    public boolean equals(Object o);
}
