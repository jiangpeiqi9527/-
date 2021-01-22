package 其他;


import org.junit.Test;

import java.util.Stack;

public class _151_翻转字符串里的单词 {
    public String reverseWords(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int i = 0;
        Stack<String> stack = new Stack<>();
        while (i < len) {
            StringBuilder sb = new StringBuilder();
            for (; i < len; i++) {
                if (arr[i] == ' ') {
                    break;
                }
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

    // 恋上数据结构的思路
    // 先得到一个去掉两端空格，中间多余空格的字符数组
    // 然后整体翻转
    // 然后一个单词一个单词的翻转（除最后一个单词）
    // 翻转最后一个单词
    public String reverseWords2(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int cur = 0;
        int realLen = 0;
        // 前一个字符是否为空格
        boolean space = true;
        for (int i = 0; i < len; i++) {
            if (arr[i] != ' ') {
                arr[cur++] = arr[i];
                space = false;
            } else if (space == false) {
                arr[cur++] = ' ';
                space = true;
            }
        }
        realLen = space ? (cur - 1) : cur;
        reverse(arr,0,realLen);
        int prevSpace = -1;
        for (int i = 0; i < len; i++) {
//            if (arr[i] == ' ') {
//                reverse(arr,prevSpace + 1,i);
//                prevSpace = i;
//            }
            if (arr[i] != ' ') continue;
            // i是空格字符的位置
            reverse(arr, prevSpace + 1, i);
            prevSpace = i;
        }
        reverse(arr,prevSpace + 1,realLen);
        System.out.println("555_"+new String(arr, 0, realLen)+"_555");
        return new String(arr, 0, realLen);
    }

    private void reverse(char[] arr, int li, int ri) {
        ri--;
        while (li < ri) {
            char temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            li++;
            ri--;
        }
    }
    @Test
    public void test01() {
        reverseWords2(" M6eAL   RxnYFfCA kibo     oEw    z36tp     kufsBMitF K  sMG A 1 H io");
    }

}
