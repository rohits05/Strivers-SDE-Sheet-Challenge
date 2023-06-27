import java.util.*;
import java.io.*;

class Meeting {
    int start, end, pos;

    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class Sorted implements Comparator<Meeting> {
    public int compare(Meeting strt, Meeting ed) {
        return strt.end - ed.end;
    }
}

public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        int n = start.length, m = end.length;
        List<Integer> res = new ArrayList<>();
        ArrayList<Meeting> lis = new ArrayList<>();
        int len = lis.size();
        for (int i = 0; i < n; i++)
            lis.add(new Meeting(start[i], end[i], i + 1));

        Collections.sort(lis, new Sorted());
        res.add(lis.get(0).pos);
        int temp = lis.get(0).end;
        for (int i = 1; i < lis.size(); i++) {
            if (lis.get(i).start > temp) {
                res.add(lis.get(i).pos);
                temp = lis.get(i).end;
            }
        }

        return res;
    }
}
