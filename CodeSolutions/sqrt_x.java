/* Question
Implement int sqrt(int x).

Compute and return the square root of x.
*/

class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        //using binary search to search the (int)sqrt;
        int lo = 1, hi = x;
        int prev = 0;
        while(lo <= hi) {
            int mid = lo +((hi - lo) / 2);
            /*making sure that mid * mid < Integer.MAX_VALUE. 
            the equation is written as below to avoid the Integer overflow.*/
            if (mid > x / mid) {
                hi = mid - 1;
            } else if (mid < x / mid) {
                lo = mid + 1;
                prev = mid;
            } else {
                return mid;
            }      
        }
        return prev;
    }
}