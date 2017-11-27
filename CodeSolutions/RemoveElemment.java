/* Question
Given an array and a value, remove all instances of that value in-place and 
return the new length.

Do not allocate extra space for another array, you must do this by modifying the 
input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond 
the new length.

Example:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums 
being 2.
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int fidx = 0;
        //find the index of the first val
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == val) {
                fidx = i;
                break;
            }
        }
        //swap the required numbers with val and update the fidx to point to the 
        //next val
        for (int i = fidx + 1; nums[fidx] == val && i < nums.length; ++i) {
            if (nums[i] == val) {
                continue;
            }
            exch(nums, fidx++, i);
        }
        return fidx == 0 && nums[0] != val ? nums.length : fidx;
    }
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}