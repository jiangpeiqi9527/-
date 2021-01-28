package 热门.栈;

import java.util.Stack;

public class _739_每日温度 {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length < 2) return new int[]{};
        Stack<Integer> stack = new Stack<>();
        int[] minDayToUp = new int[T.length];
        for (int i = 0; i < minDayToUp.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                minDayToUp[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return minDayToUp;
    }
}
