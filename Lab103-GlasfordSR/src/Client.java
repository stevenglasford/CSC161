/**
 *
 * @author Steven Glasford
 * @version January 31, 2019
 * 
 * A main client program used to control the program
 */

import java.util.Scanner;

public class Client {

    /**
     * 
     * @param args no arguments passed into the system
     */
    public static void main(String[] args) {
        //create an object of type Arraybag
        ArrayBag footballTeam;
        footballTeam = new ArrayBag(2) {};
        
        //initialize the keyboard
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Please enter some information about 6 players from the NDSU football team");
        //make a for loop asking for the player's information
        for (int i = 0; i < 6; i++){
            String name = null;
            String position = null;
            int jerseryNum = 0;
            String jerseyTemp = null;
            boolean stop = false;
            Player teamMember;
            
            
            //enter the player's name
            System.out.println("Please enter the player name: ");
            name = keyboard.nextLine();
            
            //enter the player's position
            System.out.println("Please enter the player's position: ");
            position = keyboard.nextLine();
            
            //enter the player's jersey number
            System.out.println("Please enter the player's jersey number: ");
            
           //make sure the entered value is an integer 
           while (!stop){
               jerseyTemp = keyboard.nextLine();
               
               try{
                   Integer.parseInt(jerseyTemp);
                   stop = true;
               } catch(NumberFormatException e){
                   System.out.println("Sorry that is not acceptable, please enter an integer: ");                   
                   stop = false;
               }
               
            }
           jerseryNum = (int)Integer.parseInt(jerseyTemp);
           
           //save the variables into the player and into the bag
           teamMember = new Player(name,position,jerseryNum);
           
           footballTeam.add(teamMember);
        } 
        
        
        //printout the whole team
        System.out.println(footballTeam);
        
        //randomly remove a player
        footballTeam.remove();
        
        //print out the list again
        System.out.println(footballTeam);
        
        //add another player
        Player team9 = new Player("Dumb", "Dumber", 69);
        footballTeam.add(team9);
        
        //printout the list again
        System.out.println(footballTeam);
        
        //remove the player I just added
        footballTeam.remove(team9);
        
        //print out the list again
        System.out.println(footballTeam);
        
        //create an instance called course to store course ids of classes i am taking
        ArrayBag courses = new ArrayBag(2) {};
        
        //add my courses to the list
        courses.add("CSC161");
        courses.add("ENGL234");
        
        //print out the courses I am currently taking this semester
        System.out.println("Courses I am Taking this semester: ");
        System.out.println(courses);
        
        //randomly remove one of my classes
        courses.remove();
        
        //print out the array with having removed one of the courses
        System.out.println("Courses I am taking with one randomly removed" );
        System.out.println(courses);
        
        //create an instance of LinkedBag that contains information about the 
        //NDSU women's basketball team
        LinkedBag basketballTeam;
        basketballTeam = new LinkedBag();
        
        System.out.println("Please enter 6 players from the NDSU women's basketball team");
        for (int i = 0; i < 6; i++){
            String name = null;
            String position = null;
            int jerseryNum = 0;
            String jerseyTemp = null;
            boolean stop = false;
            Player teamMember;
            
            
            //enter the player's name
            System.out.println("Please enter the player name: ");
            name = keyboard.nextLine();
            
            //enter the player's position
            System.out.println("Please enter the player's position: ");
            position = keyboard.nextLine();
            
            //enter the player's jersey number
            System.out.println("Please enter the player's jersey number: ");
            
           //make sure the entered value is an integer 
           while (!stop){
               jerseyTemp = keyboard.nextLine();
               
               try{
                   Integer.parseInt(jerseyTemp);
                   stop = true;
               } catch(NumberFormatException e){
                   System.out.println("Sorry that is not acceptable, please enter an integer: ");                   
                   stop = false;
               }
               
            }
           jerseryNum = (int)Integer.parseInt(jerseyTemp);
           
           //save the variables into the player and into the bag
           teamMember = new Player(name,position,jerseryNum);
           
           basketballTeam.add(teamMember);
        } 
        
        //printout the whole team
        System.out.println(basketballTeam);
        
        //randomly remove a player
        basketballTeam.remove();
        
        //print out the list again
        System.out.println(basketballTeam);
        
        //add another player
        basketballTeam.add(team9);
        
        //printout the list again
        System.out.println(basketballTeam);
        
        //remove the player I just added
        basketballTeam.remove(team9);
        
        //print out the list again
        System.out.println(basketballTeam);
    }
    
}
