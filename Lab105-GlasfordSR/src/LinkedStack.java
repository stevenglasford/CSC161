/**
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwater
 * @author Steven Glasford
 * @version 2-21-2019
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {
    //an empty list
    private final SinglyLinkedList<E> list = new SinglyLinkedList<>();

    //new stack relies on the initially empty list
    public LinkedStack() {}

    @Override
    public int size() {return list.size();}

    @Override
    public boolean isEmpty() {return list.isEmpty();}

    @Override
    public void push(E element) { list.addFirst(element); }

    @Override
    public E top() { return list.first(); }

    @Override
    public E pop() { return list.removeFirst(); }
}
