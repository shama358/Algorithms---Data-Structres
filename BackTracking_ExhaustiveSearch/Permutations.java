/* Question
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        return perm (nums, res, 0);
    }
    private List<List<Integer>> perm(int[] nums, List<List<Integer>> res, 
                                      int idx) {
        //exit condition
        if (idx >= nums.length) {
            add (res, nums);
            return res;
        }
        //exhaustive search
        for (int i = idx; i < nums.length; ++i) {
            exch (nums, i ,idx);
            perm(nums, res, idx + 1);
            exch (nums, i, idx);
        }
        return res;
    }
    private void exch (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //convert int[] to list<Integer>
    private void add (List<List<Integer>> res, int[] nums) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            temp.add(nums[i]);
        }
        res.add(temp);
        return;
    }

}