/* Question
Find all possible combinations of k numbers that add up to a number n, given 
that only numbers from 1 to 9 can be used and each combination should be a 
unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combosum3(k, n, res, new ArrayList<Integer>(), 1, 0);
        return res;
    }
    private void combosum3(int k, int n, List<List<Integer>> res, 
                           ArrayList<Integer> interRes, int idx, int sum) {
        //exit condition
        if (interRes.size() == k && sum == n) {
            res.add(new ArrayList<Integer>(interRes));
            return;
        }
        //early exit if you overshoot.
        if (sum > n || interRes.size() > k) {
            return;
        }
        for (int i = idx; i < 10; ++i) {
            interRes.add(i);
            sum += i;
            combosum3(k, n, res, interRes, i + 1, sum);
            //clean-up
            interRes.remove(interRes.size() - 1);
            sum -= i;
        }
        return;
    }
}