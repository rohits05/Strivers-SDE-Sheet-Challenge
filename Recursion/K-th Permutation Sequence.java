import java.util.List;
import java.util.*;
import java.io.*;

public class Solution {
    public static String kthPermutation(int n, int k) {
        // Write your code here.
        int fact = 1;
        List<Integer> numb = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            fact *= i;
            numb.add(i);
        }

        numb.add(n);
        String ans = "";
        k = k - 1;
        while (true) {
            ans += numb.get(k / fact);
            numb.remove(k / fact);
            if (numb.size() == 0)
                break;

            k %= fact;
            fact /= numb.size();
        }

        return ans;
    }
}