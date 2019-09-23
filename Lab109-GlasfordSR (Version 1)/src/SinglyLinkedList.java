/**
 *
 * SinglyLinkedList Class
 * Code Fragments 3.14, 3.15
 * from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser
 * Wiley 2014
 * Transcribed by
 * @author Steven Glasford
 * @version January 31, 2019
 * @param <E> a generic placeholder name
 */
public class SinglyLinkedList<E> {
    /**
     * 
     * @param <E> a generic placeholder name
     * 
     * A subclass creating the Node
     */
    private static class Node<E>{
        //reference to the element stored at this node
        private final E element;              
        //reference to the subsequent node in the list
        private Node<E> next;          
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
        
        /**
         * 
         * @return Return the current element
         */
        public E getElement(){return element;}
        
        /**
         * 
         * @return return the address of the next item in the linked list
         */
        public Node<E> getNext() {return next;}
        
        /**
         * 
         * @param n the next item in the list
         */
        public void setNext(Node<E> n) {next = n;}    
    }
    
    //head node of the list (or null if empty)
    private Node<E> head = null;    
    //last node of the list (or null if empty)
    private Node<E> tail = null;    
    //number of nodes in the list
    private int count = 0;           
    
    /**
     * constructs an initially empty list
     */
    public SinglyLinkedList(){}    
    
    //access methods
    /**
     * 
     * @return Return the size of the linked list
     */
    public int size() {return count;}
    
    /**
     * 
     * @return Determine if the linked list is empty
     */
    public boolean isEmpty() {return count == 0;}
    
    /**
     * 
     * @return return the first element in the list
     * 
     * returns (but does not remove) the first element
     */
    public E first(){
        if (isEmpty()) return null;
        return head.getElement();
    }
    
    /**
     * 
     * @return the last element in the linked list
     * 
     * returns (but does not remove the last element
     */
    public E last(){
        if (isEmpty()) return null;
        return tail.getElement();
    }
    
    //update methods
    
    /**
     * 
     * @param e A generic element
     * 
     * adds element e to the front of the list
     */
    public void addFirst(E e){
        //create and link a new node
        head = new Node<>(e, head);
        //special case: new node becomes tail also
        if (count == 0)
            tail = head;
        count++;
    }
    
    /**
     * 
     * @param e A generic item
     * 
     * adds element e to the end of the list
     */
    public void addLast(E e) {
        //node will eventually be the tail
        Node<E> newest = new Node<>(e,null); 
        //special case: previously empty list
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        count++;
    }
    
    /**
     * 
     * @return return the item that was removed
     * 
     * removes and returns the first element
     */
    public E removeFirst(){
        //nothing to remove
        if (isEmpty()) return null;
        E answer = head.getElement();
        //will become null if list had only one node
        head = head.getNext();
        count--;
        //special case as list is now empty
        if(count == 0)
            tail = null;
        return answer;
    }
}
