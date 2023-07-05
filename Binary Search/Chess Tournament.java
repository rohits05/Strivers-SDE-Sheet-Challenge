import java.util.*;
import java.io.*;

public class Solution {

    public static int chessTournament(int[] arr, int n, int c) {
        // Write your code here.
        Arrays.sort(arr);
        int startPosi = 0;
        int endPosi = arr[n - 1];

        int ans = -1;

        while (startPosi <= endPosi) {
            int mid = startPosi + (endPosi - startPosi) / 2;

            if (isPossible(arr, mid, c, n)) {
                ans = mid;
                startPosi = mid + 1;
            } else
                endPosi = mid - 1;
        }

        return ans;
    }

    static boolean isPossible(int[] positions, int maxSpace, int players, int n) {
        // who got allocated room
        int Currplayers = 1, lastPos = positions[0];
        for (int i = 0; i < n; i++) {
            if (positions[i] - lastPos >= maxSpace) {
                Currplayers++;
                if (Currplayers > players)
                    return false;
                if (Currplayers == players)
                    return true;
                lastPos = positions[i];
            }
        }

        return false;
    }
}