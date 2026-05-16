public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();// takes in character to get end of a word
    boolean endOfWord = false; //default
}

public class PrefixTree {
    private TrieNode root; //current

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) { //create a new word
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode()); // put if !contains(c)
            cur = cur.children.get(c);
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}