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
        //TLE...O(N^2)
        boolean[] jump = new boolean[nums.length];
        jump[0] = true;
        //trying out different combos and marking the jump positions as true.
        for(int i = 0; i < nums.length; ++i) {
            if (!jump[i]) {
                continue;
            }
            for(int j = 1; j <= nums[i]; ++j) {
                if (i + j < nums.length) {
                    jump[i + j] = true;
                } else {
                    break;
                }
                if (jump[nums.length - 1] == true) {
                    return true;
                }
            }
        }
        return false;
    }

}