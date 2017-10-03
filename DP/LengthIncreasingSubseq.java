/* Question
Given an unsorted array of integers, find the length of longest increasing 
subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 Note that there may be more than one LIS combination, it is only necessary for 
 you to return the length.

Your algorithm should run in O(n2) complexity.

*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //an array to store the max length of increasing subseq.
        int[] M = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int max = 1;
            //get count from 0 -> i and populate M[i] with max of count.
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (M[j] + 1 > max) {
                        max = M[j] + 1;
                    }
                }
            }
            M[i] = max;
        }
        int max = 0;
        for (int i = 0; i < M.length; ++i) {
            if (max < M[i]) {
                max = M[i];
            }
        }
        return max;
    }
}