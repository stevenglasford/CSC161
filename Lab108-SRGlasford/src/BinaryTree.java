/**
 * An interface for a binary tree, in which each node has at most two children.
 * @author      Steven Glasford, Goodrick, Tamassia, Goldwasser
 *              Data Structures & Algorithms 6th Edition
 * @version     3-5-2019
 * @param   <E> A generic parameter.
 */
public interface BinaryTree<E> extends Tree<E> {
    /**
     * Returns the Position of p s left child (or null if no child exists).
     * @param p The position you want to find the left child for.
     * @return  The position of the left child from an input position.
     * @throws IllegalArgumentException If the node doesnt exist.
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position of p s right child (or null if no child exists).
     * @param p The position of the parent node.
     * @return  The position of the right child.
     * @throws IllegalArgumentException If the input position doesnt exist.
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position of p s sibling (or null if no sibling exists).
     * @param p The node you want to find its sibling for.
     * @return  The position of the other sibling.
     * @throws IllegalArgumentException If the input position doesnt exist.
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
