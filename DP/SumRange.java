/* Question
Given an integer array nums, find the sum of the elements between indices i and 
j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/

class NumArray {
    //Array holds the range addition
    int[] newNums;

    public NumArray(int[] nums) {
        newNums = new int[nums.length];
        //populating newNums
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                newNums[0] = nums[0];
                continue;
            }
            newNums[i] = newNums[i - 1] + nums[i];
        }
    }
    //rangeSum(i, j) = newNums[j] - newNums[i - 1]
    public int sumRange(int i, int j) {
        if (newNums.length == 0) {
            return (Integer)null;
        }
        if (i == 0) {
            return newNums[j];
        }
        return newNums[j] - newNums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */