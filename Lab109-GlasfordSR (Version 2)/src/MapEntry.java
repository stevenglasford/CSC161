/**
 * An alteration of the MapEntry from the UnsortedMap thing from the book,
 * very much altered, but the book it came from was Data Structures
 * And Algorithms.
 * @author Steven Glasford, Michael T Goodrich, Roberto Tamassia,
 * Michael H Goldwasser.
 */
public class MapEntry implements Entry {
        //key
        private int k;
        //value
        private int v;
        public MapEntry(int key, int value){
            k = key;
            v = value;
        }
        //public methods of the Entry interface
        @Override
        public int getKey() {return k;}
        @Override
        public int getValue() {return v;}
        public void createEntrant(int key, int value){
            k = key;
            v = value;
        }
        //utilities not exposed as part of the Entry interface
        public void setKey(int key) {k = key;}
        public int setValue(int value) {
            int old = v;
            v = value;
            return old;
        }
    }