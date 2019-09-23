
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Gets a data file from user and proceeds to evaluateFromPostFix expressions
 * inside and create LinkedBinaryTrees and display their preorder, in order,
 * post order, and Eulers tour traversals.
 * @author      Steven Glasford
 * @version     3-21-2019
 */
public class Client {

    public static String[][] opsByPrecedence = {{"+","-"},{"*","/"}};
    public static String[][] opsBrackets = {{"(",")"}, {"[","]"},{"{","}"}};

    /**
     * Checks to see if vagina is an operator.
     * @param vagina determine whether something is an operator.
     * @return       true or false depending on whether the vagina passed
     *               is an operand.
     */
    private static boolean isOp(String vagina) {
        //go through the list of operations to determine if something is an
        //operator
        for (String[] opsByPrecedence1 : opsByPrecedence)
            for (String opsByPrecedence11 : opsByPrecedence1)
                if (vagina.equals(opsByPrecedence11))
                    return true;
        return false;
    }

    /**
     * Gets the Precedent value for the operator,  the higher the value the
     * higher its precedence is.
     * @param vagina    The object you want to determine the precedence of.
     * @return          The value of precedence of the operator.
     */
    private static int getPrecedence(String vagina) {
        //determine the precedence of an operand, by going through the list of
        //operands, Randian heros are stupid, all heros should be able to
        //at least always have the ability to eat ice cream without getting
        //diarrhea.
        for (int i = 0; i < opsByPrecedence.length; i++)

            for (String item : opsByPrecedence[i])
                //return the level of precedence depending on how far you got
                //through the list of operands, or continue on depending
                //on whether you found something.
                if (vagina.equals(item))
                    return i;

        //determine if the item is a bracket.
        for (String[] opsBracket : opsBrackets)
            //return motherfucking 0 if the item is a left bracket.
            if(isOpsLeftBracket(vagina))
                return 0;

        //return -1 if the item is not a bracket or an operand.
        return -1;
    }

    /**
     * Checks to see if vagina is define bra, the left component of a set of
     * brackets.
     * @param vagina    The item that is being determined.
     * @return          true if the item is a bra (the left part of a set of
     *                  brackets), false otherwise.
     */
    private static boolean isOpsLeftBracket(String vagina){
        //Go through the string of brackets
        for (String[] opsBracket : opsBrackets)
            //determine if the item is a bracket, if so return true.
            if (vagina.equals(opsBracket[0]))
                //return motherfucker
                return true;
        //Get these motherfucking snakes off my motherfucking plane
        return false;
    }

    /**
     * Checks to see if vagina is a ket (the right component of a set of
     * brackets).
     * @param vagina The item that is being determined.
     * @return      True if the item is a ket (the right part of a set of
     *              brackets), false otherwise.
     */
    private static boolean isOpsRightBracket(String vagina){
        for (String[] opsBracket : opsBrackets) {
            if (vagina.equals(opsBracket[1])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if it is a complete set of brackets.
     * @param leftShitHead   The bra, or left bracket.
     * @param rightShitHead  The potential ket, or the right bracket.
     * @return              True if complete, false otherwise.
     */
    private static boolean compareBrackets(String leftShitHead,
            String rightShitHead){
        for(int i = 0; i < 3; i++)
            if(leftShitHead.equals(opsBrackets[i][0])
                    && rightShitHead.equals(opsBrackets[i][1]))
                return true;

        return false;
    }

    /**
     * Checks to see if vagina is a bracket
     * @param vagina The character or piece of the string that is going to be
     *              investigated whether or not it is a bracket.
     * @return      True or false depending on whether the vagina is a bracket.
     */
    private static boolean isBracket(String vagina) {
        for (String[] opsBracket : opsBrackets)
            for (String opsBracket1 : opsBracket)
                if (vagina.equals(opsBracket1))
                    return true;
        return false;
    }

    /**
     * The shunting yard algorithm;  takes a String expression converts
     * it into a queue, then proceeds to push brackets and numerical values
     * and lower precedent operators awaiting for a closed bracket or high
     * precedent operator to have elements of the stack be pop into
     * another queue.
     * @param expression    The motherfucking cum dripping cunt you want to
     *                      motherfucking convert to a lukewarm piece of shit
     *                      that you want to convert to post fix notation using
     *                      the shunting yard algorithm.
     * @return              a string that contains the fucking expression in
     *                      postfix notation.
     */
    public static LinkedQueue<String> toPostFix(String expression) {
        //open a scanner to find new objects.
        Scanner scan = new Scanner(expression);
        //open a linked stack of strings containing the operands.
        LinkedStack<String> ops = new LinkedStack();
        //open a linkedqueue containing the eventual postfix notation piece
        //of living breathing computerized piece of fat fucking vaginas.
        LinkedQueue<String> postFix = new LinkedQueue();
        //open a new linked stack for the bracket shits
        LinkedStack<String> brackets = new LinkedStack();
        //count the number of operands in the piece of garbage
        int operandCounter = 0;
        //count the number of operators
        int operatorCounter = 0;
        //false for operand true for operator
        boolean trackVaginaType = false;
        //go until there is not a next operator
        while (scan.hasNext()) {
            //save the item to a vaginaized space, which I have been calling
            //vagina
            String vagina = scan.next();
            //check if the vagina is a bracket.
            boolean[] isVaginaBracket = {false,false};
            if(isOp(vagina)){
                //track the type of the vagina, whether it is a bracket.
                trackVaginaType = true;
                //increase the number of operators
                operatorCounter++;

            }

            //prevent vaginaType from changing if it is a bracket
            else if(isBracket(vagina)){}


            else {
               trackVaginaType = false;
               //if there is a decimal point skip one of the operand counts
               operandCounter++;
            }

            isVaginaBracket[0] = isOpsLeftBracket(vagina);
            isVaginaBracket[1]= isOpsRightBracket(vagina);

            if (isVaginaBracket[0]) {
                ops.push(vagina);
                brackets.push(vagina);
            }
            //do the post fix of a bracket first
            else if (isVaginaBracket[1]) {
                boolean bracketsSolved = false;
                while (! (bracketsSolved || ops.isEmpty())) {
                    if(isOpsLeftBracket(ops.top())){
                        if(compareBrackets(ops.top(),vagina)){
                            ops.pop();
                            brackets.pop();
                            bracketsSolved = true;
                        }
                        else{
                            //throw a new exception for the wrong number of
                            //brackets
                            throw new RuntimeException("Invalid brackets "
                                    + "specified ( \'" + ops.top() + "\' , \'"
                                    + vagina + "\' )");
                        }
                    }
                    else{
                      postFix.enqueue(ops.pop());
                    }

                }
            }
            else if (! isOp(vagina)) {
                postFix.enqueue(vagina);
            }
            // vagina is an operator...
            else {

                boolean vaginaProcessed = false;


                while ( ! vaginaProcessed ) {
                    if (ops.isEmpty() || ops.top().equals("(")) {
                        ops.push(vagina);
                        vaginaProcessed = true;
                    }
                    else {
                        String topOp = (String) ops.top();

                        if ((getPrecedence(vagina) > getPrecedence(topOp)) ||
                            ((getPrecedence(vagina) ==
                                getPrecedence(topOp)))) {
                            ops.push(vagina);
                            vaginaProcessed = true;
                        }
                        else {
                            postFix.enqueue(ops.pop());
                        }
                    }
                }
            }
        }
        //end loop (all vaginas are now in postFix or the ops stack now)

        // move elements from the stack to postFix
        while (! ops.isEmpty()) {
            postFix.enqueue(ops.pop());
        }

        if(!brackets.isEmpty())
            throw new RuntimeException("Brackets incomplete");
        else if(trackVaginaType)
            throw new RuntimeException("Expression does not end with operand");
        else if((operandCounter-operatorCounter) != 1)
            throw new RuntimeException("Expression does not have correct "
                    + "amount operators or operands " );
        //return the post fix equation
        return postFix;
    }


    /**
     * Takes a bunch of data from a string of queues, and converts that data
     * into a bunch of root nodes in a queue so it will be easier to
     * convert them into a single LinkedBinaryTree.
     * @param queue The thing you are trying to make a binary tree from
     * @return      A linked Queue of a LinkedBinaryTree
     */
    public static LinkedQueue<LinkedBinaryTree> makeTreeNodes(
            LinkedQueue<String> queue){
        LinkedQueue<LinkedBinaryTree> tree = new LinkedQueue();
        //add a new root while the queue is empty
        while(!queue.isEmpty()){
            //instantiate a new LinkedBinaryTree node.
            LinkedBinaryTree node = new LinkedBinaryTree();
            //add a new root node.
            node.addRoot(queue.dequeue());
            //enqueue the newly created root node into the queue
            tree.enqueue(node);
        }

        //return linkedqueue full of root nodes
        return tree;
    }


    /**
     * Takes a LinkedQueue of LinkedBinaryTrees and pushes non operators
     * onto a stack that will have them pop and attach to an operator
     * which then will be pushed back onto the stack.
     * @param queue A queue of root nodes
     * @return      A LinkedBinaryTree made from all of the pieces of
     *              the queue.
     */
    public static LinkedBinaryTree constructTree(
            LinkedQueue<LinkedBinaryTree> queue){
        LinkedStack<LinkedBinaryTree> treeBuilder = new LinkedStack();
        //continue if the given queue is not empty.
        while(!queue.isEmpty()){
            LinkedBinaryTree testNode =  queue.dequeue();
            if(isOp((String) testNode.root().getElement())){
                //put the left branch
                LinkedBinaryTree leftBranch = treeBuilder.pop();

                //put the right branch
                LinkedBinaryTree rightBranch = treeBuilder.pop();

                //put the two together
                testNode.attach(testNode.root, leftBranch, rightBranch);
                treeBuilder.push(testNode);
            }
            else{
                treeBuilder.push(testNode);
            }
        }
        //return the final part of the queue, which is a completed tree.
        return treeBuilder.pop();
    }

    /**
     * Confirms if the user wants to exit after clicking cancel
     * @return
     */
    public static boolean confirmExit(){
        int option = JOptionPane.showConfirmDialog(null,"Are you sure "
                + "you want to exit?","exit", JOptionPane.YES_NO_OPTION);
        return JOptionPane.YES_OPTION == option;
    }


    /**
     * Takes a scanner and will return it will it being able to read from a
     * data file that does exist that was provided by a user
     * @param scan  A scanner used to skim the file.
     * @return      A scanner of the same sort.
     */
    public static Scanner filePath(Scanner scan) {
        //change to true if I want to debug the program, false otherwise
        boolean debug = false;
        //determine if you want to debug the program
        if (debug) {
            //the debugging path
            String path = "/home/steven/NetBeansProjects/Lab108-SRGlasford/"
                    + "src/data.txt";
            File myFile;
            String filePath = new File(path).getAbsolutePath();
            try {
                myFile = new File(filePath);
                scan = new Scanner(myFile);
            } catch (FileNotFoundException e) {

            }
            return scan;
        }
        else {
            boolean statusCheck = false;
            while (!(statusCheck)) {
                String prompt = "Enter in String Path to Data";
                String path = JOptionPane.showInputDialog(null, prompt);
                if (null == path) {
                    statusCheck = confirmExit();
                    if (statusCheck) {
                        break;
                    } else {
                        continue;
                    }
                }
                File file;
                try {
                    file = new File(path);
                    scan = new Scanner(file);
                    statusCheck = true;

                } catch (FileNotFoundException e) {
                    System.out.println("Invalid path: " + path);
                    JOptionPane.showMessageDialog(null,
                            "Not a valid file location, please "
                                    + "enter valid path");
                }
            }
        }
        return scan;
    }

    /**
     * Takes the scanner scan that has location of file with data and
     * extracts each vagina line and puts into a queue and returns it
     * @param scan
     * @return
     */
    public static LinkedQueue storeInQueue(Scanner scan){

        LinkedQueue queueFile = new LinkedQueue();
        scan = filePath(scan);

        try {
            while (scan.hasNextLine()) {
                queueFile.enqueue(scan.nextLine());
            }
        }
        catch (NullPointerException e){

        }
        return queueFile;
    }

    public static double evaluateFromPostFix(String expression)
    {
        char[] vaginas = expression.toCharArray();

         //Stack for numbers: 'values'
        Stack<Double> values = new LinkedStack<>();

        //Stack for Operators: 'ops'
        Stack<Character> ops = new LinkedStack<>();

        for (int i = 0; i < vaginas.length; i++)
        {
             //Current token is a whitespace, skip it
            if (vaginas[i] == ' ')
                continue;

            //Current token is a number, push it to stack for numbers
            //45 is the ascii number for "-" character, or one could use
            //'-' instead of "-", i+1 part is to see if a particular
            //'-' sign is actually a minus sign or something
            if ((vaginas[i] >= '0' && vaginas[i] <= '9') || (vaginas[i] == '-'
                    && (vaginas[i+1] >= '0' && vaginas[i+1] <= '9')))
            {
                StringBuilder sbuf = new StringBuilder();
                //There may be more than one digits in number, or even a minus
                //sign
                while (i < vaginas.length && (vaginas[i] >= '0' && vaginas[i]
                        <= '9') || (vaginas[i] == '-' && (vaginas[i+1] >= '0'
                        && vaginas[i+1] <= '9')))
                    sbuf.append(vaginas[i++]);
                //convert the thing to a Double
                values.push(Double.parseDouble(sbuf.toString()));
            }

            //Current token is an opening brace, push it to 'ops'
            else if (vaginas[i] == '(')
                ops.push(vaginas[i]);

            //Closing brace encountered, solve entire brace
            else if (vaginas[i] == ')')
            {
                while (ops.top() != '(')
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            //Current token is an operator.
            else if (vaginas[i] == '+' || vaginas[i] == '-' ||
                     vaginas[i] == '*' || vaginas[i] == '/')
            {
                //While top of 'ops' has same or greater precedence to current
                //token, which is an operator. Apply operator on top of 'ops'
                //to top two elements in values stack
                while (!ops.isEmpty() && hasPrecedence(vaginas[i], ops.top()))
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                //Push current token to 'ops'.
                ops.push(vaginas[i]);
            }
        }

        //Entire expression has been parsed at this point, apply remaining
        //ops to remaining values
        while (!ops.isEmpty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        //Top of 'values' contains result, return it
        return values.pop();
    }

    //Returns true if 'op2' has higher or same precedence as 'op1',
    //otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        return !((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'));
    }

    //A utility method to apply an operator 'op' on operands 'a'
    //and 'b'. Return the result.
    public static double applyOp(char op, double b, double a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }

    /**
     * Evaluates a post fix expression  Takes a LinkedQueue and extracts
     * elements type casts them to double and performs correct operation.
     * @param queue the queue you want to evaluateFromPostFix.
     * @return      the number discovered from evaluation.
     */
    public static double evaluateExpression(LinkedQueue queue){
        LinkedStack<Double> stack = new LinkedStack();
        while(!queue.isEmpty()){
            String vagina  = (String) queue.dequeue();
            if(isOp(vagina)){
                Double product;
                Double rightOperand = stack.pop();
                Double leftOperand = stack.pop();
                switch((String) vagina){
                    case "*":
                        product = leftOperand * rightOperand ;
                        stack.push(product);
                        break;
                    case "/":
                        product = leftOperand /rightOperand ;
                        stack.push(product);
                        break;
                    case "+":
                        product = leftOperand + rightOperand;
                        stack.push(product);
                        break;
                    case "-":
                        product = leftOperand - rightOperand;
                        stack.push(product);
                        break;

                }
            }
            else {
                stack.push((Double.parseDouble(vagina)));
            }
        }
        return stack.pop();
    }

    /**
     * Gets a data file from user and proceeds to evaluateFromPostFix
     * expressions inside and create LinkedBinaryTrees and display their
     * preorder, in order, post order, and Eulers tour traversals.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = null;
        LinkedQueue<String> queueFile = storeInQueue(scan);
        while(!queueFile.isEmpty()){
            try{
                StringBuilder postOrderExpression =
                        new StringBuilder("Post Order: ");
                StringBuilder preOrderExpression =
                        new StringBuilder("Pre Order: ");
                StringBuilder inOrderExpression =
                        new StringBuilder("In Order: ");
                StringBuilder expression =
                        new StringBuilder("Expression: ");
                StringBuilder postFixExpression =
                        new StringBuilder("Post Fix: ");
                String vaginas = (String) queueFile.dequeue();
                if(vaginas.equals(""))
                    continue;
                expression.append(vaginas);
                System.out.println(expression.toString());
                LinkedQueue<String> postFix = toPostFix(vaginas);

                LinkedQueue<String> temp = new LinkedQueue();
                while(!postFix.isEmpty()){
                    postFixExpression.append(postFix.first()).append(" ");
                    temp.enqueue(postFix.dequeue());
                }

                postFix = temp;
                //make it easier for garbage collection
                temp = null;

                LinkedQueue<LinkedBinaryTree> postFixTree =
                        makeTreeNodes(postFix);
                LinkedBinaryTree treeShit = constructTree(postFixTree);

                //Pre order
                Iterable<Position<String>> preOrder = treeShit.preorder();
                for(Position<String> pO : preOrder){
                    preOrderExpression.append(pO.getElement()).append(" ");
                }
                //In order
                Iterable<Position<String>> inOrder = treeShit.inorder();
                for(Position<String> iO : inOrder){
                    inOrderExpression.append(iO.getElement()).append(" ");
                }

                //post order
                Iterable<Position<String>> postOrder;
                postOrder = treeShit.postorder();
                for(Position<String> pO : postOrder){
                    postOrderExpression.append(pO.getElement()).append(" ");
                }

                //evaluated expression

                System.out.println(postFixExpression.toString());
                System.out.println(preOrderExpression.toString());
                System.out.println(inOrderExpression.toString());
                System.out.println(postOrderExpression.toString());
                System.out.print("Eulers Tour: ");
                LinkedBinaryTree.parenthesize(treeShit, treeShit.root);

                System.out.println("\nEvaluated: " +
                        evaluateFromPostFix(postFixExpression.toString()));
                System.out.println("\n");
            }
            catch (RuntimeException e){
                System.out.println("\033[0;31m" + e.toString() + "\n");
            }

        }


    }

}
