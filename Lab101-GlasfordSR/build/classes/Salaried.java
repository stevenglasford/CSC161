/**
 *
 * @author Steven Glasford
 * 
 * @version January 17, 2019
 * 
 * The Salaried class contains information about all of the salaried employees
 * and is a subclass of the superclass of Employee. Each salaried employee has
 * a title and a salary
 */
public class Salaried extends Employee {
    private String title;
    public int salary;
    private static int salariedCount;
    
    /**
     * 
     * @param id        The Employee's ID number
     * @param name      The name of the Employee
     * @param title     The title held by the salaried employee
     * @param salary    The salary of the employee
     */
    public Salaried(int id, String name, String title, int salary){
        super(id, name);
        this.title=title;
        this.salary=salary;
        salariedCount++;
    }
    
    /**
     * 
     * @return Return the number of salaried employees
     */
    public int salaryNum(){
        return salariedCount;
    }
    
    /**
     * 
     * @param o a nondescript object
     * @return return whether the object is an instance of a salaried class
     */
    public boolean equals(Object o){
        if (!(o instanceof Salaried))
            return false;
        Salaried s = (Salaried) o;
        return true;
    }
    
    /**
     * Apply the raise for the salaried employee
     * 
     * @return whether or not the employee's salary makes sense (aka makes
     * sure the employee makes a positive income) 
     */
    public boolean raise(){
        if (salary < 0)
            return false;
        
        salary = (int) (((double) salary * .10) + (double) salary);
        return true;
    }
    
    /**
     * 
     * @return a string containing information from the employee class
     * as well as title and salary information
     */
    public String toString(){
        return super.toString() + " " + getClass().getName() + " @ " + title 
                + " : $" + salary ;
    }

}