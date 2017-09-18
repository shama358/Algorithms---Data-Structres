/* Question
Write a function that takes a string as input and reverse only the vowels of a 
string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
*/

class Solution {
    public String reverseVowels(String s) {
        int lo = 0, hi = s.length() - 1;
        char[] str = s.toCharArray();
        String vowels1 = "aeiou", vowels2 = "AEIOU";
        //iterate through 's' from front and back stopping when a vowel is found
        while (lo <= hi) {
            while(vowels1.indexOf(str[lo]) == -1 && vowels2.indexOf(str[lo]) == 
                  -1) {
                ++lo;
                if (lo >= hi) {
                    break;
                }
            }
            while(vowels1.indexOf(str[hi]) == -1 && vowels2.indexOf(str[hi]) == 
                  -1) {
                --hi;
                if (lo >= hi) {
                    break;
                }
            }
            if (lo >= hi) {
                break;
            }
            exch(str, hi, lo);
            ++lo;
            --hi;
        }
        return new String(str);
    }
    //func to exchange the vowel characters
    private void exch(char[] str, int i, int j) {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
    }
}