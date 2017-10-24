/* Question
A message containing letters from A-Z is being encoded to numbers using the 
following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways 
to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //key -> current idx ; value -> count 
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return decode(s, 0, map);
    }
    //using DP - memoization.
    private int decode(String s, int idx, HashMap<Integer, Integer> map) {
        if (idx == s.length()) {
            return 1;
        }
        if (idx >= s.length()) {
            return 0;
        }
        //return the no. of decode ways if calculated earlier.
        if (map.containsKey(idx)) {
            return map.get(idx);
        }
        int curr = 0, decodeWays = 0;
        for (int i = idx; i < s.length(); ++i) {
            curr = (curr * 10) + Integer.parseInt(s.substring(i, i + 1));
            if (curr > 26 || curr == 0) {
                break;
            }
            decodeWays += decode(s, i + 1, map);
            //caching the index and the no of ways to decode till the idx.
            if (!map.containsKey(idx)) {
                map.put(i + 1, decodeWays);           
            }
        }
        return decodeWays;
    }
}
