/*Question
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle 
is not part of haystack.
*/

class Solution {
    public int strStr(String haystack, String needle) {
        //early exits
        if (haystack.length() == 0 || needle.length() == 0) {
            if (haystack.length() == 0 && needle.length() != 0) {
                return -1;
            }
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int idx = 0;
        //brute-force search for substring
        for (int i = 0; i <= haystack.length() - 1; ++i) {
            int j = 0;
            if (haystack.charAt(i) == needle.charAt(j)) {
                while ((j <= needle.length() - 1) && haystack.length() - i 
                       >= needle.length() 
                       && i + j < haystack.length() && (haystack.charAt(i + j) 
                                                        == needle.charAt(j))) {
                    ++j;
                }
                if (j == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}