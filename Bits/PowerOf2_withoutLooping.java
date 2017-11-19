/* Question
Given an integer, write a function to determine if it is a power of two.
*/


public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
		//the below is true only if n is a power of 2
        return (num & (num - 1)) == 0
    } 
}