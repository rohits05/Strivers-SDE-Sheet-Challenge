import java.util.*;
import java.io.*;

public class Solution {

    public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
        // WRITE YOUR CODE HERE
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        generatePowerSet(arr, result, subset, 0);
        return result;
    }

    public static void generatePowerSet(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> result,
            ArrayList<Integer> subset, int index) {
        if (index == arr.size()) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(arr.get(index));
        generatePowerSet(arr, result, subset, index + 1);
        subset.remove(subset.size() - 1);

        generatePowerSet(arr, result, subset, index + 1);
    }
}
