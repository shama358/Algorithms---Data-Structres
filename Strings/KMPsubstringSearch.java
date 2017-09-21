/* Question
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle 
is not part of haystack.
*/

class Solution {
    public int strStr(String haystack, String needle) {
        //early exit conditions
         if (haystack.length() == 0 || needle.length() == 0) {
            if (haystack.length() == 0 && needle.length() != 0) {
                return -1;
            }
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int[][] dfa = new int[26][needle.length()];
        //construct DFA
        DFAMachine(dfa, needle);
        int state = 0;
        //KMP search
        for (int i = 0; i < haystack.length(); ++i) {
            state = dfa[haystack.charAt(i) - 'a'][state];
            if (state == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
        
    }
    //construction of DFA from the needle
    private void DFAMachine(int[][] dfa, String needle) {
        int x = 0;
        dfa[needle.charAt(0) - 'a'][0] = 1;
        for (int i = 1, k = 1; i < needle.length(); ++i) {
            //copy the value of x to the current column.
            for (int j = 0; j < 26; ++j) {
                dfa[j][i] = dfa[j][x];
            }
            //match transition
            dfa[needle.charAt(i) - 'a'][i] = ++k;
            //update the value of 'x'
            x = dfa[needle.charAt(i) - 'a'][x];
        }
    }
}