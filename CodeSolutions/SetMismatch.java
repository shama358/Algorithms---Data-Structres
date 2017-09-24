/*Question
The set S originally contains numbers from 1 to n. But unfortunately, due to the 
data error, one of the numbers in the set got duplicated to another number in 
the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. 
Your task is to firstly find the number occurs twice and then find the number 
that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
Note:
The given array size will in the range [2, 10000].
The given array's numbers won't have any order.
*/

class Solution {
    public int[] findErrorNums(int[] nums) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        Arrays.sort(nums);
        int sum = 0, dup = -1, sum1 = 0;
        //find sum if the data was correct
        for (int i = 0; i <= nums.length; ++i) {
            sum += i;
        }
        //find the duplicate value and the sum of the given data
        for (int i = 0; i < nums.length ; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                dup = nums[i];
            }
            sum1 += nums[i];
        }
        //find the missing number else return [-1, nums.length]
        if (nums[0] == 1 || sum - sum1 + dup == 1) {
            return new int[] {dup, (sum - sum1) + dup};
        } 
        return new int[] {-1, nums.length};
     }
}