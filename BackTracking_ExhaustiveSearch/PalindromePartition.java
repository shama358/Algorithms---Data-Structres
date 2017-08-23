/* Question
Given a string s, partition s such that every substring of the partition is a 
palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<List<String>>();
        ArrayList<String> interRes = new ArrayList<String>();
        partitionRec(s, res, interRes, 0);
        return res;
    }
    private void partitionRec(String s, List<List<String>> res, 
							  ArrayList<String> interRes, int idx) {
        //add to res when you have reached the end of the string once.
        if (idx == s.length()) {
            res.add(new ArrayList<String>(interRes));
            return;
        }
        //for loop as you can partition from anywhere.
        for (int i = idx; i < s.length(); ++i) {
            //call rec func and clean-up only if the substring is a palindrome.
            if (isPalindrome(s, idx, i)) {
                interRes.add(s.substring(idx,i + 1));
                partitionRec(s, res, interRes, i + 1);
                interRes.remove(interRes.size() - 1);
            }
        }
    }
    private boolean isPalindrome (String s, int i, int j) {
        if (i == j) {
            return true;
        }
        while ( i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}