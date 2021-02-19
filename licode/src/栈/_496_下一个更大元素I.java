package 栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _496_下一个更大元素I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextBigValue = new int[nums2.length];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nextBigValue.length; i++) {
            nextBigValue[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < nums2.length; i++) {
            if (stack.isEmpty() || nums2[stack.peek()] >= nums2[i]) {
                map.put(nums2[i],-1);
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    int index = stack.pop();
                    nextBigValue[index] = nums2[i];
                    map.put(nums2[index],nums2[i]);
                }
            }
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
