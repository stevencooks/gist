package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** 
 * A custom array which will only iterates over even number 
 */
public class EvenNumberArray implements Iterable<Integer> {
    
    private int[] a;
    
    public EvenNumberArray(int size) {
        a = new int[size];
    }

    public EvenNumberArray(int[] array) {
        a = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            a[i] = array[i];
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ArrayIterator();
    }
    
    private class ArrayIterator implements Iterator<Integer> {
        
        private int i;
        
        public ArrayIterator() {
            i = 0;
        }

        @Override
        public boolean hasNext() {
            while (i < a.length && a[i] % 2 == 1) {
                i++;
            }
            return i < a.length && a[i] % 2 == 0;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return a[i++];
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums1 = {2, 1, 2, 3, 5, 6, 8, 9, 10};
        EvenNumberArray array = new EvenNumberArray(nums1);
        for (int num : array) {
            System.out.println(num);
        }
    }

}
