/* Question
Given an integer array, your task is to find all the different possible 
increasing subsequences of the given array, and the length of an increasing 
subsequence should be at least 2 .

Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], 
[4,7,7]]

Note:
The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be 
considered as a special case of increasing sequence.
*/

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return res;
        }
        subseq(nums, 0, res, new ArrayList<Integer>());
        return res;
    }
    private void subseq(int[] nums, int idx, List<List<Integer>> res, 
                        ArrayList<Integer> interRes) {
        //the length of the subseq must be greater than equal to 2
        if (interRes.size() >= 2) {
            res.add(new ArrayList<Integer>(interRes));
        }
        //keeps track if a number is used in the current level or not
        boolean[] track = new boolean[201];
        for (int i = idx; i < nums.length; ++i) {
            /*skip the current number if : previously used OR 
            the current number is less than the previous number in the list.*/
            if (track[nums[i] + 100] || (!interRes.isEmpty() && nums[i] < 
                                         interRes.get(interRes.size() - 1))) {
                continue;
            }
            interRes.add(nums[i]);
            //set the value of the current number to true after using it.
            track[nums[i] + 100] = true;
            subseq(nums, i + 1, res, interRes);
            interRes.remove(interRes.size() - 1);
        }
    }
}