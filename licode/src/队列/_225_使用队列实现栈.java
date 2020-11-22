package 队列;

import java.util.LinkedList;
import java.util.Queue;

public class _225_使用队列实现栈 {
    private Queue<Integer> queue;
    private int size;
    /** Initialize your data structure here. */
    public _225_使用队列实现栈() {
        queue = new LinkedList();
        size = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
        size++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        size--;
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
