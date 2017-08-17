/* Question
Given a string, determine if it is a palindrome, considering only alphanumeric 
characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask 
during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        //StringBuilder contains all alpha-numeric char of s in uppercase
        StringBuilder sChar = new StringBuilder();
        s =s.toUpperCase();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || s.charAt(i) >= '0' 
				&& s.charAt(i) <= '9') {
                sChar.append(s.charAt(i));
            }
        }
        if (s.length() == 0 || sChar.length() < 2) {
            return true;
        }
        int right, left;
        //start travelling out on either side from the mid point.
        int mid = sChar.length() / 2;
        if (sChar.length() % 2 == 0) {
            left = mid - 1;
            right = mid;
        } else {
            left = mid;
            right = mid;
        }
        //check if the substring bounded by left and right is palindrome
        while (left >= 0 && right < sChar.length()) {
            if (sChar.charAt(left) != sChar.charAt(right)) {
                return false;
            }
            --left;
            ++right;
        }
        return true;        
    }
}