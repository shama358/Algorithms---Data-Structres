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
        /*arr array of size n + 1 to save subproblem solutions. 
        arr[0] means an empty string will have one way to decode, 
        arr[1] means the way to decode a string of size 1.
        check one digit and two digit combination and save the results along the 
        way. In the end, arr[n] will be the end result.*/
        int[] arr = new int[s.length() + 1];
        arr[0] = 1;
        arr[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= s.length(); ++i) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first > 0 && first < 10) {
                arr[i] += arr[i - 1];
            }
            if (second > 9 && second < 27) {
                arr[i] += arr[i - 2];
            }
        }
        return arr[s.length()];
    }
}
