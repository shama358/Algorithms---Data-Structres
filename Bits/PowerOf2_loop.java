/* Question
Given an integer, write a function to determine if it is a power of two.
*/


public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        //looping through the bits
        while (n != 0) {
            //if a bit is set to 1, right shift bits and break from loop
            if ((n & 1) == 1) {
                n = n >> 1;
                break;
            }
            n = n >> 1;
        }
        return n == 0;
    } 
}