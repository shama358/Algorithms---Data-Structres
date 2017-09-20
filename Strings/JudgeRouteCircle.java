/* Question
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, 
judge if this robot makes a circle, which means it moves back to the original 
place.

The move sequence is represented by a string. And each move is represent by a 
character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true

Example 2:
Input: "LL"
Output: false
*/

class Solution {
    public boolean judgeCircle(String moves) {
        //give values to the 4 directions and the add the directions.
        int U = 1, D = -1, L = 2, R = -2;
        //if the robot makes a circle, sum should be 0.
        int sum = 0;
        for(int i = 0; i < moves.length(); ++i) {
            switch(moves.charAt(i)) {
                case 'U' : sum += U;
                    break;
                case 'D' : sum += D;
                    break;
                case 'L' : sum += L;
                    break;
                case 'R' : sum += R;
                    break;
                default: break;
            }
        }
        if (sum != 0) {
            return false;
        }
        return true;
    }
}