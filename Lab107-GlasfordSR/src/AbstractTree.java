
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * An abstract base class providing some functionality of the Tree interface.
 * @author      Steven Glasford, Goodrick, Tamassia, Goldwasser
 *              Data Structures & Algorithms 6th Edition.
 * @param   <E> A generic parameter
 */
public abstract class AbstractTree<E> implements Tree<E> {
    /**
     * Determine if the node that is being tested is an internal
     * component.
     * @param p The node you want to determine if it is an internal
     *          component.
     * @return  true or false depending on whether or not the test node
     *          is an internal component.
     */
    @Override
    public boolean isInternal(Position<E> p) {return numChildren(p) > 0;}

    /**
     * Determine if a node is an external component, if it is a leaf.
     * @param p The node you want to test.
     * @return  True or false dependent on the conditions.
     */
    @Override
    public boolean isExternal(Position<E> p) {return numChildren(p) == 0;}

    /**
     * Determine if a node is a Root (like my car insurance).
     * @param p The node you want to test.
     * @return  True or false, depending on if the node is a root.
     */
    @Override
    public boolean isRoot(Position<E> p) {return p == root();}

    /**
     * Determine if a tree is empty.
     * @return  True or false, depending on if the tree is empty.
     */
    @Override
    public boolean isEmpty() {return size() == 0;}

    /**
     * Returns the number of levels separating Position p from the root.
     * @param p The node you want to test at.
     * @return  The number of levels separating Position p from the root.
     */
    public int depth(Position<E> p) {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }

    /**
     * Returns the height of the tree.
     * Works, but has quadratic worst-case time.
     * @return the height of the tree.
     */
    private int heightBad(){
        int h = 0;
        for (Position<E> p : positions())
            //only consider leaf positions
            if (isExternal(p))
                h = Math.max(h, depth(p));
        return h;
    }

    /**
     * Returns the height of the subtree rooted at Position p.
     * @param p The node you are testing from.
     * @return  the height of the tree
     */
    public int height(Position<E> p){
        //base case if p is external
        int h = 0;
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }

    /**
     * This class adapts the iteration produced by positions() to return
     * elements.
     */
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = positions().iterator();
        @Override
        public boolean hasNext() {return posIterator.hasNext();}
        //return element
        @Override
        public E next() {return posIterator.next().getElement();}
        @Override
        public void remove() {posIterator.remove();}
    }

    /**
     * Returns an iterator of the elements stored in the tree.
     * @return an iterator of the elements stored in the tree.
     */
    @Override
    public Iterator<E> iterator() {return new ElementIterator();}

    /**
     * defining the preorder as the default traversal algorithm for the
     * public positions method of an abstract tree.
     * @return
     */
    @Override
    public Iterable<Position<E>> positions() {return preorder();}

    /**
     * Adds positions of the subtree rooted at Position p to the given
     * snapshot.
     * @param p         A position to be investigated
     * @param snapshot  by Progressive.
     */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        //for preorder, we add position p before exploring subtrees
        snapshot.add(p);
        for(Position<E> c : children(p))
            preorderSubtree(c,snapshot);
    }

    /**
     * Returns an iterable collection of positions of the tree,
     * reported in preorder.
     * @return  an iterable collection of positions of the tree,
     *          reported in preorder.
     */
    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if (isEmpty())
            //fill the snapshot recursively
            preorderSubtree(root(), snapshot);
        return snapshot;
    }

    /**
     * Adds positions of the subtree rooted at Position p to the
     * given snapshot
     * @param p         The position of the subtree
     * @param snapshot  by progressive
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
        for (Position<E> c : children(p))
            postorderSubtree(c,snapshot);
        //for postorder, we add position p after exploring subtrees
        snapshot.add(p);
    }

    /**
     * Returns an iterable collection of positions of the tree,
     * reported in postorder.
     * @return  an iterable collection of positions of the tree,
     *          reported in postorder.
     */
    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            //fill the snapshot recursively
            postorderSubtree(root(), snapshot);
        return snapshot;
    }

    /**
     * Returns an iterable collection of positions of the tree in
     * breadth-first order.
     * @return  an iterable collection of positions of the tree in
     *          breadth-first order.
     */
    public Iterable<Position<E>> breadthfirst(){
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            //start with the root
            fringe.enqueue(root());
            while (!fringe.isEmpty()) {
                //remove from the front of the queue
                Position<E> p = fringe.dequeue();
                //report this position
                snapshot.add(p);
                for (Position<E> c : children(p))
                    //add children to the back of the queue
                    fringe.enqueue(c);
            }
        }
        return snapshot;
    }
}
