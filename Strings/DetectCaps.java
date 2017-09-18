/* Question
Given a word, you need to judge whether the usage of capitals in it is right or 
not.

We define the usage of capitals in a word to be right when one of the following 
cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, 
like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.

Example 1:
Input: "USA"
Output: True

Example 2:
Input: "FlaG"
Output: False

Note: The input will be a non-empty word consisting of uppercase and lowercase 
latin letters.
*/

class Solution {
    public boolean detectCapitalUse(String word) {
        boolean caps = false;
        //set caps to true if caps
        if (word.charAt(0) - 'Z' <= 0) {
            caps = true;
        }
        for (int i = 1; i < word.length(); ++i) {
            if (i == 1 && caps == true && word.charAt(i) - 'Z' > 0) {
                caps = false;
            } else if ((caps == false && word.charAt(i) - 'Z' > 0) || 
                       (caps == true && word.charAt(i) - 'Z' <= 0)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}