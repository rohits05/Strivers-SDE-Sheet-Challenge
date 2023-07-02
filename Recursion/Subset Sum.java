import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        int N = num.length;
        ArrayList<Integer> s = new ArrayList<>();

        func(0, 0, num, N, s);
        Collections.sort(s);
        return s;
    }

    static void func(int i, int sum, int arr[], int N, ArrayList<Integer> s) {
        if (i == N) {
            s.add(sum);
            return;
        }

        func(i + 1, sum + arr[i], arr, N, s); // take
        func(i + 1, sum, arr, N, s); // nTake
    }
}