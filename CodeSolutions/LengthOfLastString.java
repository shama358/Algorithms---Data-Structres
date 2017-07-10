/* Question

Given a string s consists of upper/lower-case alphabets and empty space 
characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/


public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int count = 0;
		//Start from the end of string and count till the begining with the last word.
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                ++count;
            } else if (count == 0 && s.charAt(i) == ' ') {
                continue;
            } else {
                return count;
            }
        }
        return count;
    }
}