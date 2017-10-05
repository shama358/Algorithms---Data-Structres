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
        //bottom-up approach
        int[] max = new int[n + 1];
        /*assuming intergerBreak(0) = 0 & intergerBreak(1) = 1; as per req 
        in future.*/
        max[0] = 0;
        max[1] = 1;
        return intBreak(n, max);
    }
    private int intBreak(int n, int[] max) {
        int maxProduct = 0;
        /*calculate all possible combos from the start for each i and 
        populate the max[i] with the maximum.*/
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                maxProduct = Math.max ((j * max[i - j]), Math.max((j * (i - j)), 
                                                                  maxProduct));
            }
            max[i] = maxProduct;
        }
        return max[n];
    }
}