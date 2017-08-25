/*Question
Given an array with n objects colored red, white or blue, sort them so that 
objects of the same color are adjacent, with the colors in the order red, white 
and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, 
and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
*/

class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        //3-way quick sort with partition element as 1.
        int partition = 1;
        int lo = 0, hi = nums.length - 1, i = lo;
        while (i <= hi) {
            int cmp = compareTo(nums[i], partition);
            if (cmp > 0) {
                swap(nums, i, hi);
                --hi;
            } else if (cmp < 0) {
                swap(nums, lo, i);
                ++lo;
                ++i;
            } else {
                //if current element = 'partition', iterate to next element.
                ++i;
            }
        }
        return;
    }
    private int compareTo(int num, int val) {
        if (num > val) {
            return 1;
        } else if (num < val) {
            return -1;
        } else {
            return 0;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}