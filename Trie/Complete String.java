import java.util.*;
import java.io.*;

class Solution {
    private static C_Node root = new C_Node();

    public Solution() {
        root = new C_Node();
    }

    public static void insert(String word) {
        C_Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.contains(ch))
                node.add(ch, new C_Node());
            node = node.get(ch);
        }
        node.setIsEnd();
    }

    public static boolean checkIfPrefixExist(String a) {
        C_Node node = root;
        boolean flag = true;

        for (char ch : a.toCharArray()) {
            if (node.contains(ch)) {
                node = node.get(ch);
                flag = flag & node.getIsEnd();
            } else
                return false;
        }

        return flag;
    }

    public static String completeString(int n, String[] ar) {
        root = new C_Node();
        for (String a : ar)
            insert(a);

        String longest = "";
        for (String a : ar) {
            if (checkIfPrefixExist(a)) {
                if (a.length() > longest.length())
                    longest = a;
                else if (a.length() == longest.length() && a.compareTo(longest) < 0)
                    longest = a;
            }
        }

        if (longest.length() == 0)
            return "None";
        return longest;
    }

    static class C_Node {
        C_Node[] node = new C_Node[26];
        boolean isEnd = false;

        public C_Node() {
        }

        public boolean contains(char ch) {
            return node[ch - 'a'] != null;
        }

        public void add(char ch, C_Node nnode) {
            node[ch - 'a'] = nnode;
        }

        public C_Node get(char ch) {
            return node[ch - 'a'];
        }

        public void setIsEnd() {
            isEnd = true;
        }

        public boolean getIsEnd() {
            return isEnd;
        }
    }
}