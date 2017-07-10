/* Question
Given a non-negative integer c, your task is to decide whether there're two 
integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:
Input: 3
Output: False

*/



public class Solution {
    public boolean judgeSquareSum(int c) {
        int a = (int)Math.sqrt(c);
        int b = 0;
        while (b <= a) {
            int product = (b * b) + (a * a);
            if (product < c) {
                ++b;
            } else if (product > c) {
                --a;
            } else {
                return true;
            }
        }
        return false;
    }
}