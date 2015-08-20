/**
 * File: algo/Partition.java
 *********************************************************************** 
 * implementation of Partition algorithm.
 * 
 *********************************************************************** 
 */
package algo;

import java.util.Arrays;
import java.util.Random;

public class Partition {
    
    public int randomPartition(int start, int end, int[] nums) {
        if (nums == null || start < 0 || end >= nums.length || start > end) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        // choose random element as pivot from [start, end]
        int index = start + new Random().nextInt(end - start + 1); 
        swap(nums, index, end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                swap(nums, ++small, i);
            }
        }
        swap(nums, ++small, end);
        return small;
    }
    
    /**  Returns index of pivot while partitioning input array */
    public int partition(int start, int end, int[] nums) {
        // valid input
        if (nums == null || start > end || start < 0 || end >= nums.length) {
            throw new IllegalArgumentException();
        }
        // index of last smaller-than-pivot element
        int i = start - 1;
        for (int j = start; j < end; j++) {
            // find number smaller than pivot
            if (nums[j] < nums[end]) {
                // enlarge smaller part then swap
                swap(nums, ++i, j);
            }
        }
        // swap with pivot
        swap(nums, ++i, end);
        return i;
    }

    // swap two numbers in array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        // non-randomized partition
        int[] nums = {3, 1, 2};
        int index = new Partition().partition(0, 2, nums);
        // index=1: [1, 2, 3]
        System.out.println("index=" + index + ": " + Arrays.toString(nums));
        
        // randomized partition
        int[] nums2 = {3, 1, 2};
        index = new Partition().randomPartition(0, 2, nums2);
        System.out.println("index=" + index + ": " + Arrays.toString(nums2));
    }

}
