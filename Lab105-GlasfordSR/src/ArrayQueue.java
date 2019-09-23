/**
 * Implementation of the queue ADT using a fixed-length array
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwater
 * @author Steven Glasford
 * @version 2-21-2019
 * @param <E>
 * @todo figure out why the CAPACITY thing doesn't work
 */
public class ArrayQueue<E> implements Queue<E>{
    //instance variables
        //generic array used for storage
    private E[] data;
    //index of the front element
    private int f = 0;
    //current number of elements
    private int sz = 0;
    //default array capacity
    public static final int CAPACITY = 1000;

    //constructors
        //constructs queue with given default capacity
    public ArrayQueue() {this(CAPACITY);}
    //constructs queue with given capacity
    public ArrayQueue(int capacity){
        data = (E[]) new Object[capacity];
    }

    //methods

    /**
     * Returns the number of elements in the queue.
     */
    public int size() {return sz;}

    /**
     * Tests whether the queue is empty.
     */
    public boolean isEmpty() {return (sz == 0);}

    /**
     * Inserts an element at the rear of the queue.
     */
    public void enqueue(E e) throws IllegalStateException {
        if (sz == data.length) throw new IllegalStateException("Queue is full");
        //use modular arithmetic
        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }

    /**
     * Returns, but does not remove, the first element of the queue
     * (null if empty).
     */
    public E first() {
        if (isEmpty()) return null;
        return data[f];
    }

    /**
     * Removes and returns the first element of the queue (null if empty).
     */
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[f];
        //derefence to help garbage colection
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
}
