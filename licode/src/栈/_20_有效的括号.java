package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/submissions/
 */
public class _20_有效的括号 {
    public boolean isValid(String s) {
        if (s == null) return true;
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : cs) {

            if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            }else
            if (!stack.isEmpty() &&c == ']' && stack.peek() == '[') {
                stack.pop();
            }else
            if (!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                stack.pop();
            }else if (c == ' ') {
                continue;
            }
            else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }
}
