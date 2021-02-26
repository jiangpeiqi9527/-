package 栈;

import java.util.Stack;

public class _20_有效的括号 {

    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            if (arr[i] == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            if (arr[i] == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                    continue;
                } else {
                    return false;
                }
            }
            stack.push(arr[i]);
        }
        return stack.isEmpty() ? true : false;
    }

}
