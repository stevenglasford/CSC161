/**
 *
 * @author Steven Glasford
 * @version January 31, 2019
 * @param <E> a generic placeholder
 */
public class LinkedBag<E> implements Bag{
    //initialize the empty list
    SinglyLinkedList list;
    int count;

    //construct an empty list
    /**
     * A constructor for the class
     */
    public LinkedBag(){
        list = new SinglyLinkedList();
        count = list.size();
    }

    /**
     *
     * @return true if the bag is empty
     */
    @Override
    public boolean isEmpty() {return list.isEmpty();}

    /**
     *
     * @param thing something you want to add
     *
     * I want to add the thing at the end
     */
    @Override
    public void add (Object thing){
        list.addLast(thing);
    }

    //

    /**
     *
     * @return return the current size of the list
     *
     */
    @Override
    public int getCurrentSize(){
        return list.size();
    }

    //find the first instance of an object and destroy it

    /**
     *
     * @param thing an object that you want to remove
     * @return whether or not the object was removed from the list
     */
    @Override
    public boolean remove (Object thing){

        for (int i = 0; i < list.size(); i++){
            //keep in memory the removed item, and remove it
            Object e = list.removeFirst();
            if (thing.equals(e))
                thing = e;
            else
                list.addLast(e);
        }

        //if the list is fully traversed and not found return false
        return false;
    }

        //randomly remove an entrant
    /**
     *
     * @return the object that was randomly removed
     */
    @Override
    public Object remove() {
        //get the random entrant that is going to be destroyed
        int random = (int)(Math.random() * list.size() + 1);

        //this will be the object that is going to be removed, stored temporarily
        Object thing = null;

        //traverse the list, keeping order, and removing the item
        for (int i = 0; i < list.size(); i++){
            //keep in memory the removed item, and remove it
            Object e = list.removeFirst();
            if (i == (random))
                thing = e;
            else
                list.addLast(e);
        }

        //return the object that was removed
        return thing;
    }

    //destroy the list

    /**
     * destroy the bag
     */
    @Override
    public void clear( ){
        for (int i = 0; i < list.size(); i++)
            list.removeFirst();
    }

    //go through the list and determine the frequency of an object

    /**
     *
     * @param thing an object that you want to search for
     * @return the number of times that the object was found in the bag
     */
    @Override
    public int getFrequencyOf(Object thing){
        int frequency = 0;

        for (int i = 0; i < list.size(); i++){
            //if found increase the frequency
            if (thing.equals(list.first()))
                frequency++;

            //rotate the list to the next variable
            list.addLast(list.removeFirst());
        }

        //return the frequency of the object
        return frequency;
    }

    //determine if the list contains an object

    /**
     *
     * @param thing an object that you are looking for
     * @return returns whether or not the object is contained in the bag
     */
    @Override
    public boolean contains(Object thing){
        boolean truth = false;
        for (int i = 0; i < list.size(); i++){
            //keep in memory the removed item, and remove it
            Object e = list.removeFirst();
            if (thing.equals(e))
                truth = true;

            list.addLast(e);
        }

        //return false if never found
        return truth;
    }

    /**
     *
     * @return convert the bag into a string
     */
    @Override
    public String toString( ){
        String words = null;

        words = "[ ";

        //return an empty list if the list is empty
        if (list.size() == 0){
            return (words + "]");
        }

        //rotate the list to get the next item
        for (int i = 0; i < list.size(); i++) {
            //get the first variable
            words = words + list.first() + ", ";
            //send the first variable in the list to the back
            list.addLast(list.first());
            //remove the first variable after moving it to the back
            list.removeFirst();
        }

        words += " ]";

        return words;
    }



    //get the item at a particular location in the list
    public Object get(int i){
        Object thing = null;
        //if the user tries to find a spot that doesn't exist return null
        if (i > list.size())
            return thing;

        for (int j = 0; j < (list.size()); j++){
            if (j == (i)){
                thing = list.first();
            }
            //traverse the list to keep order
            list.addLast(list.first());
            list.removeFirst();
        }
        return thing;
    }


}
