/* Question
Given a positive integer n, break it into the sum of at least two positive 
integers and maximize the product of those integers. Return the maximum product 
you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 
(10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.
*/


class Solution {
    public int integerBreak(int n) {
        //Key -> opt(n) where n = i, j with i : 1 -> n-1 & j : n - i; 
        //value -> max product
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return intBreak(n, map);
    }
    private int intBreak(int n, HashMap<Integer, Integer> map) {
        if (n == 1) {
            return 1;
        }
        //check if n was previously calculated and return the value if true
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int maxProduct = 0;
        //alculate all possible combos from the start for each i 
        for (int i = 1; i <= n; ++i) {
            //max can be either i * intBreak(n - i) OR simply i * (n - i)
            maxProduct = Math.max(i * intBreak(n - i, map), 
                                  Math.max(i * (n - i), maxProduct));
        }
        map.put(n, maxProduct);
        return maxProduct;
    }
}