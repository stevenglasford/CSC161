/**
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwater
 * @author Steven Glasford
 * @version 2-21-2019
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    //default array capacity
    public static final int CAPACITY = 1000;
    //generic array used for storage
    private E[] data;
    //index of the top element in the stack
    private int t = -1;

    //constructs stack with default capacity
    public ArrayStack() {this(CAPACITY);}

    //constructs stack with given capacity
    public ArrayStack(int capacity){
        //safe cast; compiler may give warning
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {return (t+1);}

    @Override
    public boolean isEmpty() {return (t==-1);}

    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack "
                + "is full");
        //increment t before storing new item
        data[++t] = e;
    }

    @Override
    public E top(){
        if (isEmpty()) return null;
        return data[t];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        //dereference to help garbage collection
        data[t] = null;
        t--;
        return answer;
    }


}
