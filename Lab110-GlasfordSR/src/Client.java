/**
 * A main class controlling everything rekcufrehtom bitch.
 * @author Steven Glasford
 * @version 1
 */
public class Client {

    /**
     * @param args No command line shit, כוס
     */
    public static void main(String[] args) {
         //make the max time for the shitfuckers to run, in this case the
        //maximum amount of time that will pass for any of the sorting
        //algorithms is 60000 milliseconds, which is equafilant to ten minutes
        final int MAX_TIME = 60000;

        //an array to store all of the information that I came to see on the
        //whatever, I am hungry.
        String[][] data = new String[8][6];

        //make fucking comparators for each potential
        //sort employees by name
        Comparator<Employee> employeeName, employeeID, employeeHired,
                employeeDept;

        //this lambda expression will be used to facilitate
        //by name comparisons of employees
        employeeName = Employee::compareNameTo;

        //this lambda expression will be used to compare by ID number
        employeeID = Employee::compareIDTo;

        //this lambda expression will be used to compare the hire dates of
        //employees
        employeeHired = Employee::compareHiredTo;

        //this lambda expression will be used to compare the departments of
        //the employees
        employeeDept = Employee::compareDeptTo;

        //the system can support from 1e3 to 1e9
        for (int i = 0; i < data[0].length; i++){
            //the number in question for N
            double N = Math.pow(10,i + 3);
            //save the number for N
            data[0][i] = Integer.toString((int) N);

            //create the fucker that will be sorted use a try block incase
            //of memory errors
            //start a timer
            long start = System.currentTimeMillis();

            Employee[] cockTwist = new Employee[(int) N];
            try {
                //fill in the array with stupid fucking employees
                for (int j = 0; j < N; j++){
                    cockTwist[j] = new Employee();
                    if ((System.currentTimeMillis() - start) > MAX_TIME){
                        data[1][i] = "Timed";
                    }
                }
            }
            //save the memory error if you ran out of memory.
            catch (OutOfMemoryError e){
                data[1][i] = "memed";
            }

            //if there was not a memory error finding space, then save the time
            if (data[1][i] == null){
                data[1][i] = Integer.toString((int) (System.currentTimeMillis()
                        - start));
            }



            if (data[1][i].equals("Timed")){
                data[2][i] = "N/A";
            }
            else{
                try{
                    //fill in the array with stupid fucking employees
                for (int j = 0; j < N; j++){
                    cockTwist[j] = new Employee();
                    if ((System.currentTimeMillis() - start) > MAX_TIME){
                        data[1][i] = "Timed";
                    }
                }
                    //store the time it took for the thing to work
                    data[2][i] = Sort.simpleBubbleSort(cockTwist,
                            employeeID, MAX_TIME);
                }
                //produce an out of memory error if there is not enough memory
                catch (OutOfMemoryError e){
                    data[2][i] = "memed";
                }
            }

            if (data[1][i].equals("Timed")){
                data[3][i] = "N/A";
            }
            else{
                //create another temporary array to copy the piece of shit into
                try{
                    //fill in the array with stupid fucking employees
                for (int j = 0; j < N; j++){
                    cockTwist[j] = new Employee();
                    if ((System.currentTimeMillis() - start) > MAX_TIME){
                        data[1][i] = "Timed";
                    }
                }
                    data[3][i] = Sort.enhancedBubbleSort(cockTwist,
                            employeeHired, MAX_TIME);
                }
                //catch a memory error
                catch (OutOfMemoryError e){
                    data[3][i] = "memed";
                }
            }

            if (data[1][i].equals("Timed")){
                data[4][i] = "N/A";
            }
            else{
                //try the selection sort
                try{
                    //fill in the array with stupid fucking employees
                for (int j = 0; j < N; j++){
                    cockTwist[j] = new Employee();
                    if ((System.currentTimeMillis() - start) > MAX_TIME){
                        data[1][i] = "Timed";
                    }
                }
                    data[4][i] = Sort.selectionSort(cockTwist,
                            employeeID, MAX_TIME);
                }
                //catch a memory error
                catch (OutOfMemoryError e){
                    data[4][i] = "memed";
                }
            }

            if (data[1][i].equals("Timed")){
                data[5][i] = "N/A";
            }
            else{
                //try the merge sort
                try{
                    //fill in the array with stupid fucking employees
                for (int j = 0; j < N; j++){
                    cockTwist[j] = new Employee();
                    if ((System.currentTimeMillis() - start) > MAX_TIME){
                        data[1][i] = "Timed";
                    }
                }
                    data[5][i] = Sort.mergeSort(cockTwist, employeeID,
                            System.currentTimeMillis(), MAX_TIME);
                }
                //catch a memory error
                catch (OutOfMemoryError e){
                    data[5][i] = "memed";
                }
            }

            if (data[1][i].equals("Timed")){
                data[6][i] = "N/A";
            }
            else{
                //try the radix sort
                try{
                    //fill in the array with stupid fucking employees
                for (int j = 0; j < N; j++){
                    cockTwist[j] = new Employee();
                    if ((System.currentTimeMillis() - start) > MAX_TIME){
                        data[1][i] = "Timed";
                    }
                }
                    data[6][i] = Sort.radixSort(cockTwist,employeeDept,
                            employeeHired,employeeName,employeeID,MAX_TIME);
                }
                //catch a memory error
                catch (OutOfMemoryError e){
                    data[6][i] = "memed";
                }
            }

            if (data[1][i].equals("Timed")){
                data[7][i] = "N/A";
            }
            else{
                //insertion sort
                try{
                    //fill in the array with stupid fucking employees
                for (int j = 0; j < N; j++){
                    cockTwist[j] = new Employee();
                    if ((System.currentTimeMillis() - start) > MAX_TIME){
                        data[1][i] = "Timed";
                    }
                }
                    data[7][i] = Sort.insertionSort(cockTwist,
                            employeeName,MAX_TIME);
                }
                //catch a memory error
                catch (OutOfMemoryError e){
                    data[7][i] = "memed";
                }
            }
        }

        StringBuilder table = new StringBuilder();
        //print out all the data

        table.append("N/A means the table was not able to be made for");
        table.append(" whatever reason \n");
        table.append("'memed' is indicative of a memory error, such as it ");
        table.append("takes too much memory\n");
        table.append("'Timed' means the particular function timed out\n");
        table.append("Creat\t\t");
        for (String item : data[0]) {
            table.append(item);
            table.append("\t\t");
        }
        table.append("\n");

        table.append("sBub\t\t");
        for (String item : data[1]) {
            table.append(item);
            table.append("\t\t");
        }
        table.append("\n");

        table.append("eBub\t\t");
        for (String item : data[2]) {
            table.append(item);
            table.append("\t\t");
        }
        table.append("\n");

        table.append("sBub\t");
        for (String item : data[3]) {
            table.append(item);
            table.append("\t\t");
        }
        table.append("\n");

        table.append("slct\t");
        for (String item : data[4]) {
            table.append(item);
            table.append("\t\t");
        }
        table.append("\n");

        table.append("merge\t");
        for (String item : data[5]) {
            table.append(item);
            table.append("\t\t");
        }
        table.append("\n");

        table.append("radix\t");
        for (String item : data[6]) {
            table.append(item);
            table.append("\t\t");
        }
        table.append("\n");

        table.append("insrt\t");
        for (String item : data[7]) {
            table.append(item);
            table.append("\t\t");
        }
        table.append("\n");

        System.out.println(table.toString());
    }
}
