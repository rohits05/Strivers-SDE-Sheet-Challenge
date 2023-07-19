import java.util.*;
import java.io.*;

public class Solution {
    public static Trie insert(Trie root, int n) {
        Trie temp = root;
        int i = 0;

        while (i < 32) {
            int num = (n >> (31 - i)) & 1;
            if (temp.children[num] != null)
                temp = temp.children[num];
            else {
                temp.children[num] = new Trie();
                temp = temp.children[num];
            }
            i++;
        }

        return root;
    }

    public static int maxxor(Trie root, int n) {
        int i = 0, ans = 0;
        Trie temp = root;

        while (i < 32) {
            int num = (n >> (31 - i)) & 1;

            if (num == 0 && temp.children[1] != null) {
                ans += (int) Math.pow(2, 31 - i);
                temp = temp.children[1];
            } else if (num == 1 && temp.children[0] != null) {
                ans += (int) Math.pow(2, 31 - i);
                temp = temp.children[0];
            } else
                temp = temp.children[num];
            i++;
        }

        return ans;
    }

    public static int maximumXor(int[] A) {
        int ans = 0;
        Trie root = new Trie();

        for (int i = 0; i < A.length; i++)
            root = insert(root, A[i]);
        for (int i = 0; i < A.length; i++)
            ans = Math.max(ans, maxxor(root, A[i]));

        return ans;
    }

    static class Trie {
        Trie[] children;

        Trie() {
            children = new Trie[2];
            children[0] = null;
            children[1] = null;
        }
    }
}
