/**
 * A main class containing the realest part of the program.
 * @author Steven Glasford
 * @version 3-5-2019
 */
public class Client {

    /**
     * @param args No command line arguments.
     */
    public static void main(String[] args) {
        //Manually create an instance of a binary expression tree
        //for (((5+2)*(2-1)/((2+9))+((7-2)-1))*8)
        LinkedBinaryTree treeShit = new LinkedBinaryTree();



        //build the tree, use some Positions to make it easier for me to
        //build the tree in a fashion similar to the following:
        /*
        where the letters repesent the place where the Position variable
        are supposed to represent, and the ? character represents the
        division character, so as to avoid looking like another arm of
        the tree.

                   root *
                       / \
                     A+   8
                     / \
                    /   \
                   /     \
                  /       \
                B?        C-
                / \       / \
               /   \    F-   1
             D*    E+   / \
             / \   / \ 7   2
            /   \ 2   9
          G+    H-
          / \   / \
         5   2 2   1

        */
        Position root;
        Position A;
        Position B;
        Position C;
        Position D;
        Position E;
        Position F;
        Position G;
        Position H;

        root = treeShit.addRoot("*");
        treeShit.addRight(root, "8");
        A = treeShit.addLeft(root, "+");
        B = treeShit.addLeft(A, "/");
        C = treeShit.addRight(A, "-");
        treeShit.addRight(C,"1");
        D = treeShit.addLeft(B,"*");
        E = treeShit.addRight(B, "+");
        treeShit.addLeft(E,"2");
        treeShit.addRight(E, "9");
        F = treeShit.addLeft(C, "-");
        treeShit.addLeft(F, "7");
        treeShit.addRight(F, "2");
        G = treeShit.addLeft(D, "+");
        treeShit.addLeft(G, "5");
        treeShit.addRight(G, "2");
        H = treeShit.addRight(D, "-");
        treeShit.addLeft(H, "2");
        treeShit.addRight(H, "1");

        //take the root of the tree and print it out in pre order fashion
        System.out.println("The preorder traversal of the tree.");
        System.out.println(preorder(treeShit, root) + "\n");

        //take the root of the tree and print it out in in order fashion
        System.out.println("The inorder traversal of the tree.");
        System.out.println(inorder(treeShit,root) + "\n");

        //take the root of the tree and print it out in post order fashion
        System.out.println("The postorder traversal of the tree.");
        System.out.println(postorder(treeShit,root) + "\n");

        //take the root of the tree and print it out in breadth first fashion
        System.out.println("The breadth-first traversal of the tree.");
        System.out.println(breadth(treeShit, root) + "\n");

        //print the tree using parantheses
        System.out.println("The parenthesized version of the tree.");
        System.out.println(parenthesize(treeShit, root) + "\n");
    }

    /**
     * Print the tree in preorder notation.
     * @param <E>   A generic placement name.
     * @param T     The tree in question.
     * @param p     The root of the tree you are investigating.
     * @return a string containing the tree in preorder notation
     */
    public static <E> String preorder(LinkedBinaryTree<E> T, Position<E> p){
        String middle = "";
        String left = "";
        String right = "";

        //save the middle element for later printing
        if (p != null)
            middle = (String) p.getElement();

        //get the left child and save it
        if (T.left(p) != null)
            left = (String) preorder(T, T.left(p));
        else
            return middle;

        //get the right child
        if (T.right(p) != null)
            right = (String) preorder(T,T.right(p));
        else
            return middle;

        return middle + " " + left + " " + right;
    }

    /**
     * Return a string of a tree in inorder notation.
     * @param <E>   A generic placeholder for the data contained in the tree.
     * @param T     The tree in question.
     * @param p     The root of the tree.
     * @return  a string of inorder traversal of a tree
     */
    public static <E> String inorder(LinkedBinaryTree<E> T, Position<E> p){
        String middle = "";
        String left = "";
        String right = "";

        //save the middle element for later printing
        if (p != null)
            middle = (String) p.getElement();

        //get the left child and save it
        if (T.left(p) != null)
            left = (String) inorder(T, T.left(p));
        else
            return middle;

        //get the right child
        if (T.right(p) != null)
            right = (String) inorder(T,T.right(p));
        else
            return middle;

        return left + " "  + middle + " " + right;
    }

    /**
     * Given the root of a tree, print out the postorder transversal.
     * @param <E>
     * @param p The root of a tree.
     * @return  The output of the string in postorder notation.
     */
    public static <E> String postorder(LinkedBinaryTree<E> T, Position<E> p){
        String middle = "";
        String left = "";
        String right = "";

        //save the middle element for later printing
        if (p != null)
            middle = (String) p.getElement();

        //get the left child and save it
        if (T.left(p) != null)
            left = (String) postorder(T, T.left(p));
        else
            return middle;

        //get the right child
        if (T.right(p) != null)
            right = (String) postorder(T,T.right(p));
        else
            return middle;

        return left + " " + right + " " + middle;
    }


    /**
     * Print out the tree in breadth-first notation, using breadth-first
     * traversal.
     * @param <E>   A generic placement.
     * @param T     The binary tree in question.
     * @param p     The root of the tree.
     * @return      A string containing all of the information from the tree
     *              in breadth-first traversal notation; will be null if
     *              it is empty.
     */
    public static <E> String breadth(LinkedBinaryTree<E> T, Position<E> p){
        //determine if the root is real, return null if not
        if (p == null)
            return null;

        //initialize the queue.
        LinkedQueue queue = new LinkedQueue();
        //initialize a string that will eventually be returned.
        String bread = "";
        //enqueue the root of the tree.
        queue.enqueue(p);

        //go through the breadth-first traversal.
        while (!queue.isEmpty()) {
            //remove the position from the queue.
            p = (Position) queue.dequeue();

            //add the newly removed position to the string.
            bread += p.getElement() + " ";

            //add the left child to the queue.
            if (T.left(p) != null)
                queue.enqueue(T.left(p));
            //add the right child to the queue.
            if (T.right(p) != null)
                queue.enqueue(T.right(p));
        }
        //return the final string
        return bread;
    }

    /**
     * Prints parenthesized representation of subtree of T rooted at p.
     * @param <E>   A generic placement name.
     * @param T     The tree in question.
     * @param p     The root of the tree.
     * @return      The root as a string.
     */
    public static <E> String parenthesize(LinkedBinaryTree<E> T,
            Position<E> p){
        //the middle of the tree (the root)
        String middle = "";
        //the left child
        String left = "";
        //the right child
        String right = "";
        //get the middle part of the equation thing
        if (p != null)
            middle = (String) p.getElement();

        //get the left part of the equation and recurse
        if (T.left(p) != null)
            left = parenthesize(T, T.left(p));
        //return the middle element prematurely if it has no children
        else
            return middle;

        //get the right part of the equation and recurse
        if (T.right(p) != null)
            right = parenthesize(T, T.right(p));
        //return the middle element prematurely if it has no children
        else
            return middle;

        //print out the tree with the parentheses
        return ("(" + left + middle + right + ")");
    }

    /**
     * Prints preorder representation of subtree of T rooted at p
     * having depth d.
     * @param <E>   A generic representation of the whatever you want
     *              printed.
     * @param T     The root of the tree you want to investigate.
     * @param p     The current position of you are in
     * @param d     The current depth of the tree.
     */
    public static <E> void printPreorderIndent(Tree<E> T, Position<E> p,
            int d){
        //indent based on d.
        System.out.println(spaces(2*d) + p.getElement());
        for (Position<E> c : T.children(p))
            //child depth is d+1
            printPreorderIndent(T,c,d+1);
    }

    /**
     * A function to add a certain number of spaces and return the number of
     * spaces as a string.
     * @param num   The number of spaces you want.
     * @return      The number of spaces you want.
     */
    public static String spaces(int num){
        String temp = "";
        for (int i = 0; i < num; num++){
            temp += " ";
        }
        return temp;
    }
}
