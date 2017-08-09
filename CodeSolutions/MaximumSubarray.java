/* Question
Find the contiguous subarray within an array (containing at least one number)
which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            //add to sum until you get an element that is grater than sum
            sum += nums[i];
            if (sum < nums[i]) {
                //reset start of max subarray if nums[i] is greater than sum.
                sum  = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}