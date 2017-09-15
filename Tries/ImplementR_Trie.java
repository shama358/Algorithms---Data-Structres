/*Question
Implement a trie with insert, search, and startsWith methods.
*/

class RwayTrie {
    private class Node {
        private boolean EndofWord = false;
        private Node[] next = new Node[26];
    }
    Node root = new Node();
   
    /** Initialize your data structure here. */
    public RwayTrie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        put(word, root, 0);
        return;
    }
    private Node put (String word, Node x, int idx) {
        if (x == null) {
            x = new Node();
        }
        if (idx == word.length()) {
            x.EndofWord = true;
            return x;
        }
        x.next[word.charAt(idx) - 'a'] = put(word, x.next[word.charAt(idx) 
                                                          - 'a'], idx + 1);
        return x;    
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node x = search(word, root, 0);
        if (x == null || x.EndofWord == false) {
            return false;
        }
        return true;
        
    }
    private Node search(String word, Node x, int idx) {
        if (x == null) {
            return null;
        }
        if (idx == word.length()) {
            return x;
        }
        return search (word, x.next[word.charAt(idx) - 'a'], idx + 1);
    }
    
    /*Returns if there is any word in the trie starting with the given prefix.*/
    public boolean startsWith(String prefix) {
        Node pre = search(prefix, root, 0);
        if (pre == null) {
            return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */