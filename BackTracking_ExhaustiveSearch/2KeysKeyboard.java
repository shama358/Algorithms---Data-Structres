/* Question
Initially on a notepad only one character 'A' is present. You can perform two 
operations on this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy 
is not allowed).
Paste: You can paste the characters which are copied last time.
Given a number n. You have to get exactly n 'A' on the notepad by performing the 
minimum number of steps permitted. Output the minimum number of steps to get n 
'A'.

Example 1:
Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
*/

public class Solution {
    public int minSteps(int n) {
        if (n < 2) {
            return 0;
        }
        //copied first
        return StepsRec(n, 1, 1, 1);   
    }
    private int StepsRec(int n, int prevCopy, int currSteps, int currSize) {
        if (currSize == n) {
            return currSteps;
        }
        if (currSize > n) {
            return Integer.MAX_VALUE;
        }
        //paste
        int paste = StepsRec(n, prevCopy, currSteps + 1, currSize + prevCopy);
        //copyAll and paste
        int copyAll = StepsRec(n, currSize, currSteps + 2, currSize + currSize);      
        return Math.min(paste, copyAll);
    }
}