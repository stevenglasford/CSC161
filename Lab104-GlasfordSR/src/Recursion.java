
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The Recursion class provides static methods that can calculate
 * a harmonic number, half the size of an array of the power of two, and find
 * a given file within a given path.
 * @author Steven Glasford
 * @version 2-15-2019
 */
public class Recursion {
    /**
     * Given a value, this will determine the given value s harmonic number,
     * using recursion
     * @param given The initial number to determine the harmonic for
     * @return      The harmonic value
     */
    public static double harmonic(int given){
        //base case is if the given number is zero
        if(given < 1){
            return 0;
        }
        //else the recursive statement
        else{
            return 1 / (double) given + harmonic(given - 1);
        }
    }

    /**
     * Sums an array which sinks it down to half its size and stores the summed
     * value for each recursive call
     * @param arr an input array
     * @return  the value of Isabel s technique
     */
    public static int isabel(int[] arr){
        //determine the size of the array given
        int size = arr.length/2;
        //make a temporary array to store the added values together
        int[] temp = new int[size];

        //make a trace of the interaction, this is mostly used in debugging, but
        //still provides an interesting visual to the program
        String trace = "[ ";
        for (int i = 0; i < arr.length; i++){
            trace = trace + arr[i] + ", ";
        }
        trace += " ]";
        System.out.println(trace);

        if (size == 1){
            return arr[0] + arr[1];
        }
        else{
            for (int i = 0; i < size; i++){
                temp[i] = arr[2*i] + arr[2*i+1];
            }
            return isabel(temp);
        }

    }

    /**
     * Find a given file within a given path in the file
     * @param path      The given directory of the file you want to look in
     * @param target    the specific file you are looking for
     */
    public static void find(String path, String target){
        try {
            //open the file from a string
            File root = new File(path);
            //get all of the files within the given directory
            File[] files = root.listFiles();
            //go through every file in search for a directory
            for (File file : files) {
                //if the file is found to be a directory, then recurse
                if (file.isDirectory()) {
                    find(file.getAbsolutePath(), target);
                    //System.out.println(file.getCanonicalPath());
                    //printTree(file);
                } else {
                    //if the file is found then return the full name of the file
                    if (file.getName().equals(target)) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        }
        //throw errors if the directory is not found or is a file, very general
        //throw statement
        catch(NullPointerException e){

        }
    }


}
