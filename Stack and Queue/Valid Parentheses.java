import java.util.*;

public class Solution {
    public static boolean isValidParenthesis(String expression) {
        // Write your code here.
        Stack<Character> st = new Stack<>();
        int len = expression.length();

        for (int i = 0; i < len; i++) {
            char a = expression.charAt(i);

            if (a == '(' || a == '[' || a == '{')
                st.push(a);
            else if (st.empty())
                return false;
            else if (a == ')' && st.pop() != '(')
                return false;
            else if (a == '}' && st.pop() != '{')
                return false;
            else if (a == ']' && st.pop() != '[')
                return false;
        }

        return st.empty();
    }
}