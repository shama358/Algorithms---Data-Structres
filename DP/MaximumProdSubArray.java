/* Question
Find the contiguous subarray within an array (containing at least one number) 
which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        //max prod so far
        int[] maxProd = new int[nums.length];
        //min prod so far
        int[] minProd = new int[nums.length];
        maxProd[0] = nums[0];
        minProd[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxProd[i] = Math.max(Math.max(maxProd[i - 1] * nums[i], 
                                           minProd[i - 1] * nums[i]), nums[i]);
            minProd[i] = Math.min(Math.min(maxProd[i - 1] * nums[i], 
                                           minProd[i - 1] * nums[i]), nums[i]);
            max = Math.max(maxProd[i], max);
        }
        return max;
    }
}