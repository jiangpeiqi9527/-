package 栈;

import java.util.Stack;

public class _150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                Integer num1 = Integer.parseInt(stack.pop());
                Integer num2 = Integer.parseInt(stack.pop());
                Integer sum = num1 + num2;
                stack.push(sum.toString());
            } else if ("-".equals(tokens[i])) {
                Integer num1 = Integer.parseInt(stack.pop());
                Integer num2 = Integer.parseInt(stack.pop());
                Integer sum = num1 - num2;
                stack.push(sum.toString());
            } else if ("*".equals(tokens[i])) {
                Integer num1 = Integer.parseInt(stack.pop());
                Integer num2 = Integer.parseInt(stack.pop());
                Integer sum = num1 * num2;
                stack.push(sum.toString());
            } else if ("/".equals(tokens[i])) {
                Integer num1 = Integer.parseInt(stack.pop());
                Integer num2 = Integer.parseInt(stack.pop());
                Integer sum = num1 / num2;
                stack.push(sum.toString());
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
