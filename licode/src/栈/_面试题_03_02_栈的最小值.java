package 栈;

import java.util.Stack;

public class _面试题_03_02_栈的最小值 {
    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    private Integer minNum;

    /**
     * initialize your data structure here.
     */
    public _面试题_03_02_栈的最小值() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        minNum = minStack.isEmpty() ? x : Math.min(minNum, x);
        stack.push(x);
        minStack.push(minNum);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        minNum = minStack.isEmpty() ? 0 : minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minNum;
    }
}
