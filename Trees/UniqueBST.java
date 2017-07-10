/* Question

Given n, how many structurally unique BST's (binary search trees) that store 
values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
*/


public class Solution {
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }
        return numTreesRec(n, 0);
    }
    private int numTreesRec(int n, int res) {
        if (n <= 1) {
            return 1;
        }
        for (int i = 1; i <= n; ++i) {
            int LTrees = numTreesRec(i - 1, res);
            int RTrees = numTreesRec(n - i, res);
            res += LTrees * RTrees;
        }
        return res;
    }
}