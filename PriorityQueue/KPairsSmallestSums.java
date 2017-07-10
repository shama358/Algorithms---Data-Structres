/*Question

You are given two integer arrays nums1 and nums2 sorted in ascending order and 
an integer k.

Define a pair (u,v) which consists of one element from the first array and one 
element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
*/


public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if (nums1.length ==0 || nums2.length == 0 || k == 0) {
            return res;
        }
		//PriorityQueue -minheap of size k 
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>
            (Math.min(nums1.length, k), new Comparator<int[]>(){
            public int compare(int[] pair1, int[] pair2) {
                if (pair1[3] > pair2[3]){
                    return 1;
                } else if(pair1[3] < pair2[3]) {
                    return -1;
                } else {
                    return 0;
                }
            }
            });
		/*add the pairs formed by using the first element of nums2 with k 
		elements of nums1 in the minheap. */
        for (int i = 0; i < k && i <= nums1.length - 1; ++i) {
            pq.add(new int[]{nums1[i], nums2[0], 0, nums1[i] + nums2[0]});
        }
        while (k-- > 0  && !pq.isEmpty()) {
            int[] pair = pq.poll();
            
            res.add(new int[]{pair[0], pair[1]});
            if (pair[2] == nums2.length - 1) {
                continue;
            }
            pq.add(new int[]{pair[0], nums2[pair[2] + 1], pair[2] + 1, 
			pair[0] + nums2[pair[2] + 1]});

        }
        return res;
    }
}
       
        