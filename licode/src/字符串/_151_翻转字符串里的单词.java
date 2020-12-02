package 字符串;



import java.util.Stack;

public class _151_翻转字符串里的单词 {
    public String method(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int i = 0;
        Stack<String> stack = new Stack<>();
        while (i < len) {
            StringBuilder sb = new StringBuilder();
            for (; i < len; i++) {
                if (arr[i] == ' ') {break;}
                sb.append(arr[i]);
            }
            i++;
            if (sb.toString().length() == 0) continue;
            stack.push(sb.toString());
        }
        StringBuilder res = new StringBuilder();
        while (stack.size() > 1) {
            res.append(stack.pop() + " ");
        }
        res.append(stack.pop());
        return res.toString();
    }


}
