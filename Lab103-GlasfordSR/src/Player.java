/**
 *
 * @author Steven Glasford
 * @version January 31, 2019
 * 
 * A structure to contain data about the player
 */
public class Player{
    String name = null;
    String position = null;
    int jerseyNum = 0;
    
    /**
     * 
     * @param name          The name of the player
     * @param position      The position of the player
     * @param jerseyNum `   The jersey number of the player
     */
    public Player (String name, String position, int jerseyNum) {
        this.jerseyNum=jerseyNum;
        this.position=position;
        this.name=name;
    }
    
    /**
     * 
     * @return the name of the player
     */
    public String getName() {return name;}
    
    /**
     * 
     * @return The position of the player
     */
    public String position() {return position;}
    
    /**
     * 
     * @return Return the jersey number of the player
     */
    public int jersey() {return jerseyNum;}
    
    /**
     * 
     * @return Return the contents of the player class into a string
     */
    public String toString() {
        return name + ", " + position + ", " + jerseyNum + "\n";
    }
}
