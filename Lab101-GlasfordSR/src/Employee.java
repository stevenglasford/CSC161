/**
 * 
 * @author Steven Glasford
 * @version January 17, 2019
 * 
 * The Employee class contains information about an employee
 * 
 */
public class Employee {
    private int id = 0;
    private String name = null;
    private static int empCount = 0;    
    
    /**
     * The constructor of the employee class
     * @param id    The ID number of the employee
     * @param name  The name of the employee
     */
    public Employee(int id, String name){
        this.id=id;
        this.name=name;
        //Count the number of employees
        empCount++;
    }
    
    /**
     * 
     * @return Return the ID number of the employee
     */
    public int getId( ){
        return id;
    }
    
    /**
     * 
     * @return Return the name of the employee
     */
    public String getName( ) {
        return name;
    }

    /**
     * 
     * @param o A nondescript object
     * @return Whether or not the object o is an instance of the class employee
     */
    public boolean equals(Object o){
        if (!(o instanceof Employee))
            return false;
        //cast the object o into the employee class if able
        Employee e = (Employee) o;
        
        return id == e.id
                && name.equals(e.name);
    }
    
    /**
     * 
     * @return Return the total number of employees
     */
    public int empNum(){
        return empCount;
    }
    
    /**
     * 
     * @return Return the string of information for the employee, including
     * the name and the ID number of the user
     */
    public String toString(){
        return  getId() + " : " + getName() + " , " ;
    }    
    
}

