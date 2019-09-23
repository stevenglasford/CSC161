/**
 * A simplified version of the "java.util.List" interface
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwater
 * @author Steven Glasford
 * @version 2-21-2019
 * @param <E>
 */

public interface List<E> {
    /**
     * Returns the number of elements in this list.
     * @return
     */
    int size();

    /**
     * Returns whether the list is empty
     * @return
     */
    boolean isEmpty();

    /**
     * Returns (but does not remove) the element at index i.
     * @param i
     * @return
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Replaces the element at index i with e, and returns the replaced
     * element.
     * @param i
     * @param e
     * @return
     */
    E set(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Inserts element e to be at index i, shifting all subsequent
     * elements later.
     * @param i
     * @param e
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Removes/returns the element at index i, shifting subsequent
     * elements earlier.
     * @param i
     * @return
     */
    E remove(int i) throws IndexOutOfBoundsException;
}

