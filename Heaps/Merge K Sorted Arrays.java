import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        // Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            for (int j : kArrays.get(i))
                pq.add(j);
        }

        int i = 0;
        while (!pq.isEmpty())
            al.add(pq.poll());

        return al;
    }
}
