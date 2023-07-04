import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {

    public void generate(Set<String> ans, int ind, String s, ArrayList<String> dictionary) {
        if (ind > s.length()) {
            String str = s;
            ans.add(str);
            return;
        }
        int temp = s.length();

        for (int i = ind + 1; i <= temp; ++i) {
            String str = s.substring(ind, i);
            if (dictionary.contains(str)) {
                if (i != temp)
                    s = s.substring(0, i) + " " + s.substring(i);
                generate(ans, i + 1, s, dictionary);
                if (i != temp)
                    s = s.substring(0, i) + s.substring(i + 1);
            }
        }

    }

    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        ArrayList<String> ans = new ArrayList<>();
        Set<String> temp = new HashSet<>();

        Solution S1 = new Solution();

        S1.generate(temp, 0, s, dictionary);
        ans.addAll(temp);

        return ans;
    }
}