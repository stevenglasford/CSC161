
import java.util.ArrayList;
import java.util.List;

/**
 * An abstract base class providing some functionality of the BinaryTree
 * Interface.
 * @author      Steven Glasford, Goodrick, Tamassia, Goldwasser
 *              Data Structures & Algorithms 6th Edition
 * @version     3-5-2019
 * @param   <E> A generic parameter
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E>
    implements BinaryTree<E> {

    /**
     * Returns the Position of p s sibling (or null if no sibling exists).
     * @param p The position of the other sibling for a node.
     * @return  The position of the sibling.
     */
    @Override
    public Position<E> sibling(Position<E> p){
        Position<E> parent = parent(p);
        //p must be the root
        if(parent == null) return null;
        //p is a left child
        if (p == left(parent))
            //(right child might be null)
            return right(parent);
        //p is a right child
        else
            //(left child might be null)
            return left(parent);
    }

    /**
     * Returns the number of children of Position p.
     * @param p The node you are testing for.
     * @return  The number of children for a particular node, in int.
     */
    @Override
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null)
            count++;
        if (right(p) != null)
            count++;
        return count;
    }

    /**
     * Returns an iterable collection of the Positions representing p children.
     * @param p The position you want to mess around with.
     * @return  The iterable collection of the Positions representing
     *          p children.
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        //max capacity of 2
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null)
            snapshot.add(left(p));
        if (right(p) != null)
            snapshot.add(right(p));
        return snapshot;//by progressive
    }

    /**
     * Adds positions of the subtree rooted at Position p to the
     * given snapshot.
     * @param p         The position to begin with.
     * @param snapshot  The lists of positions in which the thing is located.
     */
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot){
        if (left(p) != null)
            inorderSubtree(left(p),snapshot);
        snapshot.add(p);
        if (right(p) != null)
            inorderSubtree(right(p),snapshot);
    }

    /**
     * Returns an iterable collection of positions of the tree, reported
     * in inorder.
     * @return an iterable collection of positions of the tree, reported
     * in inorder.
     */
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            //fill the snapshot recursively
            inorderSubtree(root(),snapshot);
        return snapshot;
    }

    /**
     * Overrides positions to make inorder the default for binary trees.
     * @return an inorder operator.
     */
    @Override
    public Iterable<Position<E>> positions(){
        return inorder();
    }
}
