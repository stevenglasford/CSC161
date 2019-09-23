/**
 * A collection of objects that are inserted and removed according to the
 * last-in first-out principle; although similar in purpose, this
 * interface differs from "java.util.Stack"
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwater
 *
 * @version 2-21-2019s
 */
public interface Stack<E> {
    /**
     * Returns the number of elements in the stack
     * @return number of elements in the stack
     */
    int size();

    /**
     * Tests whether the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Inserts an element at the top of the stack
     * @param e the element to be inserted
     * @todo    modify so this method is required to trow a Stack Full
     *          exception if called on a full stack
     */
    void push(E e);

    /**
     * Returns, but does not remove , the element at the top of the stack
     * @return to element in the stack (or null if empty)
     */
    E top();

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    E pop();
}
