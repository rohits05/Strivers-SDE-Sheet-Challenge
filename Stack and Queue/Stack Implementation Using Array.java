import java.util.*;
import java.io.*;

public class Stack {
    int[] arr;
    int top = -1, cnt;

    Stack(int capacity) {
        if (isFull() != 1) {
            arr = new int[capacity];
            this.cnt = capacity;
        }
    }

    int isFull() {
        if (top == cnt)
            return 1;
        else
            return 0;
    }

    void push(int num) {
        top = top + 1;
        arr[top] = num;
    }

    int pop() {
        if (isEmpty() != 1) {
            int x = arr[top];
            top = top - 1;
            return x;
        } else
            return -1;
    }

    int top() {
        if (isEmpty() != 1)
            return arr[top];
        else
            return -1;
    }

    int isEmpty() {
        if (top == -1)
            return 1;
        else
            return 0;
    }
}
