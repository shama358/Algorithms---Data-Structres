/*  Question:
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Stack intStack = new Stack();
        int sum = 0, a = 0, b = 0;
        for (int i = 0; i < tokens.length; ++i) {
            /* push tokens into the stack if the current token is a number else 
            pop */
            if (tokens[i].equals("+") || tokens[i].equals("*") ||
                tokens[i].equals("/") || tokens[i].equals("-")) {
                b = (Integer) intStack.pop();
                a = (Integer) intStack.pop();
                String operator = tokens[i];
                switch (operator) {
                    case "*":
                        sum = a * b;
                        break;
                    case "+":
                        sum = a + b;
                        break;
                    case "/":
                        sum = a / b;
                        break;
                    case "-":
                        sum = a - b;
                        break;
                    default:
                        break;
                }
                intStack.push(sum);
            } else {
                intStack.push(Integer.parseInt(tokens[i]));
            }
        }
        return (Integer) intStack.pop();
    }
}