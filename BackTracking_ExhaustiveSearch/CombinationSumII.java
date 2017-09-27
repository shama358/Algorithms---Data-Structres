/* Question
Given a collection of candidate numbers (C) and a target number (T), find all 
unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (candidates.length == 0) {
            return result;
        }
        //sorting the array to avoid duplicates
        Arrays.sort(candidates);
        comboSumRec(candidates, target, result, new ArrayList<Integer>(), 0, 0);
        return result;
    }
    private void comboSumRec(int[] candidates, int target, 
                             LinkedList<List<Integer>> result, 
                             ArrayList<Integer> interRes, int idx, int sum) {
        //exit condition.
        if (sum == target) {
            result.add(new ArrayList<Integer>(interRes));
            return;
        }
        //early exit if you overshoot.
        if (sum > target) {
            return;
        }
        for (int i = idx; i < candidates.length; ++i) {
            //continue if previous element is the same as the current element.
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            interRes.add(candidates[i]);
            sum += candidates[i];
            comboSumRec(candidates, target, result, interRes, i + 1, sum);
            //clean-up
            sum -= candidates[i];
            interRes.remove(interRes.size() - 1);
        }
    }
}