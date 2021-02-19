package 栈;

import java.util.Stack;

public class _1047_删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty() && stack.peek() == arr[i]) {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }
        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return new String(res);
    }
}
