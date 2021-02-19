package 栈;

import java.util.Stack;

public class _剑指_Offer_30_包含min函数的栈 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private Integer minNum;

    /** initialize your data structure here. */
    public _剑指_Offer_30_包含min函数的栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        minNum = stack.isEmpty() ? x : Math.min(minNum,x);
        stack.push(x);
        minStack.push(minNum);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.pop();
    }
}
