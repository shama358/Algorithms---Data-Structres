/* Question
Given a positive integer num, write a function which returns True if num is a 
perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False

*/

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return false;
        }
        int lo = 1, hi = num;
        int mid = 0;
        //using binary search to find the sqrt(num)
        while(lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if(mid < num / mid) {
                lo = mid + 1;
            } else if (mid > num / mid) {
                hi = mid - 1;
            } else {
                break;
            }
        }
        //checking if the sqrt obtained is in fact a perfect square == num.
        if (mid * mid == num) {
            return true;
        }
        return false;
    }
}