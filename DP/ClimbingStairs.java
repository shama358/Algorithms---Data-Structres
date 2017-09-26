/* Question
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you 
climb to the top?

Note: Given n will be a positive integer.
*/


class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return n;
        }
        //cache the steps.
        //key->current step;value->no. of ways to reach target from current step.
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return climbRec(n, 0, map);
    }
    //Top-down approach
    private int climbRec(int n, int Step,  HashMap<Integer, Integer> map) {
        if (Step == n) {
            return 1;
        }
        if (Step > n) {
            return 0;
        }
        //dont go further if no of ways from current step is already calculated.
        if (!map.isEmpty() && map.containsKey(Step)) {
            return map.get(Step);
        }        
        int one = climbRec(n, Step + 1, map);
        if (!map.containsKey(Step + 1)) {
            map.put (Step + 1, one);
        } 
        int two= climbRec(n, Step + 2, map);
        if (!map.containsKey(Step + 2)) {
            map.put (Step + 2, two);
        }
        return one + two;
    }
}