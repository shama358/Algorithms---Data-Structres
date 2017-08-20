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
        subsetsRec(nums, result, 0, new ArrayList<Integer>());
        return result;
    }
    private void subsetsRec(int[] nums, List<List<Integer>> result, int idx, 
							ArrayList<Integer> interRes) {
        //add interRes at every level.
        result.add(new ArrayList<Integer>(interRes));
        //for loop as first element can be any number.(this is one method)
        for (int i = idx; i < nums.length; ++i) {
            //including current number and then replacing with another number.
            interRes.add(nums[i]);
            subsetsRec(nums, result, i + 1, interRes);
            interRes.remove(interRes.size() - 1);
        }
    }
}