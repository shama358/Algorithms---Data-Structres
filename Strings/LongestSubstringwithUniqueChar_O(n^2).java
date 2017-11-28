/* Question
Given a string, find the length of the longest substring without repeating 
characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer 
must be a substring, "pwke" is a subsequence and not a substring.

*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        boolean finished = false;
        /*check if a character is already present in the substring, 
        if yes, then increment the starting point and start checking again.*/
        for (int i = 0 ;i < s.length(); ++i) {
            StringBuilder str = new StringBuilder();
            HashSet<Character> uniq = new HashSet<Character>();
            for (int j = i; j < s.length(); ++j) {
                if (j == s.length() - 1) {
                        finished = true;
                }
                if (!uniq.contains(s.charAt(j))) {
                    uniq.add(s.charAt(j));
                    str.append(s.charAt(j));
                } else {
                    break;
                }
            }
            maxLen = Math.max(maxLen, str.length());
            if (finished) {
                break;
            }
        }
        return maxLen;
    }
}