
import java.util.Iterator;

/**
 * Concrete implementation of a binary tree using a node-based, linked
 * structure.
 * @author      Steven Glasford, Goodrick, Tamassia, Goldwasser
 *              Data Structures & Algorithms 6th Edition.
 * @version     3-5-2019
 * @param <E>   A generic parameter
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Position<E>> positions() {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }
    //------------------nested Node class------------------//
    /**
     * A commonality of all nodes in the tree, smells like potatoes.
     * @param <E>   A generic input parameter.
     */
    protected static class Node<E> implements Position<E> {
        //an element stored at this node.
        private E element;
        //a reference to the parent node (if any).
        private Node<E> parent;
        //a reference to the left child (if any).
        private Node<E> left;
        //a reference to the right child (if any).
        private Node<E> right;

        /**
         * Constructs a node with the given element and neighbors.
         * @param e             The element you want to add.
         * @param above         The parent of the new child.
         * @param leftChild     The left child of the new parent.
         * @param rightChild    The right child of the new parent.
         */
        public Node(E e, Node<E> above, Node<E> leftChild,
                Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        //******************* accessor methods **************************//

        /**
         * Gets element in the node out of protection.
         * @return  The data within the tree.
         */
        @Override
        public E getElement()       {return element;}

        /**
         * Gets the parent out of protections, assuming they are due on
         * alimony payments.
         * @return  The parent to the child, null if the root.
         */
        public Node<E> getParent()  {return parent;}

        /**
         * Get the left child out of protection.
         * @return  Return the node of the left child.
         */
        public Node<E> getLeft()    {return left;}

        /**
         * Get the right child out of protection.
         * @return  Return the node of the left child.
         */
        public Node<E> getRight()   {return right;}


        //***************** update methods ********************//

        /**
         * Set the element from outside of protection.
         * @param e The element you want to add to the node.
         */
        public void setElement(E e) {element = e;}

        /**
         * Set the nodes parent, like adoption.
         * @param parentNode    The parent node.
         */
        public void setParent(Node<E> parentNode) { parent = parentNode;}

        /**
         * Set the left Child of the node.
         * @param leftChild The left child you want to set.
         */
        public void setLeft(Node<E> leftChild) { left = leftChild; }

        /**
         * Set the right Child of the node.
         * @param rightChild    The right child that you want to set.
         */
        public void setRight(Node<E> rightChild) { right = rightChild; }
    } /////////////////////// end of nested Node class /////////////////////

    /**
     * Factory function to create a new node storing element e.
     * @param e         The element you want to create a node for.
     * @param parent    The parent of the new node you just made.
     * @param left      The first, left, child of the new node.
     * @param right     The second, right, child of the new node.
     * @return          The new node.
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left,
            Node<E> right){
        return new Node<>(e,parent,left,right);
    }

    ///////////////////LinkedBinaryTree instance variables///////////////////

    //root of the tree, protected like dirt.
    protected Node<E> root = null;
    //number of nodes in the tree
    private int size = 0;

    /**
     * Constructor, constructs an empty binary tree
     */
    public LinkedBinaryTree(){}

    ///////////////////////nonpublic utility////////////////////////////
    /**
     * Validates the position and returns it as a node.
     * @param p The position you want to create.
     * @return  The node from the position.
     * @throws  IllegalArgumentException If the position doesnt exist.
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        //safe cast
        Node<E> node = (Node<E>) p;
        //Our convention for defunct node
        if (node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    //////Accesor methods (not already implemented in AbstractBinaryTree)//////
    /**
     * Returns the number of nodes in the tree.
     * @return  An integer of the size of the tree.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the root Position of the tree (or null if tree is empty).
     * @return  The position of the root.
     */
    @Override
    public Position<E> root(){
        return root;
    }

    /**
     * Returns the Positions of p s parent (or null if p is root)
     * @param p The position you are testing from.
     * @return  The position of the parent.
     * @throws  IllegalArgumentException if the position doesnt exist.
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * Returns the Position of p s left child (or null if no child exists).
     * @param p The node you are trying to find the child for.
     * @return  The position of the left nodes left child.
     * @throws IllegalArgumentException if the position doesnt exist.
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    /**
     * Returns the Position of p s right child (or null if no child exists)
     * @param p The position you are trying to find the right child for.
     * @return  The position of the right child.
     * @throws IllegalArgumentException if the input position doesnt exist.
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    ///////////////update methods supported by this class///////////////////
    /**
     * Places element e at the root of an empty tree and returns
     * its new position.
     * @param e The element you want to be the root of the tree.
     * @return  The new position of the root of the tree.
     * @throws IllegalStateException    if the tree is not empty.
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /**
     * Creates a new left child of Position p storing element e;
     * returns its Position.
     * @param p The parent of the new child.
     * @param e The element you want to add to the new child.
     * @return  The position of the newly created left child.
     * @throws  IllegalArgumentException if the input position already
     *                                   has a child.
     */
    public Position<E> addLeft(Position<E> p, E e)
            throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if (parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e,parent,null,null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * Creates a new right child of Position p storing element e;
     * returns its Position.
     * @param p The parent of the new child.
     * @param e The element you want to add to the new child.
     * @return  The position of the new right child.
     * @throws IllegalArgumentException if the position already has a
     *                                  right child.
     */
    public Position<E> addRight(Position<E> p, E e)
            throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**
     * Replaces the element at Position p with e and returns the
     * replaced element
     * @param p The position in which you are changing the element data for.
     * @param e The element you want to set the data for.
     * @return  The element you set for the particular node.
     * @throws IllegalArgumentException if the position and node do not exist.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * Attaches trees t1 and t2 as left and right subtrees of external p.
     * @param p     The new parent of the two trees.
     * @param t1    The left part of the tree.
     * @param t2    The right part of the tree.
     * @throws IllegalArgumentException if one node doesnt exist.
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1,
            LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("p must"
                + " be a leaf");
        size += t1.size() + t2.size();
        //attach t1 as left subtree of node
        if (!t1.isEmpty()){
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }

        //attach t2 as right subtree of node
        if (!t2.isEmpty()){
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * Removes the node at Position p and replaces it with its child,
     * if any.
     * @param p The position of the node you want to remove.
     * @return  The element that once was stored in the element you
     *          just removed.
     * @throws IllegalArgumentException if the element doesn't exist.
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");
        Node<E> child = (node.getLeft() != null ? node.getLeft():
                node.getRight());
        if (child != null)
            //child s grandparent becomes its parent
            child.setParent(node.getParent());
        if (node == root)
            //child becomes root
            root = child;
        else{
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        //help garbage collection
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        //our convention for defunct node
        node.setParent(node);
        return temp;
    }

    /** Prints parenthesized representation of subtree of T rooted at p.
     * @param <E>
     * @param T
     * @param p
     */
    public static <E> void parenthesize(Tree<E> T, Position<E> p) {
        System.out.print(p.getElement( ));
        if (T.isInternal(p)) {
            boolean firstTime = true;
            for (Position<E> c : T.children(p)) {
                // determine proper punctuation
                System.out.print( (firstTime ? " (" : ", ") );
                // any future passes will get comma
                firstTime = false;
                // recur on child
                parenthesize(T, c);
            }
            System.out.print(")");
        }
    }

    /////////////////////end of LinkedBinaryTree class////////////////////////
}
