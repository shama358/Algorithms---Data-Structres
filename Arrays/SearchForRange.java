/*Question
Given an array of integers sorted in ascending order, find the starting and 
ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        //early exit
        if (nums.length <= 1) {
            if (nums.length == 0 || nums[0] != target) {
                return result;
            } else if (nums[0] == target) {
                result = new int[]{0, 0};
                return result;
            }
        }
        //use binary search to find the number
        int lo = 0, hi = nums.length - 1;
        int rangeNum = hi;
        boolean found = false;
        while (hi >= lo) {
            rangeNum = lo + (hi - lo) / 2;
            int cmp = less(nums[rangeNum], target);
            if (cmp > 0) {
                hi = rangeNum - 1;
            } else if (cmp < 0) {
                lo = rangeNum + 1; 
            } else {
                found = true;
                break;
            }
        }
        //if the number is found, find the range
        if (found) {
            int range = rangeNum;
            while (rangeNum != 0 && nums[rangeNum - 1] == nums[rangeNum]) {
                --rangeNum;
            }
            result[0] = rangeNum;
            while(range != nums.length - 1 && nums[range] == nums[range + 1]) {
                ++ range;
            }
            result[1] = range;
        }
        return result;
    }
    private int less(int a, int b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }
}