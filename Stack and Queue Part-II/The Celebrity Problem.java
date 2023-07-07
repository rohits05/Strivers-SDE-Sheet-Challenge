import java.util.*;
import java.io.*;
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/

public class Solution {
    public static int findCelebrity(int n) {
        // Write your code here.
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++)
            s.push(i);

        while (s.size() > 1) {
            int a = s.pop(), b = s.pop();
            if (Runner.knows(a, b))
                s.push(b);
            else
                s.push(a);
        }

        int cele = s.peek(), celeKnows = 0;
        boolean cCheck = false;

        for (int i = 0; i < n; i++)
            if (Runner.knows(cele, i))
                celeKnows++;

        if (celeKnows == 0)
            cCheck = true;
        int peopleKnows = 0;
        boolean peopleCheck = false;

        for (int i = 0; i < n; i++) {
            if (Runner.knows(i, cele))
                peopleKnows++;
        }

        if (peopleKnows == n - 1)
            peopleCheck = true;

        if (peopleCheck && cCheck)
            return cele;
        else
            return -1;
    }
}