/* Question
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
Now you have 2 symbols + and -. For each integer, you should choose one from + 
and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target 
S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
*/

/* the idea is to process the given input like a binary tree, where the children
is + and - of a number*/

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return findRec(nums, S, 0, 0);
    }
    private int findRec(int[] nums, int S, int idx, int sum) {
        if (idx == nums.length) {
            //return 1 when the sum is equal to the given target
            if (sum == S) {
                return 1;
            } else {
                return 0;
            }
        }
        //consider this as the root
        int currNum = nums[idx];
        /*branches out in 2 ways : adding the current number and subtracting the
		current number.*/
        int add = findRec(nums, S, idx + 1, sum + currNum);
        int sub = findRec(nums, S, idx + 1, sum - currNum);
        return add + sub;
    }
}