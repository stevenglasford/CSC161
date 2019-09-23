/**
 *
 * @author Steven Glasford
 * @version 1.00    2-28-19
 */
public class Client {

    /**
     * @param args none
     */
    public static void main(String[] args) {
        //
        LuckyNumberList lucky = new LuckyNumberList();

        //These are some of my names, notice how foreign some are
        LuckyNumber name1 = new LuckyNumber("Jules");
        LuckyNumber name2 = new LuckyNumber("Patty");
        LuckyNumber name3 = new LuckyNumber("Ciao");
        LuckyNumber name4 = new LuckyNumber("Glove");
        LuckyNumber name5 = new LuckyNumber("Dumb");
        LuckyNumber name6 = new LuckyNumber("Bri");
        LuckyNumber name7 = new LuckyNumber("Table");
        LuckyNumber name8 = new LuckyNumber("Steven");
        LuckyNumber name9 = new LuckyNumber("Pharell");
        LuckyNumber name0 = new LuckyNumber("Pitbull");

        //add the names to the list
        lucky.addLuckyNumber(name0);
        lucky.addLuckyNumber(name1);
        lucky.addLuckyNumber(name2);
        lucky.addLuckyNumber(name3);
        lucky.addLuckyNumber(name4);
        lucky.addLuckyNumber(name5);
        lucky.addLuckyNumber(name6);
        lucky.addLuckyNumber(name7);
        lucky.addLuckyNumber(name8);
        lucky.addLuckyNumber(name9);

        //create a default list iterator
        Iterator<Position> luckyListIterator = lucky.positions().iterator();
        //create a prime list iterator
        Iterator<Position<LuckyNumber>> primeListIterator =
                lucky.primePositions().iterator();
        //create a
        Iterator<Position<LuckyNumber>> evenListIterator =
                lucky.evenPositions().iterator();

        System.out.println("Print out all of the Bitches.");

        String defaultList  = "";
        String evenList     = "";
        String primeList    = "";

        //create the default list
        while (luckyListIterator.hasNext()){
            LuckyNumber temp =
                    (LuckyNumber) luckyListIterator.next().getElement();

            defaultList = defaultList + temp.toString() + "\t\t";

            //if the thing is even print out an even string
            if (temp.isEven())
                defaultList += "Even\t\t";
            //if it isn't even print out an odd
            else
                defaultList += "Odd\t\t";

            if(temp.isPrime())
                defaultList += "Prime\n";
            else
                defaultList += "Not Prime\n";
        }
        //print out the default
        System.out.println(defaultList);



        //create the prime list
        System.out.println("\nUsing the PrimeListIterator");
        while (primeListIterator.hasNext()){
            LuckyNumber temp =
                    (LuckyNumber) primeListIterator.next().getElement();

            primeList = primeList + temp.toString() + "\t\t";

            if (temp.isEven())
                primeList += "Even\t\t";
            else
                primeList += "Odd\t\t";

            if(temp.isPrime())
                primeList += "Prime\n";
            else
                primeList += "Not Prime\n";
        }
        //print out the prime list
        System.out.println(primeList);


        //create the even list stuff
        System.out.println("\nUsing the EvenListIterator");
        while (evenListIterator.hasNext()){
            LuckyNumber temp =
                    (LuckyNumber) evenListIterator.next().getElement();

            evenList = evenList + temp.toString() + "\t\t";

            if (temp.isEven())
                evenList += "Even\t\t";
            else
                evenList += "Odd\t\t";

            if(temp.isPrime())
                evenList += "Prime\n";
            else
                evenList += "Not Prime\n";
        }
        
        //print out the even list
        System.out.println(evenList);


    }

}
