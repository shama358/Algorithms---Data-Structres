/* Question
Given an array S of n integers, are there elements a, b, c in S such that 
a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            //skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = nums[i];
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi) {
                if (nums[hi] + nums[lo] + target > 0) {
                    --hi;
                } else if (nums[hi] + nums[lo] +target < 0) {
                    ++lo;
                } else {
                    ArrayList<Integer> interRes = new ArrayList<Integer>();
                    interRes.add(nums[lo]);
                    interRes.add(nums[hi]);
                    interRes.add(target);
                    res.add(interRes);
                    --hi;
                    ++lo;
                    //skip duplicate combos
                    while (lo < nums.length && nums[lo] == nums[lo - 1]) {
                        ++lo;
                    }
                    //skip duplicate combos
                    while (hi < i && nums[hi] == nums[hi - 1]) {
                        --hi;
                    }
                }
            }
        }
        return res;
    }
}