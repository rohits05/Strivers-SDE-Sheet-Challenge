import java.util.*;
import java.io.*;

public class Solution {

    public static void sortStack(Stack<Integer> stack) {
        // Write your code here.
        if (stack.isEmpty())
            return;

        int x = stack.peek();
        stack.pop();

        sortStack(stack);
        funcS(stack, x);
    }

    public static void funcS(Stack<Integer> stack, int x) {
        if (stack.isEmpty() || (!stack.isEmpty() && stack.peek() < x)) {
            stack.push(x);
            return;
        }

        int top = stack.peek();
        stack.pop();

        funcS(stack, x);
        stack.push(top);
    }
}