/* Question
Implement pow(x, n).
*/


public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0000;
        }
        //need when case n < 0
        int tempN = Math.abs(n);
        double result = 1;
        //iterate through 32 bits.
        for (int i = 0; i < 32; ++i) {
            if ((tempN & 1) == 1) {
                result *= x;
            }
            tempN >>= 1;
            x = x * x;
        }
        if (n < 0) {
            return 1 / result;
        }
        return result;
    }
}