package lib;

public class SeparateChainHashST<Key, Value> {

    // initial hash table capacity
    private static final int INIT_CAPACITY = 4;

    // number of key-value pairs
    private int N;

    // hash table size
    private int M;

    // symbol table
    private ST<Key, Value>[] st;
    
    @SuppressWarnings("hiding")
    private class ST<Key, Value> {
        
        private int n;
        private Node head;
        
        private class Node {
            Key key;
            Value value;
            Node next;
            public Node(Key key, Value val, Node next) {
                this.key = key;
                this.value = val;
                this.next = next;
            }
        }

        public boolean contains(Key k) {
            return get(k) != null;
        }

        public void put(Key k, Value v) {
            if (v == null) {
                delete(k);
                return;
            }
            for (Node x = head; x != null; x = x.next) {
                if (k.equals(x.key)) {
                    x.value = v;
                    return;
                }
            }
            head = new Node(k, v, head);
            n++;
        }

        private void delete(Key k) {
            head = delete(head, k);
        }

        private Node delete(Node x, Key key) {
            if (x == null) {
                return null;
            }
            if (key.equals(x.key)) {
                n--;
                return x.next;
            }
            x.next = delete(x.next, key);
            return x;
        }

        public Value get(Key key) {
            for (Node x = head; x != null; x = x.next) {
                if (key.equals(x.key)) {
                    return x.value;
                }
            }
            return null;
        }
    }
    
    /** Creates separate chaining hash table */
    public SeparateChainHashST() {
        this(INIT_CAPACITY);
    }

    /** Creates separate chaining hash table with M lists */
    @SuppressWarnings("unchecked")
    public SeparateChainHashST(int M) {
        this.M = M;
        st = (ST<Key, Value>[]) new ST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new ST<Key, Value>();
        }
    }

    /**
     * 
     * @param k
     * @param v
     */
    public void put(Key k, Value v) {
        if (N >= 10 * M) {
            resize(2 * M);
        }
        int i = hash(k);
        if (!st[i].contains(k)) {
            N++;
        }
        st[i].put(k, v);

    }

    private void resize(int i) {
        
    }

    /**
     * 
     * @param k
     * @return
     */
    public Value get(Key k) {
        int i = hash(k);
        return st[i].get(k);
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

    public static void main(String[] args) {
        SeparateChainHashST<String, Integer> st = new SeparateChainHashST<>();
        st.put("Tom", 123);
        st.put("Jack", 456);
        System.out.println(st.get("Tom"));
        System.out.println(st.get("Jack"));
    }

}
