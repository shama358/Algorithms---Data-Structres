/*Question
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> interRes = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return interRes;
        }
        int count = 0;
        interRes.add(1);
        while(count != rowIndex) {
            List<Integer> prev = interRes;
            interRes = new ArrayList<Integer>();
            //the first element and last element is 1.
            interRes.add(prev.get(0));
            //calculating the current values using the previous level.
            for (int i = 1; i < prev.size(); ++i) {
                interRes.add(prev.get(i - 1) + prev.get(i));
            }
            interRes.add(prev.get(prev.size() - 1));
            ++count;
        }
        return interRes;
    }
}