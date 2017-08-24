/* Question
Given a non-empty string check if it can be constructed by taking a substring of 
it and appending multiple copies of the substring together. You may assume the 
given string consists of lowercase English letters only and its length will not 
exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" 
twice.)
*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2) {
            return false;
        }
        int len = s.length();
        //find the pattern by finding smallest num from len/2 dividing 's'fully.
        for (int i = len / 2; i >= 1; --i) {
            if (len % i == 0) {
                int div = len / i;
                String sub = s.substring(0, i);
                //repeat the obtained patterns 'div' times to get 's'
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < div; ++j) {
                    str = str.append(sub);
                }
                if (str.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }       
}