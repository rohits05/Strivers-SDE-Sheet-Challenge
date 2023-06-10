import java.util.*;
import java.io.*;
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        int n = intervals.length;
        ArrayList<Interval> temp = new ArrayList<Interval>();

        if (n == 0 || intervals == null)
            return temp;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int first = intervals[0].start, last = intervals[0].finish;

        for (int i = 0; i < n; i++) {
            if (intervals[i].start <= last)
                last = Math.max(last, intervals[i].finish);
            else {
                temp.add(new Interval(first, last));
                first = intervals[i].start;
                last = intervals[i].finish;
            }
        }

        temp.add(new Interval(first, last));
        return temp;
    }
}
