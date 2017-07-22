/* Question

Find the kth largest element in an unsorted array. Note that it is the kth 
largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 <= k < array's length.
*/


/* Logic: Use quick sort as you place the item in its position during the 
partitioning */


public class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        if (nums.length == 1) {
            return nums[0];
        }
        int lo = 0, hi = nums.length - 1;
	//target : the partion element must be kth largest.
        while (lo < hi) {
            int n = partition(nums, lo, hi);
            if (n < k) {
                lo = n + 1;
            } else if (n > k) {
                hi = n - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        while(true) {
            while (nums[++i] < nums[lo]) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[lo] < nums[--j]) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}