
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;
import java.io.*;

public class Solution {

    public static void findMedian(int arr[]) {
        /*
         * Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if (arr.length == 0)
            return;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        System.out.print(arr[0] + " ");
        max.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= max.peek()) {
                max.add(arr[i]);
            } else
                min.add(arr[i]);
            if (max.size() > min.size() + 1)
                min.add(max.remove());
            else if (min.size() > max.size())
                max.add(min.remove());
            if (max.size() == min.size())
                System.out.print((int) (max.peek() + min.peek()) / 2 + " ");
            else
                System.out.print(max.peek() + " ");
        }
    }
}