import java.util.*;
import java.io.*;

public class Solution {
    public static boolean isPosssible(int arr[], long n, long m, long mid) {
        int StudentCount = 1;
        long timeSum = 0;
        for (int i = 0; i < m; i++) {
            if (timeSum + arr[i] <= mid) {
                timeSum += arr[i];
            } else {
                StudentCount++;
                if (StudentCount > n || arr[i] > mid) {
                    return false;
                }

                timeSum = arr[i];
            }
        }

        return true;
    }

    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        long startTime = 0, totalStudyTime = 0;
        long minimalMaxTime = -1;

        for (int i = 0; i < m; i++)
            totalStudyTime += time[i];

        long endTime = totalStudyTime, midTime = startTime + (endTime - startTime) / 2;
        while (startTime <= endTime) {
            if (isPosssible(time, n, m, midTime)) {
                minimalMaxTime = midTime;
                endTime = midTime - 1;
            } else {
                startTime = midTime + 1;
            }
            midTime = startTime + (endTime - startTime) / 2;
        }

        return minimalMaxTime;
    }
}