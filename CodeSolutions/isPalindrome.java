/* Question

Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of 
using extra space.

You could also try reversing an integer. However, if you have solved the problem 
"Reverse Integer", you know that the reversed integer might overflow. How would 
you handle such case?

There is a more generic way of solving this problem.

*/


public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int copy = x, exp = 0;
        //counting the decimal places
        while (x >= 10) {
            x /= 10;
            ++exp;
        }
        x = copy;
        //y is the reverse of int x
        int y = 0;
        while(x != 0) {
            y += (x % 10);
            //checking isPalindrome parallely while reversing the integer
            if (y != (int)(copy / Math.pow(10, exp--))) {
                return false;
            }
            x = x / 10;
            if (x != 0) {
                y *= 10;
            } 
        }
        return true;
    }
}