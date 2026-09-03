// Problem: Implement Trie (Prefix Tree)
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/implement-trie-prefix-tree/
// Solved on: 2026-09-03T08:15:24.425Z

class TrieNode {
    public boolean isWord;
    public TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    } 
}
class Trie {
   TrieNode root;
      public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode current_node  = root;
        for(int  i = 0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(current_node.children[index]==null){
            current_node.children[index] = new TrieNode();
            }
            current_node = current_node.children[index];
        }
        current_node.isWord = true;
        
    }
    
    public boolean search(String word) {
            TrieNode current_node = root;
    for (int i = 0; i < word.length(); i++) {
        int index = word.charAt(i) - 'a';
        if (current_node.children[index] == null) return false;
        current_node = current_node.children[index];
    }
    return current_node.isWord;
}
    
    public boolean startsWith(String prefix) {
            TrieNode current_node = root;
    for (int i = 0; i < prefix.length(); i++) {
        int index = prefix.charAt(i) - 'a';
        if (current_node.children[index] == null) return false;
        current_node = current_node.children[index];
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