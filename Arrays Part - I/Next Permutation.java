import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void swap(ArrayList<Integer> permutation, int i, int j) {
        int temp = permutation.get(i);
        permutation.set(i, permutation.get(j));
        permutation.set(j, temp);
    }

    public static void reverse(ArrayList<Integer> permutation, int i, int j) {
        while (i < j)
            swap(permutation, i++, j--);
    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
        // Write your code here.
        int n = permutation.size(), idx1 = -1, idx2 = -1;
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = n - 2; i >= 0; i--) {
            if (permutation.get(i) < permutation.get(i + 1)) {
                idx1 = i;
                break;
            }
        }

        if (idx1 == -1) { // Bound
            reverse(permutation, 0, n - 1);
            for (int i = 0; i < n; i++)
                temp.add(permutation.get(i));
            return temp;
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (permutation.get(i) > permutation.get(idx1)) {
                    idx2 = i;
                    break;
                }
            }
        }

        swap(permutation, idx1, idx2);
        reverse(permutation, idx1 + 1, n - 1);

        for (int i = 0; i < n; i++)
            temp.add(permutation.get(i));
        return temp;
    }
}
