/* Question
Given an integer (signed 32 bits), write a function to check whether it is a 
power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
*/


class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
        /* num & (num - 1) gives if num is a power of 2.
        the power of 4 is possible if 1 is set in any odd position only.
        So we can use "num & 0x55555555==num" to check if "1" is located at the 
        odd position.*/
    }
}