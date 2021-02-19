package 栈;

import java.util.Stack;

public class _剑指_Offer_09_用两个栈实现队列 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public _剑指_Offer_09_用两个栈实现队列() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}
