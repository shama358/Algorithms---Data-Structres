/* Question
Given an array of non-negative integers, you are initially positioned at the 
first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //bottom-up approach
        //O(N)
        int lastPos = nums.length - 1;
        /*starting from the end and determine if from the current cell the last 
        index is reached. If yes, then update the lastPos to the current idx. 
        Keep repeating the step and checking if from the current pos, lastPos 
        can be reached.*/
        for (int i = nums.length - 2; i >= 0; --i) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

}