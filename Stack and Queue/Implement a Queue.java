import java.util.*;
import java.io.*;

public class Queue {
    int[] que;
    int f, r;

    Queue() {
        // Implement the Constructor
        que = new int[1024];
        f = 0;
        r = 0;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        if (f == r)
            return true;
        return false;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        if (r < 1024)
            que[r++] = data;
    }

    int dequeue() {
        // Implement the dequeue() function
        if (f != r)
            return que[f++];
        return -1;
    }

    int front() {
        // Implement the front() function
        if (f != r)
            return que[f];
        return -1;
    }

}
