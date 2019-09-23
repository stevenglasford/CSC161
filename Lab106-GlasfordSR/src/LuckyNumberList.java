
import java.util.NoSuchElementException;

/**
 * A list of lucky Numbers.
 * @author Steven Glasford
 * @version 1.00    2-26-2019
 */
public class LuckyNumberList {
    private LinkedPositionalList luckyNumber = null;

    /**
     * Constructor builds an empty LinkedPositionalList.
     */
    public LuckyNumberList (){
        luckyNumber = new LinkedPositionalList();
    }

    /**
     * Add a number to the list.
     * @param item The item you want to add.
     */
    public void addLuckyNumber(LuckyNumber item){
        luckyNumber.addLast(item);
    }

    /**
     * Determine if the number is even.
     * @param item  the number you want to determine if the lucky number
     *              is even
     * @return      Whether the item is even
     */
    public boolean isEven(LuckyNumber item){
        return ((item.getLuckyNumber() % 2) == 0);
    }

    /**
     * Determine if the number is a prime. This will only work for numbers
     * between 0 and 9, which shouldn't be an issue in this program, since the
     * value never exceeds 9, or 0.
     * @param item  The item you want to determine its primeness
     * @return      Whether the item is a prime
     */
    public boolean isPrime(LuckyNumber item){
        return ((item.getLuckyNumber() == 2) ||
                (item.getLuckyNumber() == 3) ||
                (item.getLuckyNumber() == 5) ||
                (item.getLuckyNumber() == 7));
    }

    /**
     * Convert the thing to a string.
     * @return  a string.
     */
    public String toString(){
        String returnString = "";

        Iterator listIterator = luckyNumber.iterator();

        while (listIterator.hasNext()){
            returnString += listIterator.next() + "\n";
        }

        return returnString;
    }

    //
    // The following classes are the nested Iterator classes from
    // Code Fragment 7.14
    //
    // Only the classes for the Position Itertor have bee included.
    //
    // These fragements have been modified so that they are specific to the
    // Alphabet class.
    //
    // It is necessary to put the iterator code here since we want to create
    // iterators specifically for the Alphabet class which is a concrete class
    // based on the generic ADT LinkedPositionalList.
    //
    // Our code needs to have knowledge of Letter.
    //
    // Generally the Generic placeholders <E> have been replaced with
    // concret references <Letter>
    // AND
    // Call to LinkedPositionalList methods have be replaced by calls using
    // the instance reference alphabet
    // e.g.
    // private Position<Letter> cursor = first();
    // became
    // private Position<Letter> cursor = alphabet.first();
    //

    //----- nested PositionIterator class -----
    private class PositionIterator implements Iterator<Position>{
        // position of the next element to report
        private Position cursor = luckyNumber.first();
        // position of last reported element
        private Position recent = null;
        /** Tests whether the iterator has a next object. */
        @Override
        public boolean hasNext( ) { return ( cursor != null ); }
        /** Returns the next position in the iterator. */
        @Override
        public Position next( ) throws NoSuchElementException {
            if ( cursor == null ) throw new NoSuchElementException(
                    "nothing left " );
            recent = cursor;
            cursor = luckyNumber.after( cursor );
            return recent;
        }
        /** Removes the element returned by most recent call to next. */
        @Override
        public void remove( ) throws IllegalStateException {
            if ( recent == null ) throw new IllegalStateException(
                    "nothing to remove" );
            // remove from outer list
            luckyNumber.remove( recent );
            // do not allow remove again until next is called
            recent = null;
        }
    } //----- end of nested PositionIterator class -----

        //----- nested PositionIterable class -----
    private class PositionIterable implements Iterable<Position>{
        @Override
        public Iterator<Position> iterator( ) { return new
        PositionIterator( ); }
    } //----- end of nested PositionIterable class -----

    /** Returns an iterable representation of the list's positions.
     * @return  */
    public Iterable<Position> positions( ) {
        // create a new instace of the inner class
        return new PositionIterable( );
    }

        //----- nested PositionIterator class -----
    private class EvenPositionIterator implements
            Iterator<Position<LuckyNumber>>{
        // position of the next element to report
        private Position<LuckyNumber> cursor = luckyNumber.first();
        // position of last reported element
        private Position<LuckyNumber> recent = null;
        /** Tests whether the iterator has a next object. */
        @Override
        public boolean hasNext( ) { return ( cursor != null ); }
        /** Returns the next position in the iterator. */
        @Override
        public Position<LuckyNumber> next( ) throws NoSuchElementException {
            //<<< new code
            // On the first call to next (i.e. when recent == null) you need to
            //<<< new code
            // advance recent until it is pointing to a vowel element.
            //<<< new code
            if ( recent == null )
                //<<< new code
            {
                //determine if the thing is even
                while ( cursor != null && !isEven(cursor.getElement()) )
                    //<<< new code
                    cursor = luckyNumber.after( cursor );
                //<<< new code
            }

            if ( cursor == null ) throw new NoSuchElementException(
                    "nothing left " );
            recent = cursor;
            cursor = luckyNumber.after( cursor );

            // advance cursor to the next vowel

            while ( cursor != null && !isEven(cursor.getElement()) )
                cursor = luckyNumber.after( cursor );

            return recent;
        }

        /** Removes the element returned by most recent call to next. */
        @Override
        public void remove( ) throws IllegalStateException {
            if ( recent == null ) throw new IllegalStateException(
                    "nothing to remove" );
            luckyNumber.remove( recent );         // remove from outer list
            // do not allow remove again until next is called
            recent = null;
        }

        public boolean isEven(LuckyNumber item) {
            return ((item.getLuckyNumber() % 2) == 0);
        }


    }
        //----- end of nested PositionIterator class -----




    private class EvenPositionIterable implements Iterable<Position<LuckyNumber>>{
        @Override
        public Iterator<Position<LuckyNumber>> iterator( ) { return new
            EvenPositionIterator( );
        }
    }
     //----- end of nested PositionIterable class -----

    /** Returns an iterable representation of the list's positions.
     * @return  */
    public Iterable<Position<LuckyNumber>> evenPositions( ) {
        // create a new instace of the inner class
        return new EvenPositionIterable( );
    }

        //----- nested PositionIterator class -----
    private class PrimePositionIterator implements
            Iterator<Position<LuckyNumber>>{
        // position of the next element to report
        private Position<LuckyNumber> cursor = luckyNumber.first();
        // position of last reported element
        private Position<LuckyNumber> recent = null;
        /** Tests whether the iterator has a next object. */
        @Override
        public boolean hasNext( ) { return ( cursor != null ); }
        /** Returns the next position in the iterator. */
        @Override
        public Position<LuckyNumber> next( ) throws NoSuchElementException {
            //<<< new code
            // On the first call to next (i.e. when recent == null) you need to
            //<<< new code
            // advance recent until it is pointing to a vowel element.
            //<<< new code
            if ( recent == null )
                //<<< new code
            {
                //<<< new code
                while ( cursor != null && !isPrime(cursor.getElement()) )
                    //<<< new code
                    cursor = luckyNumber.after( cursor );
                //<<< new code
            }

            if ( cursor == null ) throw new NoSuchElementException(
                    "nothing left " );
            recent = cursor;
            cursor = luckyNumber.after( cursor );

            // advance cursor to the next vowel

            while ( cursor != null && !isPrime(cursor.getElement()) )
                cursor = luckyNumber.after( cursor );

            return recent;
        }

        /** Removes the element returned by most recent call to next. */
        @Override
        public void remove( ) throws IllegalStateException {
            if ( recent == null ) throw new IllegalStateException(
                    "nothing to remove" );
            luckyNumber.remove( recent );         // remove from outer list
            // do not allow remove again until next is called
            recent = null;
        }

        public boolean isPrime(LuckyNumber item) {
            return ((item.getLuckyNumber() == 2) ||
                (item.getLuckyNumber() == 3) ||
                (item.getLuckyNumber() == 5) ||
                (item.getLuckyNumber() == 7));
        }


    }
        //----- end of nested PositionIterator class -----




    private class PrimePositionIterable implements Iterable<Position<LuckyNumber>>{
        @Override
        public Iterator<Position<LuckyNumber>> iterator( ) { return new
            PrimePositionIterator( );
        }
    }
     //----- end of nested PositionIterable class -----

    /** Returns an iterable representation of the list's positions.
     * @return  */
    public Iterable<Position<LuckyNumber>> primePositions( ) {
        // create a new instace of the inner class
        return new PrimePositionIterable( );
    }
}

