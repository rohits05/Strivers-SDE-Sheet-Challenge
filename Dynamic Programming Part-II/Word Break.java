import java.util.*;
import java.io.*;

public class Solution {

    public static Boolean wordBreak(String[] arr, int n, String target) {
        // Write your code here.
        int i = 0;
        while (i < n) {
            if (target.indexOf(arr[i]) != -1)
                target = target.replaceFirst(arr[i], "");
            else
                i++;
        }

        if (target.length() == 0)
            return true;
        else
            return false;
    }
}