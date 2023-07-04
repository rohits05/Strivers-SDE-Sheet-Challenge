import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Solution {
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        // Write your code here.
        int n = matrix.size(), m = matrix.get(0).size();
        ArrayList<Integer> li = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                li.add(matrix.get(i).get(j));
        }

        Collections.sort(li);
        int temp = li.size() / 2;
        return li.get(temp);
    }
}