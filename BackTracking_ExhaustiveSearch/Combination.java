/* Question
Given two integers n and k, return all possible combinations of k numbers out 
of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //early exit if any of the parameters are invalid
        if (k > n || k == 0 || n == 0) {
            return res;
        }
        //create an array of size n and populate it with 1..n
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = i + 1;
        }
        combinations(arr, k, 0, new ArrayList<Integer>(), res);
        return res;
        
    }
    //exhaustive search method.
    private void combinations(int[] arr, int k, int idx, List<Integer> interRes, 
                              List<List<Integer>> res) {
        //when size of interRes==k then include in result
        if (interRes.size() == k) {
            res.add(new ArrayList<Integer>(interRes));
            return;
        }
        //for loop to consider all possible combinations
        for (int i = idx; i < arr.length; ++i) {
            //add the current number
            interRes.add(arr[i]);
            combinations(arr, k, i + 1, interRes, res);
            //remove the last added number to try with next number
            interRes.remove(interRes.size() - 1);
        }
     }
}