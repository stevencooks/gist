package lib;

public class SeparateChainHashST<Key, Value> {

    // initial hash table capacity
    private static final int INIT_CAPACITY = 4;

    // number of key-value pairs
    private int N;

    // hash table size
    private int M;

    private Node[] st;
    
    /** Creates separate chaining hash table */
    public SeparateChainHashST() {
        this(INIT_CAPACITY);
    }

    /** Creates separate chaining hash table with M lists */
    public SeparateChainHashST(int M) {
        this.M = M;
        st = new Node[M];
    }

    /**
     * 
     * @param k
     * @param v
     */
    public void put(Key k, Value v) {

    }

    /**
     * 
     * @param k
     * @return
     */
    public Value get(Key k) {
        int i = hash(k);
        for (Node n = st[i]; n != null; n = n.next) {
            if (k.equals(n.key)) {
                @SuppressWarnings("unchecked")
                Value value = (Value) n.val;
                return value;
            }
        }
        return null;
    }

    private int hash(Key k) {
        return (k.hashCode() & 0x7fffffff) % M;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keySet() {
        return null;
    }

    private static class Node {
        private Object key;
        private Object val;
        private Node next;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
