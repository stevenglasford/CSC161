/**
 * A main class for the program.
 *
 * @author Steven Glasford
 */
public class Client {

    /**
     * A main class for the program.
     * @param args none
     */
    public static void main(String[] args) {

        int power = 8;

        long[][] aStackTimes = new long[power][3];
        long[][] lStackTimes = new long[power][3];
        long[][] aQueueTimes = new long[power][3];
        long[][] lQueueTimes = new long[power][3];
        long[][] aListTimes = new long[power][3];

        //create an ArrayStack
        ArrayStack astack = new ArrayStack(100000000);
        LinkedStack lstack = new LinkedStack();
        ArrayQueue aqueue = new ArrayQueue(10000000);
        LinkedQueue lqueue = new LinkedQueue();
        ArrayList alist = new ArrayList(100000000);

        //start a timer
        long start, stop;


        // a for loop to see what the push and pop times are for a thing
        for (int i = 0; i < power; i++){

            aStackTimes[i][0] = (long) Math.pow(10,(i));
            //Use the array stack method first
            start = System.nanoTime();



            //insert the number 0 ten times
            for (int j = 0; j < (Math.pow(10,(i))); j++){
                astack.push(0);
            }
            //end timer
            stop = System.nanoTime();
            //save the time into the first part of the 2 d array
            aStackTimes[i][1] = (long) (stop - start);

            start = System.nanoTime();
            //remove the thing
            for (int j = 0; j < Math.pow(10,(i)); j++){
                astack.pop();
            }
            //end timer
            stop = System.nanoTime();
            //save the time into the first part of the 2 d array
            aStackTimes[i][2] = (long) (stop - start);
        }


        //for the linked stack
        for (int i = 0; i < power; i++){

            //Use the linked stack method first
            lStackTimes[i][0] = (long) Math.pow(10,(i));
            start = System.nanoTime();
            //insert the number 0 ten times
            for (int j = 0; j < (Math.pow(10,(i ))); j++){
                lstack.push(0);
            }
            //end timer
            stop = System.nanoTime();
            //save the time into the first part of the 2 d array
            lStackTimes[i][1] = (long) (stop - start);

            start = System.nanoTime();
            //remove the thing
            for (int j = 0; j < Math.pow(10,(i)); j++){
                lstack.pop();
            }
            //end timer
            stop = System.nanoTime();
            //save the time into the first part of the 2 d array
            lStackTimes[i][2] = (long) (stop - start);
        }


        //for the ArrayQueue
        for (int i = 0; i < power; i++){

            aQueueTimes[i][0] = (long) Math.pow(10,(i));
            //Use the array queue method first
            start = System.nanoTime();
            //insert the number 0 ten times
            for (int j = 0; j < (Math.pow(10,(i ))); j++){
                aqueue.enqueue(0);
            }
            //end timer
            stop = System.nanoTime();
            //save the time into the first part of the 2 d array
            aQueueTimes[i][1] = (long) (stop - start);

            start = System.nanoTime();
            //remove the thing
            for (int j = 0; j < Math.pow(10,(i)); j++){
                aqueue.dequeue();
            }
            //end timer
            stop = System.nanoTime();
            //save the time into the first part of the 2 d array
            aQueueTimes[i][2] = (long) (stop - start);
        }

        for (int i = 0; i < power; i++){
            //Use the linked queue method first
            lQueueTimes[i][0] = (long) Math.pow(10,(i));

            start = System.nanoTime();
            //insert the number 0 ten times
            for (int j = 0; j < (Math.pow(10,(i))); j++){
                lqueue.enqueue(0);
            }
            //end timer
            stop = System.nanoTime();
            //save the time into the first part of the 2 d array
            lQueueTimes[i][1] = (long) (stop - start);

            start = System.nanoTime();
            //remove the thing
            for (int j = 0; j < Math.pow(10,(i)); j++){
                lqueue.dequeue();
            }
            //end timer
            stop = System.nanoTime();
            //save the time into the first part of the 2 d array
            lQueueTimes[i][2] = (long) (stop - start);
        }

        //For the lists
        for (int i = 0; i < power; i++){
            //Use the linked queue method first
            aListTimes[i][0] = (long) Math.pow(10,(i));

            start = System.nanoTime();
            //insert the number 0 ten times
            for (int j = 0; j < (Math.pow(10,(i))); j++){
                alist.add(0);
            }
            //end timer
            stop = System.nanoTime();
            //save the time into the first part of the 2 d array
            aListTimes[i][1] = (long) (stop - start);

            start = System.nanoTime();
            //remove the thing
            for (int j = 0; j < Math.pow(10,(i)); j++){
                alist.remove();
            }
            //end timer
            stop = System.nanoTime();
            //save the time into the first part of the 2 d array
            aListTimes[i][2] = (long) (stop - start);
        }

        AsciiTableStack(aStackTimes,"ArrayStack");

        System.out.println("\n");

        AsciiTableStack(lStackTimes,"LinkStack");

        System.out.println("\n");

        AsciiTableQueue(aQueueTimes,"ArrayQueue");

        System.out.println("\n");

        AsciiTableQueue(lQueueTimes, "LinkedQueue");

        System.out.println("\n");

        AsciiTableList(aListTimes, "ArrayList");
    }

    //use the a standard of 80 character max for the table, because of latex
    public static void AsciiTableStack(long[][] data, String title){
        String table = String.format( "+%-77s+", "").replace(" ", "-");

        table = table + "\n|" + center(title,77) + "|\n";

        table = table + String.format( "+%-12s+", "").replace(" ", "-")
                    + String.format( "%-32s+", "").replace(" ", "-")
                    + String.format( "%-31s+\n", "").replace(" ", "-");

        table = table + "|" + center("N",12) + "|" +
                    center("Push", 32) + "|" +
                    center("Pop", 31) + "|\n";

        table = table + String.format( "+%-12s+", "").replace(" ", "-")
                    + String.format( "%-32s+", "").replace(" ", "-")
                    + String.format( "%-31s+\n", "").replace(" ", "-");

        for (long[] data1 : data) {
            table = table + "|" + center(Long.toString(data1[0]),12) + "|" +
                    center(Long.toString(data1[1]), 32) + "|" +
                    center(Long.toString(data1[2]), 31) + "|\n";
            table = table + String.format( "+%-12s+", "").replace(" ", "-")
                    + String.format( "%-32s+", "").replace(" ", "-")
                    + String.format( "%-31s+\n", "").replace(" ", "-");
        }


        System.out.println(table);

        return;
    }

    public static void AsciiTableQueue(long[][] data, String title){
        String table = String.format( "+%-77s+", "").replace(" ", "-");

        table = table + "\n|" + center(title,77) + "|\n";

        table = table + String.format( "+%-12s+", "").replace(" ", "-")
                    + String.format( "%-32s+", "").replace(" ", "-")
                    + String.format( "%-31s+\n", "").replace(" ", "-");

        table = table + "|" + center("N",12) + "|" +
                    center("Enqueue", 32) + "|" +
                    center("Dequeue", 31) + "|\n";

        table = table + String.format( "+%-12s+", "").replace(" ", "-")
                    + String.format( "%-32s+", "").replace(" ", "-")
                    + String.format( "%-31s+\n", "").replace(" ", "-");

        for (long[] data1 : data) {
            table = table + "|" + center(Long.toString(data1[0]),12) + "|" +
                    center(Long.toString(data1[1]), 32) + "|" +
                    center(Long.toString(data1[2]), 31) + "|\n";
            table = table + String.format( "+%-12s+", "").replace(" ", "-")
                    + String.format( "%-32s+", "").replace(" ", "-")
                    + String.format( "%-31s+\n", "").replace(" ", "-");
        }


        System.out.println(table);

        return;
    }

    public static void AsciiTableList(long[][] data, String title){
        String table = String.format( "+%-77s+", "").replace(" ", "-");

        table = table + "\n|" + center(title,77) + "|\n";

        table = table + String.format( "+%-12s+", "").replace(" ", "-")
                    + String.format( "%-32s+", "").replace(" ", "-")
                    + String.format( "%-31s+\n", "").replace(" ", "-");

        table = table + "|" + center("N",12) + "|" +
                    center("Add", 32) + "|" +
                    center("Remove", 31) + "|\n";

        table = table + String.format( "+%-12s+", "").replace(" ", "-")
                    + String.format( "%-32s+", "").replace(" ", "-")
                    + String.format( "%-31s+\n", "").replace(" ", "-");

        //add the data from the array into the table
        for (long[] data1 : data) {
            table = table + "|" + center(Long.toString(data1[0]),12) + "|" +
                    center(Long.toString(data1[1]), 32) + "|" +
                    center(Long.toString(data1[2]), 31) + "|\n";
            table = table + String.format( "+%-12s+", "").replace(" ", "-")
                    + String.format( "%-32s+", "").replace(" ", "-")
                    + String.format( "%-31s+\n", "").replace(" ", "-");
        }


        System.out.println(table);

        return;
    }

    /**
     * Take a string and center it within a certain amount of given space.
     * @param text  The text you want to center
     * @param len   The possible space you want to center within
     * @return
     */
    public static String center(String text, int len){
        if (len <= text.length())
            return text.substring(0, len);
        int before = (len - text.length())/2;
        if (before == 0)
            return String.format("%-" + len + "s", text);
        int rest = len - before;
        return String.format("%" + before + "s%-" + rest + "s", "", text);
    }
}
