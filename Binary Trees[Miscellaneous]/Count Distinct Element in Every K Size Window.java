import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
        // Write your code here
        int n = arr.size();
        ArrayList<Integer> answer = new ArrayList<>(n - k + 1);
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < k; i++) {
            int count = freqMap.getOrDefault(arr.get(i), 0);
            freqMap.put(arr.get(i), count + 1);
        }

        answer.add(freqMap.size());

        for (int index = k; index < n; index++) {
            int elementToRemove = arr.get(index - k);
            int countToRemove = freqMap.get(elementToRemove);
            if (countToRemove == 1)
                freqMap.remove(elementToRemove);
            else
                freqMap.put(elementToRemove, countToRemove - 1);

            int elementToAdd = arr.get(index);
            int countToAdd = freqMap.getOrDefault(elementToAdd, 0);
            freqMap.put(elementToAdd, countToAdd + 1);

            answer.add(freqMap.size());
        }

        return answer;
    }
}
