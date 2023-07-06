import java.util.*;

public class Queue {
    // Define the data members(if any) here.
    Stack<Integer> queue;
    Stack<Integer> temp;

    Queue() {
        // Initialize your data structure here.
        queue = new Stack<Integer>();
        temp = new Stack<Integer>();
    }

    void enQueue(int val) {
        // Implement the enqueue() function.
        queue.push(val);
        // while(!temp.empty()) queue.push(temp.pop());
    }

    int deQueue() {
        // Implement the dequeue() function.
        if (isEmpty())
            return -1;
        while (!queue.isEmpty())
            temp.push(queue.pop());

        int rem = temp.pop();
        while (!temp.isEmpty())
            queue.push(temp.pop());

        return rem;
    }

    int peek() {
        // Implement the peek() function here.
        if (isEmpty())
            return -1;
        while (!queue.isEmpty())
            temp.push(queue.pop());

        int out = temp.peek();

        while (!temp.isEmpty())
            queue.push(temp.pop());
        return out;
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here.
        return queue.isEmpty();
    }
}