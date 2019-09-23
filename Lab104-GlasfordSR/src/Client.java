
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 * A main client class controlling the bulk of the programming; uses
 * JOptionPane to display information and control the program, and implements
 * Isabel s summation technique, a harmonic number calculator, and a file
 * finding method.
 * @author Steven Glasford
 * @version 2-15-2019
 */
public class Client {

    /**
     * Pop up a window saying an option was not chosen if no option is chosen,
     * sort of a de facto.
     */
    public static void noOptionSelected(){
        JOptionPane.showMessageDialog(null, "Nothing was entered, "
                + "please enter something.");
    }

    /**
     * Ask for a confirmation that the user wants to quit the program
     * @return  true if the user wants to quit, false if the user does not want
     * to quit.
     */
    public static boolean confirmExit(){
        int option = JOptionPane.showConfirmDialog(null,"Are you sure you "
                + "want to exit?","exit", JOptionPane.YES_NO_OPTION);
        return JOptionPane.YES_OPTION == option;
    }

    /**
     * If harmonic calculator selected, prompts user for value and ensure it is
     * safe for use.
     */
    public static void runHarmonic(){
        System.out.println("Testing Harmonic calculator");
        //used to stop the program
        boolean stop = false;

        //used to get the number for the given number to be calculated
        int result = 0;

        String input = JOptionPane.showInputDialog(null,"Please enter in "
                + "a integer number","Harmonic Calculator",
                JOptionPane.OK_CANCEL_OPTION);
        //check if the user inputted something
        if(input == null){
            //ask if the user wants to quit
            if (confirmExit()){
                return;
            }
            runHarmonic();
            return;
        }
        //try casting into an integer, throw an error if not castable
        try{
            result = Integer.parseInt(input);
        }
        //throw an number exception error
        catch (NumberFormatException e){
            //print an error message in the terminal
            System.out.println("Invalid parameter: " + input);
            //produce an error message in the JOptionPane
            JOptionPane.showMessageDialog(null, "Not an integer value, "
                    + "please enter integer");
            //run the program recursively from this point
            runHarmonic();
            //end the method immediately after the program is brought back from
            //the recursive run, eliminating break statement
            return;
        }

        //throw an error message if zero is entered
        if (result == 0){
            //deliver an error in the terminal
            System.out.println("Zero was entered.");
            //give an error in the dialog
            JOptionPane.showMessageDialog(null, "Harmonic is undefined "
                + "at 0, please enter something else.");
            //run the program recursively otherwise
            runHarmonic();
            //end the method after returning from the recursive statement
            return;
        }
        //produce an error if the number is less than zero
        if (result < 1){
            //print an error statement to the terminal
            System.out.println("User entered a negative number.");
            //print an error statement to the dialog
            JOptionPane.showMessageDialog(null, "Not a positive number."
                    + " enter something else.");
            //run the program recursively
            runHarmonic();
            //end the method once the recursive statement is finished.
            return;
        }
        //print a confirmation that the parameter entered was legal to the
        //terminal
        System.out.println("Valid parameter: " + result);
        //save the value of the harmonic value
        double harmonic = Recursion.harmonic(result);
        //print the harmonic value to the terminal
        System.out.println("Output: "+ harmonic);
        //print the harmonic value to the dialog
        JOptionPane.showMessageDialog(null, Double.toString(harmonic));
        //end the method if the method and return to the other screen
        return;
   }
     /**
     * Checks to ensure a number is the power of two
     * @param number    any number to test
     * @return  true if the number is a power of two, false otherwise.
     */
    public static boolean isPowerOfTwo(int number) {

        // a number cannot be a power of two if it is not even
        if (number % 2 != 0)
            return false;

        else {
            for (int i = 0; i <= number; i++) {
                //return true if the number is a power of two
                if (Math.pow(2, i) == number)
                    return true;
            }
        }

        //return false elsewise
        return false;
    }


    /**
     * A method to appropriately run Isabel s method.
     */
    public static void runIsabel(){
        //print out a title page
        System.out.println("Isabel sum");
        //the string to the path a person wants to take
        String path;
        //a new array of the ArrayBag format
        ArrayBag fromFile;
        fromFile = new ArrayBag() {};

        path = JOptionPane.showInputDialog(null,"Please enter file path");
        if(path == null){
            if (confirmExit()){
                return;
            }
            //produce an error message to the terminal
            System.out.println("Nothing was entered.");
            //produces an error message in the dialog box
            JOptionPane.showMessageDialog(null, "Nothing entered,"
                + " please enter something.");
            //recurse the method
            runIsabel();
            //kill the method once finished
            return;
        }

        //make a file instance
        File file;
        //start a scanner instance that will look into the given file
        Scanner scan = null;

        //try to open the given file
        try {
            file = new File(path);
            scan = new Scanner(file).useDelimiter(" ");
            System.out.println("Valid path: " + path);

        }
        //throws a file not found exception
        catch(FileNotFoundException e){
            //produce an error message in the terminal
            System.out.println("Invalid path: " + path);
            //produce an error message in the dialog box
            JOptionPane.showMessageDialog(null, "Not a valid file location, "
                    + "please enter valid path");
            //recursively run the method
            runIsabel();
            //kill the method once the recursed method is finished.
            return;
        }

        //read the information from the file into an array
        try{
            while(scan.hasNext()){
                //if the information is not an integer format, then skip over
                //that piece of information
                try {
                    fromFile.add(Integer.parseInt(scan.next()));
                }
                catch (NumberFormatException e){
                }
            }
        }
        //generic error thrown if the file cannot be read for whatever reason
        catch(NullPointerException e){    }

        if(!(isPowerOfTwo(fromFile.getCurrentSize()))){
            //produce an error message in the terminal
            System.out.println("Array not a power of two: "
                    + fromFile.getCurrentSize());
            //produce an error message in the dialog box
            JOptionPane.showMessageDialog(null, "Array is not a power of two,"
                    + " please enter valid path of int array that contains "
                    + "length that is power of two");
            //recurse the program
            runIsabel();
            //kill the method after returning from the recursed method
            return;
        }

        //
        System.out.println("input: "+ fromFile.toString());

        //produce the output of the Isabel s method to the terminal
        System.out.println("Output: " +
                Recursion.isabel(fromFile.getIntArray()));

        //kill the method if everything is good in the world.
        return;


    }

    public static void runFind() throws FileNotFoundException{
        System.out.println("Find file");


        String path;
        path = JOptionPane.showInputDialog(null,"Please enter file path");
        String target = JOptionPane.showInputDialog(null, "Please enter the "
                + "target file.");
        if(null == path){
            //determine if the user wants to continue with their option or not
            if (confirmExit()){
                //kill the method if they don t want to continue
                return;
            }
            //recursively run the program if the user wants to continue
            runFind();
            //kill the method if they want to quit
            return;
        }

        //open the file, regardless of whether it exists or any of that
        //shit
        File file = new File(path);

        //all you care about is if it is a directory or not
        if(!(file.isDirectory())){
            //print an error message to the terminal
            System.out.println("Invalid path: " + path);
            //print an error message to the dialog
            JOptionPane.showMessageDialog(null, "This is not a valid,"
                   + " file please enter valid path to directory");
            //recursively run the program
            runFind();
            //kill the method if after the recursion
            return;
        }

        //print the path of inputted path to the terminal
        System.out.println("Path: " + path);

        //search for the file
        Recursion.find(path,target);

        //kill the method once finished
        return;
    }

   /**
    * The menu system that prompts user to select an operation or exit the
    * program
     * @throws java.io.FileNotFoundException
    */
    public static void menuSelector() throws FileNotFoundException{
        String optionString;
        optionString = "A to run harmonic calculator"
                + "\nB to run Isabel s sum"
                + "\nC to run find file"
                + "\nD to exit";
        String response = JOptionPane.showInputDialog(null,optionString);
        if(null == response)
            if(confirmExit())
                return;

        switch ( response ){
            case "a" :
            case "A" :
                runHarmonic();
                //recurse the menuSelector
                menuSelector();
                break;
            case "b" :
            case "B" :
                runIsabel();
                //recurse the menuSelector
                menuSelector();
                break;
            case "C":
            case "c":
                runFind();
                //recurse the menu
                menuSelector();
                break;
            case "D":
            case "d":
                //confirm if the user wants to quit
                confirmExit();
                break;
            default :
                //tell the user that nothing was entered
                noOptionSelected();
                menuSelector();
                break;
        }
    }

    /**
     * Starts the menu system and the menu system will end itself.
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        menuSelector();
    }

}
