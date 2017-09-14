/* Question
Given a string containing having characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order.
Example :
"[her] : shhh..(this is a {secret})"
true
*/

public class Solution {
    public boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        //key -> closing bracket, value-> matching open bracket
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put (')', '(');
        map.put ('}', '{');
        map.put (']', '[');            
        char[] str = s.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < str.length ; ++i) {
            if (str[i] == '(' || str[i] == '{' || str[i] == '[') {
                stack.push(str[i]);
            }
            if (str[i] == ')' || str[i] == '}' || str[i] == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if ((char)stack.pop() != (char)map.get(str[i])) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
