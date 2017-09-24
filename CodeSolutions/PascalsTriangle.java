/*Question
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return res;
        }
        //inserting the 0th level values
        List<Integer> interRes = new ArrayList<Integer>();
        //count keeps track of the levels reached.
        int count = 1;
        interRes.add(1);
        res.add(interRes);
        while(count != numRows) {
            interRes = new ArrayList<Integer>();
            ++count;
            List<Integer> temp = res.get(res.size() - 1);
            interRes.add((int)temp.get(0));
            //calulate the current level values using the previous in the list.
            for (int i = 1; i < temp.size(); ++i) {
                interRes.add(temp.get(i - 1) + temp.get(i));
            }
            interRes.add(temp.get(temp.size() - 1));
            res.add(interRes);
        }
        return res;
    }
}