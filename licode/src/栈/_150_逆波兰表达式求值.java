package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class _150_逆波兰表达式求值 {
    public static void main(String[] args) {
        int i = evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(i);
    }
    public static int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        Stack<Integer> stack = new Stack<>();
        Integer sum = 0;
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                sum = pop1 + pop2;
                stack.push(sum);
            }else if ("-".equals(tokens[i])) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                sum = pop2 - pop1;
                stack.push(sum);
            }else if ("*".equals(tokens[i])) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                sum = pop1 * pop2;
                stack.push(sum);
            }else if ("/".equals(tokens[i])) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                sum = pop2 / pop1;
                stack.push(sum);
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return sum;
    }
}
