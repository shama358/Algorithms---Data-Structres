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
        //key -> char; 
        //value-> next unique char to start from if a duplicate is found
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //i -> start; j -> end of substring
        for (int i = 0, j = 0; j < s.length() && i < s.length(); ++j) {
            if (map.containsKey(s.charAt(j))) {
                //prevents the i pointer from moving back
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j + 1);
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}