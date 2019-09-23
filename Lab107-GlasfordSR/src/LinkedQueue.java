/**
 * Realization of a FIFO queue as an implementation of a SinglyLinkedSet.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwater
 * @author Steven Glasford
 * @version 2-21-2019
 * @param <E>
 */


public class LinkedQueue<E> implements Queue<E> {
    //an empty list
    private final SinglyLinkedList<E> list = new SinglyLinkedList<>();
    //new queue relies on the initially empty list
    public LinkedQueue() {}

    @Override
    public int size() {return list.size();}

    @Override
    public boolean isEmpty() {return list.isEmpty();}

    @Override
    public void enqueue(E element) {list.addLast(element);}

    @Override
    public E first() {return list.first();}

    @Override
    public E dequeue() {return list.removeFirst();}

}
