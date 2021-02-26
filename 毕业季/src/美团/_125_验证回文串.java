package 美团;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _125_验证回文串 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        char[] arr = s.toCharArray();
        int index = 0;
        while (index < arr.length) {
            if ((arr[index] >= 48 && arr[index] <= 57) ||
                    (arr[index] >= 65 && arr[index] <= 88) ||
                    (arr[index] >= 97 && arr[index] <= 120)) {
                stack.push(arr[index]);
                queue.offer(arr[index]);
            }
        }

        while (!stack.isEmpty()) {
//            char c = stack.peek();
//            if (c >= 48 && c <= 57) {
//                boolean flag = stack.pop().equals(queue.poll());
//                if (!flag) return false;
//            } else {
//                char c1 = stack.pop();
//                char c2 = queue.poll();
//                boolean flag = c1 == c2;
//                if (!flag) {
//
//                }
//            }
            String s1 = new String();

        }
        return true;
    }
}
