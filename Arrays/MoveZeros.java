/* Question
Given an array nums, write a function to move all 0's to the end of it while 
maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums 
should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class Solution {
    public void moveZeroes(int[] nums) {
        int zeroPonter = -1, nonZero = -1;
        //records the index of the first zero encountered along the array
        int zeroIdx = 0;
        //records the index of the first non-zero encountered.
        int nonZeroIdx = zeroIdx;
        while (nonZeroIdx < nums.length && zeroIdx < nums.length) {
            //look for a non-zero after you encounte a zero
            if (nums[zeroIdx] == 0) {
                //start searching for non-zero from after the zero.
                if (nonZeroIdx < zeroIdx) {
                    nonZeroIdx = zeroIdx + 1;
                }
                //iterate till a nonZero is found
                while (nonZeroIdx < nums.length && nums[nonZeroIdx] == 0) {
                    ++nonZeroIdx;
                }
                swap the non Zero with Zero
                if (nonZeroIdx < nums.length) {
                    swap(nums, nonZeroIdx, zeroIdx);
                }
            }
            ++zeroIdx;
        }
        return;
    }
    //swap 2 elements in an array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}