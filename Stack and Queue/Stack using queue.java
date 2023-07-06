import java.util.*;
import java.io.*;

public class Stack {
    // Define the data members.
    Deque<Integer> que;

    public Stack() {
        // Implement the Constructor.
        que = new ArrayDeque<Integer>();
    }

    /*----------------- Public Functions of Stack -----------------*/

    public int getSize() {
        // Implement the getSize() function.
        return que.size();
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function.
        if (que.isEmpty())
            return true;
        return false;
    }

    public void push(int element) {
        // Implement the push(element) function.
        que.push(element);
    }

    public int pop() {
        // Implement the pop() function.
        if (isEmpty())
            return -1;
        return que.poll();
    }

    public int top() {
        // Implement the top() function.
        if (isEmpty())
            return -1;
        return que.getFirst();
    }
}