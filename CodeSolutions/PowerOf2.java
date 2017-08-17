/* Question
Given an integer, write a function to determine if it is a power of two.
*/


public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
		//in bit level, if n is a power of 2 then only 1 bit will be set.
        while (n != 0) {
            if (n & 1 == 1) {
                break;
            }
            n = n >> 1;
        }
        return n == 0;
    } 
}