/* Question
Given a string which consists of lowercase or uppercase letters, find the length 
of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        int count = 0;
        //store the number of times a character appears.
        for (char c : s.toCharArray()) {
            int idx = c;
            arr[c] += 1;
        }
        boolean one = false;
        //iterate through arr to find chars to be used for forming a palindrome.
        for (int i = 0; i < 128; ++i) {
            if (arr[i] % 2 != 0) {
                one = true;
            } else if (arr[i] % 2 == 0) {
                count += arr[i];
                continue;
            }
            count += (arr[i] / 2) * 2;
        }
        //there can be 1 char which does not have a matching equal.
        if (one) {
            return count + 1;
        }
        return count;
    }
}