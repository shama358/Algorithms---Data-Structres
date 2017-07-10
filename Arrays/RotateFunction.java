/* Question

Given an array of integers A and let n to be its length.

Assume Bk to be an array obtained by rotating the array A k positions clock-wise, 
we define a "rotation function" F on A as follow:

F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

Calculate the maximum value of F(0), F(1), ..., F(n-1).

Note:
n is guaranteed to be less than 105.

Eg: 
A = [4, 3, 2, 6]

F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

*/


public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int sum = 0, len = A.length;
        for (int i = len; i > 0; --i) {
            int idx = len - i;
            int maxsum = sum;
            sum = 0;
            for (int j = 0; j < len; ++j) {
                if (idx == len) {
                    idx = 0;
                } 
                sum += j * A[idx];
                ++idx;
            }
            //this condition is req so the maxsum has value only from f(0)
            if (i == len) {
                maxsum = sum;
            }
            sum = Math.max(sum, maxsum);
        }
        return sum;        
    }
}