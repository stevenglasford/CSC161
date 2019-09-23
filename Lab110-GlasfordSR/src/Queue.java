/**
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwater
 * @author Steven Glasford
 * @version 2-21-2019
 * @param <E>
 */

public interface Queue<E> {
    /**
     * Returns the number of elements in the queue
     * @return
     */
    int size();

    /**
     * Tests whether the queue is empty
     * @return
     */
    boolean isEmpty();

    /**
     * Inserts an element at the rear of the queue
     * @param e
     * @todo    modify so that this is required to throw a queue Full Exception
     *          if called on a full queue
     */
    void enqueue(E e);

    /**
     * returns, but does not remove, the first element of the queue
     * (null if empty).
     * @return
     */
    E first();

    /**
     * Removes and returns the first element of the queue (null if empty)
     * @return
     */
    E dequeue();
}
