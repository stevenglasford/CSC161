//This piece of udder shit (aka cowshit) is for the books merge sort
//or something
import java.util.Arrays;

/**
 * This is the fucking place for the sorting algorithms bitch face fucker.
 * @author Steven Glasford
 */
public class Sort {
    //using the simple bubble sort algorithm sort that fucking list
    //vaginal cum pancakes
    //funny story about those, I once had a girl friend at South Dakota School
    //of Mines and Technology, I think her name was Sydney, anyways she was
    //really into kinky stuff, especially BDSM, but it was her "fancy" device
    //that she invented to collect her vagina fluid (she was wet as fuck)
    //then she would put the substance into different foods, luckily she
    //was not a stank, and the pancakes she made were actually pretty decent.

    /**
     * A fucking method to sort something using the new and enhanced bubble
     * sort method.
     * @param <K>           A generic placeholder, will probably be an
     *                      employee.
     * @param dildoEater    A generic array for the array you want to sort.
     * @param comp          The comparison lambda function.
     * @param maxTime       The maximum time you want the piece of shit to run.
     * @return              A string of how long it took for it to run.
     */
    public static <K> String enhancedBubbleSort(K[] dildoEater, Comparator<K>
            comp, int maxTime){
        //use this to start a "timer" of sorts
        long start = System.currentTimeMillis();
        for (int j = 0; j < dildoEater.length; j++){
            //the j in the comparison part of the for loop makes the flavor
            //enhanced, like those little knobs on fancy condoms
            for (int i = 0; i < dildoEater.length - 1 - j/*knobber*/; i++){
                if (comp.compare(dildoEater[i],dildoEater[i+1]) > 0){
                    K shitForLube;
                    shitForLube = dildoEater[i];
                    dildoEater[i] = dildoEater[i + 1];
                    dildoEater[i+1] = shitForLube;
                }
            }
            //print out a time out, if it times out
            if ((System.currentTimeMillis() - start) > maxTime){
                return "Timed";
            }
        }
        //return the elapsed time
        return Long.toString(System.currentTimeMillis() - start);
    }

    /**
     * A simpler bubble sort without the knobs on the condom.
     * @param <K>       A generic placeholder name.
     * @param scrum     A generic array that you want to be sorted, and the
     *                  action of cumming and shitting at the same time.
     * @param comp      The comparison lambda function, that you want to
     *                  to use the comparison for.
     * @param maxTime   The maximum amount of time that you wish to have this
     *                  bitch run
     * @return          A string of how long it took, or a message indictating
     *                  it timed out.
     */
    public static <K> String simpleBubbleSort(K[] scrum, Comparator<K> comp,
            int maxTime){
        long start;
        start = System.currentTimeMillis();
        for (K scrum1 : scrum) {
            for (int i = 0; i < scrum.length - 1; i++){
                if (comp.compare(scrum[i],scrum[i+1]) > 0){
                    //This variable will be used as a temporary variable of
                    //genericland, free and open trading exists between
                    //genericland and the rest of javaland, however due to a
                    //recent referendum by the generics, the peacefull
                    //existance and economic stability of both javaland
                    //and genericland are in jeopardy.
                    //also look up what schmegma is, its sort of funny,
                    K schmegma;
                    //temporarily use schmegma
                    schmegma = scrum[i];
                    //exchange the scrums (scrum is when you ejaculate and shit
                    //at the same time.
                    scrum[i] = scrum[i + 1];
                    //use the tempoary variable to finish the switch.
                    scrum[i+1] = schmegma;
                }
            }
            //print out a time out, if it times out
            if ((System.currentTimeMillis() - start) > maxTime){
                return "Timed";
            }
        }
        return Long.toString(System.currentTimeMillis() - start);
    }

    /**
     * An insertion sorting algorithm that knows how to fuck.
     * @param <K>       A generic placeholder name that is just a fucking
     *                  twat if you get to know them.
     * @param sybian    A generic array that you want to sort, and a type of
     *                  vaginal self-stimulation device that is commonplace
     *                  in BDSM.
     * @param comp      The comparison lambda expression that you want to sort.
     * @param maxTime   The maximum amount of time you want this thing to run.
     * @return          A string of how long it took, and the amount of pain
     *                  inflicted from the the Discipline, or a string
     *                  containing an error message.
     */
    /////////////////////////fuck me harder...daddy///////////////////////////
    public static <K> String insertionSort(K[] sybian, Comparator<K> comp,
            int maxTime){
        long start = System.currentTimeMillis();
        for (int i = 1; i< sybian.length; ++i){
            //make a temporary variable, BDSM should be more culturally
            //acceptable
            K urethralPlay = sybian[i];
            //A sybian is a sort of electric masturbation device for women
            //typically used in BDSM.

            //use a while loop, because they look better
            int j = i - 1;

            //compare the things
            while (j >= 0 && comp.compare(sybian[j], urethralPlay) < 0){
                sybian[j + 1] = sybian[j];
                j -= 1;
            }

            sybian[j+1] = urethralPlay;

            //use this to kill the shit if the time out is reached
            if ((System.currentTimeMillis()-start) > maxTime){
                return "Timed";
            }

        }
        //return the total time ellapsed in milliseconds
        return Long.toString(System.currentTimeMillis() - start);
    }

    /**
     * A selection sorting algorithm, pretty fucking self-explain.
     * @param <K>       A generic place holder name.
     * @param frogtie   A position in BDSM, where the femme ties their legs and
     *                  arms into a position that resembles a tied frog.
     * @param comp      The comparison lambda fucntion.
     * @param maxTime   The maximum amount of time that you want the piece of
     *                  shit to  run
     * @return          The amount of time it took to run, or an error message.
     */
    public static <K> String selectionSort(K[] frogtie, Comparator<K> comp,
            int maxTime){
        //start a timer
        long start = System.currentTimeMillis();

        for (int i = 0; i < frogtie.length -1; i++){
            //this will be the smallest found piece of shit
            int midgetsFucking = i;
            for (int j = i+1; j < frogtie.length; j++){
                if (comp.compare(frogtie[j],frogtie[midgetsFucking]) < 0){
                    midgetsFucking = j;
                }
            }

            //check the amount of time that has passed
            if ((System.currentTimeMillis() - start) > maxTime){
                return "Timed";
            }

            //swap the found minimum element, breastBondage is a temporary
            //variable
            K breastBondage = frogtie[midgetsFucking];
            frogtie[midgetsFucking] = frogtie[i];
            frogtie[i] = breastBondage;
        }

        //return the amount of time that has passed
        return Long.toString(System.currentTimeMillis() - start);
    }

    //Merge contents of arrays S1 and S2 into properly sized array S.
    //The lack of vulgarity means it was copied from the book
    /**
     * Merges two different arrays, I got this from the book.
     * @param <K>   A generic placement name.
     * @param S1    The first array you want to merge.
     * @param S2    The second array you want to merge.
     * @param S     The final array that you want to be merged into.
     * @param comp  The comparison lambda expression.
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp){
        int i = 0, j =0;
        while (i+j < S.length){
            if (j == S2.length || (i < S1.length && comp.compare(S1[i],
                    S2[j]) < 0)){
                //copy the ith element of S1 and increment i.
                S[i+j] = S1[i++];
            }
            else{
                //copy the jth element of S2 and increment j.
                S[i+j] = S2[j++];
            }
        }
    }

    //merge-sort contents of array S.
    /**
     * The actual merge sorting algorithm, this is stable.
     * @param <K>       A generic type thingy.
     * @param S         The array you want to be sorted
     * @param comp      The Comparison lambda expression.
     * @param startTime The start of the algorithm.
     * @param maxTime   The maximum amount of time you want the thing to run.
     * @return          A string containing the time it took to run, or an
     *                  error message.
     */
    public static <K> String mergeSort(K[] S, Comparator<K> comp, long startTime,
            int maxTime){
        int n = S.length;
        //array is tivially sorted
        if (n < 2) {
            return Long.toString(System.currentTimeMillis() - startTime);
        }

        if ((System.currentTimeMillis() - startTime) > maxTime){
            return "Timed";
        }

        //divide (What a weirdly vague statement from the fucking book)
        int mid = n/2;
        //copy of first half
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        //copy of second half
        K[] S2 = Arrays.copyOfRange(S,mid,n);
        //conquer (with recursion)
        //sort copy of first half
        if (mergeSort(S1, comp, startTime, maxTime).equals("Timed")){
            return "Timed";
        }
        //sort copy of second half
        if (mergeSort(S2, comp, startTime, maxTime).equals("Timed")){
            return "Timed";
        }

        //merge results
        //merge sorted halves back into original
        merge(S1, S2, S, comp);

        //return the total amount of time that has passed
        return Long.toString(System.currentTimeMillis() - startTime);
    }

    //Quick-sort contents of a queue.
    /**
     * A quick sort algorithm, that uses queues
     * @param <K>       A generic placement name.
     * @param S         A generic queue of the shit you want to sort.
     * @param comp      The comparison lambda expression.
     * @param startTime The start of the function as it is recursive.
     * @param maxTime   The maximum time you want to run the shit.
     * @return          The amount of time it took to run, or an error mess.
     */
    public static <K> String quickSort(Queue<K> S, Comparator<K> comp,
            long startTime, int maxTime){
        int n = S.size();
        //queue is trivially sorted
        if (n < 2){
            return Long.toString(System.currentTimeMillis() - startTime);
        }

        //check to see if anything has exceeded its stay
        if ((System.currentTimeMillis() - startTime) > maxTime){
            return "Timed";
        }

        //divide
        //using first as arbitrary pivot
        K pivot = S.first();
        Queue<K> P = new LinkedQueue<>();
        Queue<K> E = new LinkedQueue<>();
        Queue<K> G = new LinkedQueue<>();

        //divide original into P, E, and G
        while (!S.isEmpty()){
            K element = S.dequeue();
            int c = comp.compare(element, pivot);
            //element is less than pivot
            if (c < 0){
                P.enqueue(element);
            }
            //element is equal to pivot
            else if (c == 0){
                E.enqueue(element);
            }
            //element is greater than pivot
            else{
                G.enqueue(element);
            }
        }

        //conquer
        //sort elements less than pivot
        if (quickSort(P, comp, startTime, maxTime).equals("Timed")){
            return "Timed";
        }
        //sort elements greater than pivot
        if (quickSort(G, comp, startTime, maxTime).equals("Timed")){
            return "Timed";
        }

        //concatenate results
        while(!P.isEmpty()){
            S.enqueue(P.dequeue());
        }
        while(!E.isEmpty()){
            S.enqueue(E.dequeue());
        }
        while(!G.isEmpty()){
            S.enqueue(G.dequeue());
        }

        //return how much time has elapsed
        return Long.toString(System.currentTimeMillis() - startTime);
    }

    /**
     * A sort of radix sort that uses subroutines of of the merge sort
     * @param <K>       A generic type name.
     * @param bukkake   A bunch of men in a circle jacking off on a femme,
     *                  part of the Sadism and Masochism parts of BDSM.
     *                  Also the array you want to sort.
     * @param cock1     The first comparator (Also the least important).
     * @param cock2     The second comparator.
     * @param cock3     The third comparator.
     * @param cock4     The fourth comparator.
     * @param maxTime   The maximum amount of time you want to run the shit.
     * @return          A string containing the time it took to run, or
     *                  an error message.
     */
    public static <K> String radixSort(K[] bukkake, Comparator<K> cock1,
            Comparator<K> cock2, Comparator<K> cock3, Comparator<K> cock4,
            int maxTime){
        //get the max value from the first cock (which is the least significant
        //variable, so its the smallest cock
        //first check to see if the first cock is in place

        //start the watch
        long start = System.currentTimeMillis();
        if (cock1 != null){
            //check to see if the piece of shit timed out
            if (mergeSort(bukkake, cock1, start,maxTime).equals("Timed")){
                return "Timed";
            }
        }

        if (cock2 != null){
            //check to see if the piece of shit has timed out
            if (mergeSort(bukkake, cock2, start, maxTime).equals("Timed")){
                return "Timed";
            }
        }

        if (cock3 != null){
            //check to see if the piece of shit has timed out
            if (mergeSort(bukkake, cock3, start, maxTime).equals("Timed")){
                return "Timed";
            }
        }

        if (cock4 != null){
            //check to see if the bitch has timed out, if it has then kill it
            if (mergeSort(bukkake,cock4, start, maxTime).equals("Timed")){
                return "Timed";
            }
        }
        //suckatoof

        //return the elaspsed time
        return Long.toString(System.currentTimeMillis() - start);
    }


}
