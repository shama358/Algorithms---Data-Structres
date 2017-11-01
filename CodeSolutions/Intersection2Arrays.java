/*Question
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //early exit if any of the given arrays are empty
        if(nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        //HashSet that stores the elements of the smallest array
        HashSet<Integer> res = new HashSet<Integer>();
        //arrayList that contains the intersection
        ArrayList<Integer> result = new ArrayList<Integer>();
        //find the smallest array and add it to the hashSet and use the 
        //other array to find the intersection
        if (nums2.length >= nums1.length) {
            addSet(nums1, res);
            return intersection(nums2, result, res);
        } else {
            addSet(nums2, res);
            return intersection(nums1, result, res);
        }
    }
    //add elements to hashSet
    private void addSet(int[] nums1, HashSet<Integer> res) {
        for (int i = 0; i < nums1.length; ++i) {
            res.add(nums1[i]);
        }
    }
    //find intersection
    private int[] intersection(int[] nums2, ArrayList<Integer> result, 
                               HashSet<Integer> res) {
        for (int i = 0; i < nums2.length; ++i) {
            if (res.contains(nums2[i])) {
                result.add(nums2[i]);
                res.remove(nums2[i]);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0 ; i < result.size(); ++i) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}