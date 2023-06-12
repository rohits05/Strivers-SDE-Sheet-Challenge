import java.io.*;
import java.util.*;

public class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        // Write your code here.
        if (m == 1)
            return 0;
        long ans = 1, temp = x % m;

        while (n > 0) {
            if (n % 2 == 1)
                ans = (ans * temp) % m;
            n = n >> 1;
            long bCal = temp * temp;
            temp = bCal % m;
        }

        return (int) ans;
    }
}