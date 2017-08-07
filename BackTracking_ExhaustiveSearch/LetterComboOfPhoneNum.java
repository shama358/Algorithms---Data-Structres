/* Question

Given a digit string, return all possible letter combinations that the number 
could represent.

A mapping of digit to letters (just like on the telephone buttons) is given 
below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in 
any order you want.

*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        //early exit if the digits include 0 or 1 or is empty.
        if (digits.indexOf('1') != -1 || digits.indexOf('0') != -1 || 
		digits.length() == 0) {
            return result;
        }
        char[] digit = digits.toCharArray();
        //key -> digit    value-> alphabets corresponding to the digit
        HashMap<Character, String> map = new HashMap<Character, String>();
        //populating the HashMap.
        for (int i = 0; i < digit.length; ++i) {
            switch(digit[i]) {
                case '2' : map.put(digit[i],"abc");
                    break;
                case '3' : map.put(digit[i],"def");
                    break;
                case '4' : map.put(digit[i],"ghi");
                    break;
                case '5' : map.put(digit[i],"jkl");
                    break;
                case '6' : map.put(digit[i],"mno");
                    break;
                case '7' : map.put(digit[i],"pqrs");
                    break;
                case '8' : map.put(digit[i],"tuv");
                    break;
                case '9' : map.put(digit[i],"wxyz");
                    break;
                default : break;
            }
        }
        letterComboRec(digit, map, result, 0, new StringBuilder());
        return result;
    }
    private void letterComboRec(char[] digit, HashMap<Character, String> map, 
	List<String> result, int idx, StringBuilder interRes) {
        if (idx == digit.length) {
            result.add(new String(interRes));
            return;
        }
        String letters = (String)map.get(digit[idx]);
        //for loop as the first position can be filled by multiple alphabets.
        for (int i = 0; i < letters.length(); ++i) {
            /*populating a position and calling the func recursively to 
	    populate the remaininig positions. */
            letterComboRec(digit, map, result, idx + 1, interRes.append
			(Character.toString(letters.charAt(i))));
            /* removing the last populated character to form a different 
	    combination. Basically a clean up. */
            interRes.deleteCharAt(interRes.length() - 1);
        }
    }
}
