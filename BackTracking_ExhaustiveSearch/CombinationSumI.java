/* Question
Given a set of candidate numbers (C) (without duplicates) and a target number 
(T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/


public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        comboSumRec(candidates, target, result, 0, 0,new ArrayList<Integer>());
        return result;
    }
    private void comboSumRec(int[] candidates, int target, List<List<Integer>> 
	result, int sum, int idx, ArrayList<Integer> interRes) {
        if (sum == target) {	
        /* Since interRes is changed later on(after return), you need to capture
			the current list */
            result.add(new ArrayList<Integer>(interRes));
            return;
        }
        if (sum > target) {
            return;
        }
        /* for loop : the first postion can be filled in (candiate.length - 1) 
	ways and so on for other positions as well.
        The for loop is starting from idx as the combinations require not be 
	repeated. so you ensure that by startng from the current     
        position and not go to the left of the element.*/
        for (int i = idx; i < candidates.length; ++i) {
            int currNum = candidates[i];
            interRes.add(currNum);
            sum += candidates[i];
            //consider the element by just adding the current number.
            comboSumRec(candidates, target, result, sum , i, interRes);
            //remove the current number and check wiht the next number.
            sum -= candidates[i];
            interRes.remove(interRes.size() - 1);
        }
        return;        
    }
}
