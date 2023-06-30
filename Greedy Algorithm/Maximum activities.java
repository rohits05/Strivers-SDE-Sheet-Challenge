import java.util.*;
import java.io.*;

class Meeting {
    int start, end, pos;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Sorted implements Comparator<Meeting> {
    public int compare(Meeting strt, Meeting ed) {
        return strt.end - ed.end;
    }
}

public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        // Write your code here
        int n = start.size(), m = end.size(), res = 1;
        List<Meeting> lis = new ArrayList<>();
        int len = lis.size();
        for (int i = 0; i < n; i++)
            lis.add(new Meeting(start.get(i), end.get(i)));

        Collections.sort(lis, new Sorted());
        // res.add(lis.get(0).pos);
        int temp = lis.get(0).end;
        for (int i = 1; i < lis.size(); i++) {
            if (lis.get(i).start >= temp) {
                // res.add(lis.get(i).pos);
                temp = lis.get(i).end;
                res++;
            }
        }

        return res;
    }
}