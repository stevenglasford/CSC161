
import java.util.Iterator;

/**
 * An interface for a tree where nodes can have an arbitrary number of children
 * @author      Steven Glasford, Goodrick, Tamassia, Goldwasser
 *              Data Structures & Algorithms 6th Edition
 * @version     3-5-2019
 * @param <E>   A generic parameter
 */

public interface Tree<E> extends Iterable<E> {
    /**
     * Make the root of the tree.
     * @return The root of the tree.
     */
    Position<E> root();

    /**
     * Make a parent of in the tree.
     * @param p The leaf you want to make into a parent.
     * @return A new parent node
     * @throws IllegalArgumentException If the node doesnt exist.
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     * Make a child, without any of the fun sex positions.
     * @param p
     * @return
     * @throws IllegalArgumentException if the node doesnt exist.
     */
    Iterable<Position<E>> children(Position<E> p)
            throws IllegalArgumentException;

    /**
     * Determine how many children a catholic has.
     * @param p The catholic you want to determine the number of children for.
     * @return  The number of children raped by the priest (all of them).
     * @throws IllegalArgumentException if the node doesn't exist.
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     * Determine if the node is an internal node within the tree.
     * @param p The node you want to test.
     * @return  Whether or not the node is an internal component.
     * @throws IllegalArgumentException if the node doesnt exist.
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Determine if the node is an external, whether it is a leaf.
     * @param p The node that you want to test.
     * @return  Whether or not the node is a leaf.
     * @throws IllegalArgumentException If the node doesnt exist.
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Determine if a node is a root node.
     * @param p The node you want to test.
     * @return  Whether or not the node is a root.
     * @throws IllegalArgumentException If the node doesnt exist.
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    /**
     * Determine the size of the tree.
     * @return An integer of the number of nodes in the tree.
     */
    int size();

    /**
     * Determine if the tree is empty.
     * @return Whether or not the tree is empty.
     */
    boolean isEmpty();

    /**
     * An iterator of the tree for easy passage through the tree.
     * @return an iterator.
     */
    @Override
    Iterator<E> iterator();

    /**
     * The position of the tree, usually this is a node, but can be a root,
     * like ginseng or ginger.
     * @return The iterable thing.
     */
    Iterable<Position<E>> positions();
}
