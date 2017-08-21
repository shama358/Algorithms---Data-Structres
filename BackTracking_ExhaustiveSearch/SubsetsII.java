/* Question
Given a collection of integers that might contain duplicates, nums, return all 
possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if (nums.length == 0) {
            return result;
        }
        //sort the array to avoid the duplicate subsets
        Arrays.sort(nums);
        subsets(nums, result, 0, new ArrayList<Integer>());
        return result;
    }
    private void subsets (int[] nums, List<List<Integer>> result, int idx, 
						  ArrayList<Integer> interRes) {
        result.add(new ArrayList<Integer>(interRes));
        for (int i = idx; i < nums.length; ++i) {
            //check if previous element is same as current (current idx != idx)
            if (i != idx && nums[i] == nums[i - 1]) {
                continue;
            }
            interRes.add(nums[i]);
            subsets(nums, result, i + 1, interRes);
            interRes.remove(interRes.size() - 1);
        }
    }
}