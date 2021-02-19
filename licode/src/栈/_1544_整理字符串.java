package 栈;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _1544_整理字符串 {
    public String makeGood(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - arr[i]) == 32) {
                stack.pop();
                continue;
            }
            stack.push(arr[i]);
        }
        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return new String(res);
    }
}
