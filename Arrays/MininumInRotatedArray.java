/* Question
Suppose an array sorted in ascending order is rotated at some pivot unknown to 
you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } 
        if (nums.length == 1) {
            return nums[0];
        }
        int lo = 0, hi = nums.length - 1;
        while(hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            //if the array is rotated and the nums[0] > nums[lastIdx]
            if (nums[lo] > nums[hi]) {
                /*if the nums[mid] > nums[hi] then change lo, else 
				if nums[mid] < nums[hi] and if nums[mid] < nums[mid - 1] then 
				return nums[mid] else change hi.*/
                if (nums[mid] > nums[hi]) {
                    lo = mid + 1;
                    continue;
                } else if (nums[mid] < nums[hi]) {
                    if (nums[mid - 1] > nums[mid]) {
                        return nums[mid];
                    } else {
                        hi = mid - 1;
                        continue;
                    }
                }
            }
            //if the array is not rotated
            if (nums[lo] < nums[hi]) {
                return nums[lo];
            }
            if (hi == lo) {
                return nums[hi];
            }
        }
        return 0;
    }
}