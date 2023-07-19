public class Trie {
    private static trieNode root;

    // Initialize your data structure here
    Trie() {
        // Write your code here
        root = new trieNode();
    }

    // Inserts a word into the trie
    public static void insert(String str) {
        // Write your code here
        trieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            if (!node.containsKey(str.charAt(i))) {
                node.put(str.charAt(i), new trieNode());
            }
            node = node.get(str.charAt(i));

        }
        node.setEnd();
    }

    // Returns if the word is in the trie
    public static boolean search(String str) {
        // Write your code here
        trieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            if (!node.containsKey(str.charAt(i))) {
                return false;
            }
            node = node.get(str.charAt(i));
        }
        return node.isEnd();
    }

    // Returns if there is any word in the trie that starts with the given prefix
    public static boolean startsWith(String str) {
        // Write your code here
        trieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            if (!node.containsKey(str.charAt(i))) {
                return false;
            }
            node = node.get(str.charAt(i));
        }
        return true;
    }

    static class trieNode {
        trieNode[] trie = new trieNode[26];
        boolean flag = false;

        public trieNode() {
        }

        boolean containsKey(char ch) {
            return (trie[ch - 'a'] != null);
        }

        trieNode get(char ch) {
            return trie[ch - 'a'];
        }

        void put(char ch, trieNode node) {
            trie[ch - 'a'] = node;
        }

        void setEnd() {
            flag = true;
        }

        boolean isEnd() {
            return flag;
        }
    };
}