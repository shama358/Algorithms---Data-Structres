/* Question
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to 
[5,6,7,1,2,3,4].

*/

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return;
        }
        //when k > nums.length
        if(k > nums.length) {
            k %= nums.length;
        }
        int count = 0;
        /*1 iteration covers n/k (n = nums.length) items as only n/k items are 
        touched. you will need k such iterations to put the numbers in their 
        correct places. so thats k.n/k = n. So you will get the solution in n 
        iterations.*/
        for (int i = 0; count < nums.length; ++i) {
            int prev = nums[i];
            int current = i;
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                ++count;
            } while(current != i);
        }
    }
}