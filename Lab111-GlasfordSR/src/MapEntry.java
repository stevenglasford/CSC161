/**
 * An alteration from the the AbstractMap class from the book but as a
 * separate class file instead of a nested class
 * @author Steven Glasford
 * @author Eric Zamore
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class MapEntry <K,V>  implements Entry<K,V> {
    //The key
    private K k;
    //The value
    private V v;

    /**
     * The instantiator for the class.
     * @param key   Your key.
     * @param value Your value associated with the key.
     */
    public MapEntry(K key, V value){
        k = key;
        v = value;
    }

    /**
     * Gets the object for about the key.
     * @return  returns the current key object.
     */
    public K getKey() {
        return k;
    }

    /**
     * Gets the object about the value associated with the key.
     * @return  returns the current value object.
     */
    public V getValue() {
        return v;
    }

    /**
     * Sets a key to a new value.
     * @param key   The key you wish to replace the old key with.
     * @return      The key that was replaced.
     */
    public K setKey(K key){
        K oldClit = k;
        k = key;
        return oldClit;
    }

    /**
     * Sets a value to a new value.
     * @param value The new value your want to replace the old.
     * @return      The old value, which was replaced.
     */
    public V setValue(V value){
        V oldAssCunt = v;
        v = value;
        return oldAssCunt;
    }
}
