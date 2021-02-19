package 栈;

import java.util.Stack;

public class _844_比较含退格的字符串 {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return S != null ? false : T == null;
        char[] arr1 = S.toCharArray();
        char[] arr2 = T.toCharArray();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        putArrToStack(arr1,stack1);
        putArrToStack(arr2,stack2);
        return hasSameValue(stack1,stack2);
    }

    private void putArrToStack(char[] arr, Stack<Character> stack) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '#') {
                if (!stack.isEmpty()) stack.pop();
                continue;
            }
            stack.push(arr[i]);
        }
    }

    private boolean hasSameValue(Stack<Character> stack1, Stack<Character> stack2) {
        if (stack1.size() != stack2.size()) return false;
        while (!stack1.isEmpty()) {
            if (stack1.pop() != stack2.pop()) return false;
        }
        return true;
    }
}
