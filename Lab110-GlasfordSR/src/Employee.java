/**
 * An class for storing information about stupid employees, I guess I should
 * not call them stupid, the пролетариат is a very important part of the
 * society, sorry כלבה.
 *
 * @author Steven Glasford
 * @version 15 April 2019
 */
public class Employee implements Comparable<Employee>{
    //this will be a random number, which is super weird, like does that mean
    //all employees are random, and that corporations hate their employees
    //my god, NDSU hates Unions, לעזאזל.
    //Anyways, facts aside, this id number is random, and between 0
    //and 99999999.
    //We also ignore the fact that we may get duplicate id numbers
    private final int id;
    //Oh Shit, these people we are making don't even have real names, they are
    //fucking slaves, they only got random letters for names, this is getting
    // more and more fucked up, it be like seeing your mate on the street and
    //instead of saying "Ahoy Oliver, what a marvelous bird carcass on the
    //ground", it be like "Howdy xcjsmkmw, it is a marvelous high tide," that
    //is fucking crazy
    //I might change this in the future to at least be a random English word,
    // like shoeFuck, or something, at least that is a name and not hvnerfew
    private final StringBuilder name = new StringBuilder();
    //o my fucking god, these people are nothing to this corporation,
    //its fucking worse than the chattle loan industry.
    //This variable is also random, and between 1 to 5
    private int dept = 0;
    //this is the date when the person was hired, at least this one is sort of
    //realistic
    private int hired = 0;

    //public utilites, like gas, electricty, and power, and garbage,
    //maybe if you live somewhere nice you get sewer and water, OOOOOhhhh.
    //initialize this fucking class, with a bunch of random shit, because
    //we at NDSU hate Unions.
    /**
     * A main instatiator class
     */
    Employee (){
        //fuck the police bitchhole
        id = (int) (Math.random() * 99999999);
        //decide how big you want that fucking name to be inside (sex)
        //add five to the number to keep it between 5 and 10
        int sizeOfTheDick = (int) (Math.random() * 5) + 5;
        for (int i = 0; i < sizeOfTheDick; i++){
            //the name will only have lowercase letters for ease of use
            name.append((char) ((int) (Math.random() * (122 - 97)) + 97));
        }
        //put these motherfuckers into a random department
        dept = (int) (Math.random() * (5-1)) + 1;
        //give them a random year they started to work
        hired = (int) (Math.random() * 10) + 2008;
    }

    /**
     * Get all of this bitching data out of the fucking class, like a fart
     * in the elevator.
     * @return  The Employees damn id number
     */
    public int getId(){
        return id;
    }

    /**
     * Get the fucking name out of here.
     * @return The cunt blasters name
     */
    public String getName(){
        return name.toString();
    }

    /**
     * Get the fucking department out of the fuck here.
     * @return The department number.
     */
    public int getDept(){
        return dept;
    }

    /**
     * One Flew over the Cookoos nest
     * @return The year the motherfucker was hired
     */
    public int getHired(){
        return hired;
    }

    /**
     * Change the year the bitch was hired.
     * @param hired the hired to set
     */
    public void setHired(int hired) {
        this.hired = hired;
    }

    /**
     * Compare two fucking employees based on their ID number
     * @param anotherFuckingEmployee A different employee you are comparing to.
     * @return  How much different the employee is to the first one.
     */
    public int compareIDTo(Employee anotherFuckingEmployee){
        return this.getId() - anotherFuckingEmployee.getId();
    }

    /**
     * This is to compare two different employees to see which is better.
     * @param paperPusher   A regular Joe, a stupid ass Employee
     * @return              An int depending on how far away the dept are.
     */
    public int compareDeptTo(Employee paperPusher){
        return this.getDept() - paperPusher.getDept();
    }

    /**
     * Compare two employees based on the year they were hired
     * @param cockTease A generic employee from genericland
     * @return          A positive or negative number, or zero if the
     *                  the two are equal.
     */
    public int compareHiredTo(Employee cockTease){
        return this.getHired() - cockTease.getHired();
    }

    /**
     * Compare the names of two people alphabetically, if the output is
     * negative then the first variable is greater, and elsewise.
     * @param managementSucks   The variable you are comparing to bitch
     * @return  A positive, negative or a zero number, zero means the two are
     *          the same, a positive number is greater than, and a negative
     *          is a less than.
     */
    public int compareNameTo(Employee managementSucks){
        //temp variables
        int i = 0, nipple = 0;

        //find the string with the least letters
        if (this.getName().length() < managementSucks.getName().length()){
            //save the smallest value into the nipple
            nipple = this.getName().length();
        }
        else if (this.getName().length() > managementSucks.getName().length()){
            //save the lower bound (which happens to be the managementSucks
            //variable
            nipple = managementSucks.getName().length();
        }
        else {
            //the fucking strings are the same length
            nipple = this.getName().length();
        }

        //this is a temporary variable and is used to measure the difference
        //between each letter in the string, a negative number corresponds to a
        //string that comes before the comparator, and vice verse
        int difference = 0;
        while ((i < nipple) && (difference == 0)){
            difference = this.getName().charAt(i) -
                    managementSucks.getName().charAt(i);

            //increase the doolly bop, which is a another word for the tensions
            //of Israel and Gaza.
            i++;
        }

        //this should be used to determine which value is bigger,
        //without the use of a ruler.
        return difference;
    }

    //this function will be a place holder, as we will use lambda expressions
    //for the compare function
    /**
     * A standard compareTo function without very much purpose, so it should
     * be a great tool, it compares the id
     * @param anotherGreatEmployee  Another fucking employee.
     * @return  An int of how far away one employee is to another.
     */
    @Override
    public int compareTo(Employee anotherGreatEmployee){
        return this.getId() - anotherGreatEmployee.getId();
    }
}
