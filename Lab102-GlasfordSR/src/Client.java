/**
 *
 * @author Steven Glasford
 */

public class Client {

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        //create an object of type Scores
        
        Scores scores = new Scores(100);
        
        int range = 100;
        //fill the bag with a bunch of random numbers between -100 and 100
        for (int i = 0; i < 100; i++){
            int random = ((int)(Math.random() * (range * 2) + 1) - range);
            scores.add(random);
        }
        
        //print out the bag
        System.out.println(scores);
        
        //add the number 86 to the bag
        scores.add(86);
        
        //print out the current size of the list
        System.out.printf("The current size of the bag: ");
        System.out.println(scores.getCurrentSize());
        
        //randomly remove an entrant
        scores.remove();
        
        //get the 75th entrant
        int at75 = scores.get(75);
        System.out.printf("The 75th entrant: ");
        System.out.println(at75);
        
        //print out the number of given number in the 75th place
        System.out.printf("The number of times the number in the 75th place is found: ");
        System.out.println(scores.getFrequencyOf(at75));
        
        //remove the first instance of the number in the 75th place
        scores.remove(at75);
        
        //print the frequency that the number that used to be in the 75th place now occurs
        System.out.printf("The number of times the number at the 75th place now occurs, \nhaving taken the first instance of the number out of the bag: ");
        System.out.println(scores.getFrequencyOf(at75));
        
        //check the frequency of the number 86
        System.out.println("The frequency of the number 86: " + scores.getFrequencyOf(86));
        
        //check whether the array in Scores object contains the number 86
        System.out.println("Does the array in Scores contain the number 86: " + scores.contains(86));
    }
    
}
