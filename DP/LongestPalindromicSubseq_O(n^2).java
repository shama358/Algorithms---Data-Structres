/* Question

Given a string s, find the longest palindromic substring in s. You may assume 
that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
*/

public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return null;
        }
        int n = s.length();
        //isPal[i][j] will be false, if s.subtring(i, j + 1) is not a palindrome
        //else true.
        boolean[][] isPal = new boolean[n][n];
        int maxLen = 1;
        //a string of length 1 is a palindrome.
        for (int i = 0; i < n; ++i) {
            isPal[i][i] = true;
        }
        //checking for length = 2;
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPal[i][i + 1] = true;
                maxLen = 2;
                start = i;
            }
        }
        //checking for length > 2
        for (int k = 2; k < n; ++k) {
            for (int i = 0; i < n - k; ++i) {
                int j = i + k;
                //if s.subtring(i + 1, j) is palindrome & 
                //s.charAt(i) == s.charAt(j) 
                //then s.substring(i, j + 1) is a palindrome
                if (isPal[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    isPal[i][j] = true;
                    maxLen = k;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen + 1);
    }
}