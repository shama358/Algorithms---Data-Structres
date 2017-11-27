/* Question
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid 
answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/


class Solution {
    public String frequencySort(String s) {
        //early exit
        if (s == null || s.length() == 0) {
            return "";
        }
        //key -> character ; value -> frequency of the character
        HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.containsKey(s.charAt(i))) {
                frequency.put(s.charAt(i), frequency.get(s.charAt(i)) + 1);
            } else {
                frequency.put (s.charAt(i), 1);
            }
        }
        //building maxHeap, with frequency being the parameter for comparison
        PriorityQueue<freq> maxHeap = new PriorityQueue<freq>(frequency.size(), 
                new Comparator<freq>() {
            public int compare(freq f1, freq f2) {
                if (f1.count >= f2.count) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (Map.Entry<Character, Integer> m : frequency.entrySet()) {
            maxHeap.add(new freq(m.getKey(), m.getValue()));
        }
        //emptying the maxHeap to the resultant string
        StringBuilder res = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            freq tmp = maxHeap.poll();
            for (int i = 1; i <= tmp.count; ++i) {
                res.append(tmp.c);
            }
        }
        return res.toString();       
    }
    //Class having the character and frequency of each char in string s
    private class freq {
        char c;
        int count;
        freq(char c, int f) {
            this.c = c;
            count = f;
        }
    }
}