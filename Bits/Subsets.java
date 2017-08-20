/* Question
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if (nums.length == 0) {
            return result;
        }
		/* the set has 2^nums.length subsets. this can be related to the bits of 
		numbers between 0 and 2^nums.length. 0 being that the element is not 
		there and 1 being element is there. */
        int possibilities = (int)Math.pow(2, nums.length);
        for (int i = 0; i < possibilities; ++i) {
            List<Integer> interRes = new ArrayList<Integer>();
            int n = i, idx = 0;
			//right shift bits until n is zero
            while (n != 0) {
                if ((n & 1) == 1) {
                    interRes.add(nums[idx]);
                }
                n >>= 1;
                ++idx;
            }
            result.add(interRes);
        }
        return result;
    }
}