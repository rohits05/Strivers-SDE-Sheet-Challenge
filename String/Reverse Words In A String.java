import java.util.*;
import java.io.*;

public class Solution {
    public static String reverseString(String str) {
        // Write your code here
        String trim = str.trim();
        String[] arr = trim.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--)
            result.append(arr[i] + " ");
        return result.toString();
    }
}
