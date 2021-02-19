package 栈;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _1021_删除最外层的括号 {
    public String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) return S;
        char[] arr = S.toCharArray();
        Queue<Character> stack = new LinkedList<>();
        int leftCount = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < arr.length) {
            if (arr[index] == '(') {
                leftCount++;
                stack.offer(arr[index]);
            } else {
                leftCount--;
                if (leftCount == 0) {
                    stack.poll();
                    while (!stack.isEmpty()) {
                        sb.append(stack.poll());
                    }
                } else {
                    stack.offer(arr[index]);
                }
            }
            index++;
        }
        return sb.toString();
    }
}
