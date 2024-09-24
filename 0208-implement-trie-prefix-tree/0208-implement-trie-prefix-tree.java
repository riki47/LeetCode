public class TrieNode
{
    TrieNode children[];
    boolean eow;
    public TrieNode()
    {
        children = new TrieNode[26];
        eow = false;
        for(int i = 0; i<26; i++)
        {
            children[i] = null;
        }
    }
}

class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode root1 = root;
        for(int i = 0; i < word.length(); i++)
        {
            int idx = word.charAt(i)-'a';
            if(root1.children[idx] == null)
                root1.children[idx] = new TrieNode();
            if(i == word.length()-1)
                root1.children[idx].eow = true;
            root1 = root1.children[idx];
        }
    }
    
    public boolean search(String word) {
        TrieNode root1 = root;
        for(int i = 0; i < word.length(); i++)
        {
            int idx = word.charAt(i)-'a';
            if(root1.children[idx] == null)
                return false;
            if(i == word.length()-1 && root1.children[idx].eow == false)
                return false;
            root1 = root1.children[idx];
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode root1 = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            int idx = prefix.charAt(i)-'a';
            if(root1.children[idx] == null)
                return false;
            root1 = root1.children[idx];
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