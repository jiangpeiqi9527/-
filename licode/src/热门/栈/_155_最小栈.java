package 热门.栈;

import java.util.Stack;

public class _155_最小栈 {
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        private Integer minElement;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
            minElement = Integer.MAX_VALUE;
        }

        public void push(int x) {
            minElement = minStack.isEmpty() ? x : Math.min(minStack.peek(),x);
            stack.push(x);
            minStack.push(minElement);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
