/**
 * Data Structures & Algorithms 6th Edition
 * Goodrick, Tamassia, Goldwasser
 * Code Fragments 7.2, 7.3, 7.4 and 7.5
 *
 * An implementation of a simple ArrayList class.
 * */
public class ArrayList<E> implements List<E> {
    //instance variables
        //default array capacity
    public static final int CAPACITY = 16;
    //generic array used for storage
    private E[] data;
    //current number of elements
    private int size = 0;

    //constructors
        //constructs list with default capacity
    public ArrayList() {this(CAPACITY);}
    //constructs list with given capacity
    public ArrayList(int capacity){
        //safe cast; compiler may give warning
        data = (E[]) new Object[capacity];
    }

    //public methods
    /**
     * Returns the number of elements in the array list.
     */
    @Override
    public int size() {return size;}

    /**
     * Returns whether the array list is empty.
     */
    @Override
    public boolean isEmpty() {return size == 0;}

    /**
     * Returns (but does not remove) the element at index i.
     */
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    /**
     * Replaces the element at index i with e, and returns the replaced
     * element.
     */
    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    /**
     * Inserts element e to be at index i, shifting all subsequent
     * elements later.
     */
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException,
            IllegalStateException {
        checkIndex(i, size + 1);
        //not enough capacity
        if (size == data.length)
            //so double the current capacity
            resize(2*data.length);
        //start by shifting rightmost
        for (int k = size - 1; k >= i; k--)
            data[k+1] = data[k];
        //ready to place the new element
        size++;
    }

    /**
     * Removes/returns the element at index i, shifting subsequent
     * elements earlier
     */
    @Override
    public E remove(int i) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        E temp = data[i];
        //shift elements to fill hole
        for (int k = i; k < size - 1; k++)
            data[k] = data[k+1];
        //help gargbage collection
        data[size-1] = null;
        size--;
        return temp;
    }

    //remove at the end of the thing
    public E remove(){
        return remove(size-1);
    }

    //add at the end of the thing
    public void add(E e){
        add(size,e);
    }

    //utility methods

    /**
     * Checks whether the given index is in the range [0, n-1].
     * @param i
     * @param n
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

    /**
     * Resizes internal array to have given capacity >= size.
     * @param capacity
     */
    protected void resize(int capacity){
        //safe cast; compiler may give warning
        E[] temp = (E[]) new Object[capacity];
        for (int k = 0; k < size; k++)
            temp[k] = data[k];
        //start using the new array
        data = temp;
    }

}
