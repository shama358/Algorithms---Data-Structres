/* Question
Implement a trie with insert, search, and startsWith methods.
*/

class TSTTrie {
    private class Node {
        private boolean EndofWord = false;
        private Node left, right ,mid;
        private char c;
    }
    Node root;
   
    /** Initialize your data structure here. */
    public TSTTrie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root = put(word, root, 0);
        return;
    }
    
    private Node put (String word, Node x, int idx) {
        if (x == null) {
            x = new Node();
            x.c = word.charAt(idx);
        }
        int cmp = less(x.c, word.charAt(idx));
        if (cmp < 0) {
            x.right = put(word, x.right, idx);
        } else if (cmp > 0) {
            x.left = put(word, x.left, idx);
        } else if (idx < word.length() - 1) {
            x.mid = put(word, x.mid, idx + 1);
        } else {
            x.EndofWord = true;
        }
        return x;
    }
    private int less(char a, char b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
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
        int cmp = less(x.c, word.charAt(idx));
        if (cmp < 0) {
            return search(word, x.right, idx);
        } else if (cmp > 0) {
            return search(word, x.left, idx);
        } else if (idx < word.length() - 1){
            return search(word, x.mid, idx + 1);
        } else {
            return x;
        }
    }
    
    /*Returns if there is any word in the trie starting with the given prefix.*/
    public boolean startsWith(String prefix) {
        Node pre = search(prefix, root, 0);
        if (pre == null){
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