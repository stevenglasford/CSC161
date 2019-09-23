/**
 *
 * @author Steven Glasford
 * 
 * @version January 17, 2019
 * 
 * The Hourly Class contains the information about the employee
 * including the name position and hourly rate for an hourly worker 
 */
public class Hourly extends Employee {
    private String position;
    private double hourlyRate;
    private static int hourlyCount;
    
    
    /**
     * 
     * @param id            The ID number of the employee
     * @param name          The name of the employee
     * @param position      The position held by the employee
     * @param hourlyRate    The hourly rate of the employee
     */
    public Hourly(int id, String name, String position, double hourlyRate){
        super (id, name);
        this.position=position;
        this.hourlyRate=hourlyRate;
        hourlyCount++;
    }
    
    
    /**
     * apply a raise
     * @return false if the employee's income doesn't make sense
     */
    public boolean raise(){    
        if (hourlyRate < 0)
            return false;
        
        //apply the raise
        hourlyRate = (double) ((hourlyRate * .10) + hourlyRate);
        return true;
    }
    
    /**
     * 
     * @return the number of total hourly employees
     */
    public int hourlyNum(){
        return hourlyCount;
    }
    
    /**
     * 
     * @return the string containing the position and hourly rate, as well as
     * information from the super class
     */
    public String toString(){
        return super.toString() + " " + getClass().getName() + " @ " + position
                + " : $" + hourlyRate ;
    }
    
}

